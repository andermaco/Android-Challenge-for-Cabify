package com.andermaco.challenge.di.modules.interactors;

import com.andermaco.challenge.BuildConfig;
import com.andermaco.challenge.di.scopes.PerActivity;
import com.andermaco.challenge.data.network.AndroidService;
import com.andermaco.challenge.data.network.GetEstimatesService;
import com.andermaco.challenge.data.network.NetworkService;

import java.io.File;
import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by andermaco@gmail.com on 2/08/17.
 */

@Module
public class GetEstimateModule {
    private File cacheFile;

    public GetEstimateModule(File cacheFile) {
        this.cacheFile = cacheFile;
    }

    @PerActivity
    @Provides
    Retrofit provideCall() {
        Cache cache = null;
        try {
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        // Customize the request
                        Request request = original.newBuilder()
                                .header("Content-Type", "application/json")
                                .header("Authorization", "Bearer 6o_FrppOEQ5RrCkBOEKaBM-puJleMKrRn5nW_cy7H9Y")
                                .header("Accept-Language", "en")
                                .header("Cache-Control", String.format("max-age=%d", BuildConfig.CACHETIME))
                                .build();

                        okhttp3.Response response = chain.proceed(request);
                        response.cacheResponse();
                        // Customize or return the response
                        return response;
                    }
                })
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .cache(cache)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @PerActivity
    @Provides
    @SuppressWarnings("unused")
    public NetworkService providesNetworkService(
             Retrofit retrofit) {
        return retrofit.create(NetworkService.class);
    }

    @PerActivity
    @Provides
    @SuppressWarnings("unused")
    public GetEstimatesService providesService(NetworkService networkService) {
        return new AndroidService(networkService);
    }
}
