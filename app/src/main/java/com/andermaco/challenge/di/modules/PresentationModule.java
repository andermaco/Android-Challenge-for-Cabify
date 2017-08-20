package com.andermaco.challenge.di.modules;

import android.app.Activity;

import com.andermaco.challenge.view.common.utils.AndroidRouter;
import com.andermaco.challenge.view.common.utils.Router;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andermaco@gmail.com on 31/07/17.
 */

@Module
public class PresentationModule {

    Activity activity;

    public PresentationModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public Router provideRouter() {
        return new AndroidRouter(activity);
    }

}
