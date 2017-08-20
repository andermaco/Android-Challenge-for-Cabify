package com.andermaco.challenge.di.modules;

import android.content.Context;


import com.andermaco.challenge.App;
import com.andermaco.challenge.di.scopes.PerApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andermaco@gmail.com on 27/07/17.
 */

/**
 * Module that provides dependencies for application
 * Must be injected in main app component
 */
@Module
public class ApplicationModule {

    private final App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @PerApplication
    @Provides
    public App provideApplication() {
        return application;
    }

    @PerApplication
    @Provides
    public Context provideContext() {
        return application;
    }

}
