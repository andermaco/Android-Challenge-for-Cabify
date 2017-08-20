package com.andermaco.challenge.di.components;

import android.content.Context;

import com.andermaco.challenge.App;
import com.andermaco.challenge.di.modules.ApplicationModule;
import com.andermaco.challenge.di.modules.SystemModule;
import com.andermaco.challenge.di.scopes.PerApplication;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import dagger.Component;

@PerApplication
@Component(modules = {
        ApplicationModule.class,
//TODO Uncomment for further use
//        BusModule.class,
        SystemModule.class
})
public interface ApplicationComponent {

    void inject(App application);

    Context getContext();


//TODO Uncomment for further use
//    @Named("interactorBus")
//    EventBus getInteractorBus();
//
//    @Named("modelBus")
//    EventBus getModelBus();

    ResourceManager getResourceManager();

}
