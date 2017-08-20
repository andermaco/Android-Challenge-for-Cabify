package com.andermaco.challenge.di.modules.views;

import com.andermaco.challenge.di.scopes.PerActivity;
import com.andermaco.challenge.view.activity.Loading;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;
import com.andermaco.challenge.view.presenter.LoadingPresenter;
import com.andermaco.challenge.view.activity.LoadingView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andermaco@gmail.com on 30/07/17.
 */

@Module
public class LoadingViewModule {
    private final Loading loading;

    public LoadingViewModule(Loading loading) {
        this.loading = loading;
    }

    @PerActivity
    @Provides
    public LoadingView provideLoadingActivity() {
        return this.loading;
    }

    @PerActivity
    @Provides
    public LoadingPresenter provideLoadingPresenter(LoadingView view, Router router,
                                                    ResourceManager resourceManager) {
        return new LoadingPresenter(view, router, resourceManager);
    }
}
