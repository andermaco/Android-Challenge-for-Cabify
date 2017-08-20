package com.andermaco.challenge.data.network;

import com.andermaco.challenge.common.error.NetworkError;
import com.andermaco.challenge.domain.model.Estimate;
import com.andermaco.challenge.domain.model.EstimateListResponse;
import com.andermaco.challenge.domain.model.StopListRequest;
import java.util.ArrayList;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andermaco@gmail.com
 */
public class AndroidService implements GetEstimatesService {
    private final NetworkService networkService;

    public AndroidService(NetworkService networkService) {
        this.networkService = networkService;
    }

    @Override
    public DisposableObserver getStopList(final StopListRequest request,
                                          final GetStopListCallback callback) {
        return  networkService.getEstimateList(request)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends EstimateListResponse>>() {
                    @Override
                    public ObservableSource<? extends EstimateListResponse> apply(Throwable throwable) throws Exception {
                        return Observable.error(throwable);
                    }
                })
                .subscribeWith(new DisposableObserver<ArrayList<Estimate>>() {
                    @Override
                    public void onNext(ArrayList<Estimate> value) {
                        callback.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public interface GetStopListCallback{
        void onSuccess(ArrayList<Estimate> estimateListEntityResponse);

        void onError(NetworkError networkError);
    }
}
