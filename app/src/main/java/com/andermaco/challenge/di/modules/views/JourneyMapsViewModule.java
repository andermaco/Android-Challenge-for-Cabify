package com.andermaco.challenge.di.modules.views;

import com.andermaco.challenge.di.scopes.PerActivity;
import com.andermaco.challenge.data.network.GetEstimatesService;
import com.andermaco.challenge.view.activity.JourneyMapsView;
import com.andermaco.challenge.view.common.utils.StopsManager;
import com.andermaco.challenge.view.common.utils.AndroidStopsManager;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;
import com.andermaco.challenge.view.presenter.JourneyMapsPresenter;
import com.andermaco.challenge.view.activity.JourneyMaps;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andermaco@gmail.com on 28/07/17.
 */

@Module
public class JourneyMapsViewModule {
    private final JourneyMaps journeyMapsActivity;

    public JourneyMapsViewModule(JourneyMaps journeyMapsActivity) {
        this.journeyMapsActivity = journeyMapsActivity;
    }

    @PerActivity
    @Provides
    public JourneyMapsView provideJourneyMapsView() {
        return this.journeyMapsActivity;
    }

    @PerActivity
    @Provides
    public JourneyMapsPresenter provideJourneyMapsPresenter(JourneyMapsView view,
                                                            Router router,
                                                            ResourceManager resourceManager,
                                                            GetEstimatesService getEstimatesService) {
        return new JourneyMapsPresenter(view, router, resourceManager, getEstimatesService);
    }

    @PerActivity
    @Provides
    public StopsManager provideAddressManager() {
        return new AndroidStopsManager();
    }

}
