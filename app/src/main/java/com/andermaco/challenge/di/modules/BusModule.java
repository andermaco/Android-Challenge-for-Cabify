/*
 *
 * BusModule.java
 * Chatme
 *
 * Created by Juan on 3/16/16 10:54 AM.
 * Copyright © 2015-2016 NextChance USA, Inc. All rights reserved.
 */

package com.andermaco.challenge.di.modules;


import com.andermaco.challenge.di.scopes.PerApplication;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andermaco@gmail.com on 2/08/17.
 */

/**
 * Module that provides dependencies for application
 * Must be injected in main app component
 */
@Module
public class BusModule {

    @Provides
    @PerApplication
    @Named("modelBus")
    public EventBus provideModelBus() {
        return EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();
    }

    @Provides
    @PerApplication
    @Named("interactorBus")
    public EventBus provideInteractorBus() {
        return EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();
    }

}
