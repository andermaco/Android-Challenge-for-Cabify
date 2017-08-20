package com.andermaco.challenge.di.modules.views;

import android.content.Context;

import com.andermaco.challenge.di.scopes.PerActivity;
import com.andermaco.challenge.view.activity.VehicleList;
import com.andermaco.challenge.view.activity.VehicleListView;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;
import com.andermaco.challenge.view.adapter.VehicleItemRecyclerViewAdapter;
import com.andermaco.challenge.view.presenter.VehicleListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andermaco@gmail.com on 4/08/17.
 */

@Module
public class VehicleListViewModule {
    private final VehicleList vehicleListActivity;

    public VehicleListViewModule(VehicleList vehicleListActivity) {
        this.vehicleListActivity = vehicleListActivity;
    }

    @PerActivity
    @Provides
    public VehicleListView provideVehicleListActivity() {
        return this.vehicleListActivity;
    }

    @PerActivity
    @Provides
    public VehicleListPresenter provideVehicleListPresenter(VehicleListView view,
                                                            Router router,
                                                            ResourceManager resourceManager) {
        return new VehicleListPresenter(view, router, resourceManager);
    }

    @PerActivity
    @Provides
    public VehicleItemRecyclerViewAdapter provideVehicleListAdapter(Context context,
                                                                    ResourceManager resourceManager){
        return new VehicleItemRecyclerViewAdapter(context, resourceManager);
    }

}
