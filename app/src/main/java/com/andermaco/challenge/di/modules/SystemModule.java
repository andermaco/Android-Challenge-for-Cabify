package com.andermaco.challenge.di.modules;

import android.content.Context;

import com.andermaco.challenge.view.common.utils.AndroidResourceManager;
import com.andermaco.challenge.view.common.utils.ResourceManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andermaco@gmail.com on 31/07/17.
 */

@Module
public class SystemModule {

    @Provides
    public ResourceManager provideResourceManager(Context context) {
        return new AndroidResourceManager(context);
    }

}
