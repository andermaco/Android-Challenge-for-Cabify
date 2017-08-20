package com.andermaco.challenge.di.components.loading;

import com.andermaco.challenge.di.DiComponent;
import com.andermaco.challenge.di.components.ApplicationComponent;
import com.andermaco.challenge.di.modules.PresentationModule;
import com.andermaco.challenge.di.modules.views.LoadingViewModule;
import com.andermaco.challenge.di.scopes.PerActivity;
import com.andermaco.challenge.view.activity.Loading;

import dagger.Component;

/**
 * Created by andermaco@gmail.com on 30/07/17.
 */

@PerActivity
@Component (
        modules = {
//TODO Uncomment for further use
//                SystemModule.class,
                PresentationModule.class,
                LoadingViewModule.class
        },
        dependencies = {
                ApplicationComponent.class
        }
)

public interface LoadingComponent extends DiComponent {
    void inject(Loading loading);
}
