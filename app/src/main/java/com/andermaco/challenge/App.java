package com.andermaco.challenge;

import android.app.Application;
import android.content.Context;

import com.andermaco.challenge.di.components.ApplicationComponent;
import com.andermaco.challenge.di.components.DaggerApplicationComponent;
import com.andermaco.challenge.di.modules.ApplicationModule;
import com.andermaco.challenge.di.modules.SystemModule;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by andermaco@gmail.com on 27/07/17.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize application
        initApp();
    }

    /**
     * Initialize application
     */
    private void initApp() {
        setupInjector();
        initCrashlytics();
    }

    /**
     * Setup Crashlytics
     */
    private void initCrashlytics() {
        Fabric.with(this, new Crashlytics());
    }

    /**
     * Setup dagger 2 injector
     */
    private void setupInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
//                .busModule(new BusModule())  //TODO Uncomment for further use.
                .systemModule(new SystemModule())
                .build();
        applicationComponent.inject(this);
    }

    /**
     * Get an Application instance
     * @param context Current context
     * @return Application
     */

    public static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }

    /**
     * @return Dagger2's application component, so dependencies can be handled.
     */
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


}
