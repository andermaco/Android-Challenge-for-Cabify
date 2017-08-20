package com.andermaco.challenge.view.activity;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.ander.components.CustomTextView;
import com.andermaco.challenge.R;
import com.andermaco.challenge.common.constants.BundleConstants;
import com.andermaco.challenge.di.components.ApplicationComponent;
import com.andermaco.challenge.di.components.map.DaggerJourneyMapsComponent;
import com.andermaco.challenge.di.components.map.JourneyMapsComponent;
import com.andermaco.challenge.di.modules.interactors.GetEstimateModule;
import com.andermaco.challenge.di.modules.PresentationModule;
import com.andermaco.challenge.di.modules.views.JourneyMapsViewModule;
import com.andermaco.challenge.view.presenter.JourneyMapsPresenter;
import com.andermaco.challenge.view.base.BaseFragmentActivity;
import com.andermaco.challenge.view.presenter.base.BasePresenter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.io.File;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by andermaco@gmail.com on 27/07/17.
 */
public class JourneyMaps extends BaseFragmentActivity implements
        JourneyMapsView, OnMapReadyCallback {

    @Nullable
    @BindView(R.id.main_container)
    ViewGroup rootView;

    @BindView(R.id.select_bt)
    CustomTextView customTextViewButton;

    @BindView(R.id.address)
    CustomTextView customTextViewAddress;

    @Inject
    JourneyMapsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        Location mLastLocation = (Location) bundle.get(BundleConstants.BUNDLE_CONST_LAST_KNOWN_LOCATON);
        presenter.setLastLocation(mLastLocation);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void setupComponent(ApplicationComponent appComponent) {
        File cacheFile = new File(getCacheDir(), "responses");
        component = DaggerJourneyMapsComponent.builder()
                .applicationComponent(appComponent)
                .presentationModule(new PresentationModule(this))
                .journeyMapsViewModule(new JourneyMapsViewModule(this))
                .getEstimateModule(new GetEstimateModule(cacheFile))
                .build();
        ((JourneyMapsComponent) component).inject(this);
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void initViews() {
        setContentView(getLayoutResourceId());
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        presenter.onMapReady(googleMap);
    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_journey_maps;
    }

    @Override
    protected void destroy() {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public ViewGroup getContainer() {
        return rootView;
    }

    @Override
    public CustomTextView getCustomTextViewAddress() {
        return customTextViewAddress;
    }

    @Override
    public CustomTextView getCustomTextViewButton() {
        return customTextViewButton;
    }

    @OnClick(R.id.select_bt)
    protected void onSelectButton() {
        presenter.onSelectedButton();
    }
}