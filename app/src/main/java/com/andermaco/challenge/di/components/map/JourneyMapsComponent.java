package com.andermaco.challenge.di.components.map;

import com.andermaco.challenge.di.DiComponent;
import com.andermaco.challenge.di.components.ApplicationComponent;
import com.andermaco.challenge.di.modules.interactors.GetEstimateModule;
import com.andermaco.challenge.di.modules.PresentationModule;
import com.andermaco.challenge.di.modules.views.JourneyMapsViewModule;
import com.andermaco.challenge.di.scopes.PerActivity;
import com.andermaco.challenge.view.activity.JourneyMaps;
import dagger.Component;

/**
 * Created by andermaco@gmail.com on 28/07/17.
 */

@PerActivity
@Component(
        modules = {
//TODO Uncomment and implement on inherited classes on further use
//                SystemModule.class,
                PresentationModule.class,
                GetEstimateModule.class,
                JourneyMapsViewModule.class
        },
        dependencies = {
                ApplicationComponent.class
        }
)

public interface JourneyMapsComponent extends DiComponent {
    void inject(JourneyMaps journeyMapsActivity);
}
