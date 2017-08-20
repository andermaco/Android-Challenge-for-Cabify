package com.andermaco.challenge.di.components.vehicle;

import com.andermaco.challenge.di.DiComponent;
import com.andermaco.challenge.di.components.ApplicationComponent;
import com.andermaco.challenge.di.modules.PresentationModule;
import com.andermaco.challenge.di.modules.views.VehicleListViewModule;
import com.andermaco.challenge.di.scopes.PerActivity;
import com.andermaco.challenge.view.activity.VehicleList;

import dagger.Component;

/**
 * Created by andermaco@gmail.com on 4/08/17.
 */

@PerActivity
@Component (
        modules = {
                PresentationModule.class,
                VehicleListViewModule.class
        },
        dependencies = {
                ApplicationComponent.class
        }
)

public interface VehicleListComponent extends DiComponent {
    void inject(VehicleList vehicleListActivity);
}
