package com.andermaco.challenge.view.presenter;


import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.andermaco.challenge.R;
import com.andermaco.challenge.common.constants.LocationConstants;
import com.andermaco.challenge.common.error.NetworkError;
import com.andermaco.challenge.data.entity.ContactEntity;
import com.andermaco.challenge.data.entity.EstimateEntity;
import com.andermaco.challenge.data.entity.StopEntity;
import com.andermaco.challenge.data.network.AndroidService;
import com.andermaco.challenge.data.network.GetEstimatesService;
import com.andermaco.challenge.data.repository.datasource.mapper.EstimateToEstimateEntityMapper;
import com.andermaco.challenge.domain.model.Estimate;
import com.andermaco.challenge.domain.model.StopListRequest;
import com.andermaco.challenge.view.activity.JourneyMaps;
import com.andermaco.challenge.view.activity.JourneyMapsView;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;
import com.andermaco.challenge.view.managers.location.AddressResultReceiver;
import com.andermaco.challenge.view.presenter.base.BasePresenter;
import com.andermaco.challenge.view.presenter.base.BaseViewPresenter;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by andermaco@gmail.com on 27/07/17.
 */

public class JourneyMapsPresenter extends BaseViewPresenter implements BasePresenter,
        AddressResultReceiver.Receiver {

    public final static int REQUEST_PERMISSIONS_REQUEST_CODE    = 12;
    private final static int MARKER_TIMEOUT_MILLISECONDS        = 2500;
    private FusedLocationProviderClient mFusedLocationClient;
    private Location mFromLocation, mToLocation;
    private Address mFromAddress, mToAddress;
    private GoogleMap mMap;
    private Marker mMarker;
    private boolean mShowMarkerTitle = true;
    private AddressResultReceiver mTargetAddressResultReceiver;
    private GetEstimatesService mGetEstimatesService;
    private DisposableObserver disposableObserver;

    public JourneyMapsPresenter(JourneyMapsView view, Router router,
                                ResourceManager resourceManager,
                                GetEstimatesService mGetEstimatesService) {
        super(view, router, resourceManager);
        this.mGetEstimatesService = mGetEstimatesService;
        mTargetAddressResultReceiver = new AddressResultReceiver(new Handler());
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onResume() {
        mTargetAddressResultReceiver.setReceiver(this);
    }

    @Override
    public void onPause() {
        mTargetAddressResultReceiver.setReceiver(null);
        if (disposableObserver ==  null && !disposableObserver.isDisposed()) {
            disposableObserver.dispose();
        }
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onBackPressed() {

    }

    private void showSnackbar(final String text) {
        if (view != null) {
            Snackbar.make(view.getContainer(), text, Snackbar.LENGTH_LONG).show();
        }
    }

    public void showSnackbar(final String text, final int actionStringId,
                             View.OnClickListener listener) {
        if (view != null) {
            Snackbar.make(view.getContainer(), text, Snackbar.LENGTH_LONG).show();
        }
    }

    @SuppressWarnings("MissingPermission")
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        this.mMap.setMyLocationEnabled(true);
        this.mFromLocation = mToLocation;
        moveMapToCurrentPosition(mToLocation);
    }

    private void moveMapToCurrentPosition(Location location) {
        this.mToLocation = location;
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
    }

    private void setMarker(LatLng latLng) {
        addMarker(latLng);
        setMarkerTitleHandler();
    }

    private void addMarker(LatLng latLng) {
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.cabify_icon);
        MarkerOptions markerOptions = new MarkerOptions()
                .icon(icon)
                .position(latLng).title(resourceManager.getYourPosition()).draggable(true);
        if (mMarker != null) {
            clearMarker();
        }
        mMarker = mMap.addMarker(markerOptions);
        if (mShowMarkerTitle) {
            mMarker.showInfoWindow();
        }
    }

    private void clearMarker() {
        mShowMarkerTitle = false;
        mMarker.remove();
        mMap.clear();
        mMarker = null;
    }

    private void setMarkerTitleHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mMarker.hideInfoWindow();
            }
        }, MARKER_TIMEOUT_MILLISECONDS);
    }

    public void setLastLocation(Location lastLocation) {
        if (mFromLocation == null) {
            mFromLocation = lastLocation;
        }
        mToLocation = lastLocation;
        router.getAddressLocationBased(lastLocation, mTargetAddressResultReceiver);

    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        Address address = resultData.getParcelable(LocationConstants.RESULT_DATA_KEY);
        if (address == null) {
            showSnackbar(resourceManager.getAddressNotFound());
            return;
        }

        if (mFromAddress == null) {
            mFromAddress = address;
        } else {
            mToAddress = address;
            getEstimates(mFromLocation, mToLocation, mFromAddress, mToAddress);
        }
        ((JourneyMapsView) view).getCustomTextViewAddress()
                .setText(getStringAddress(address));
    }

    public void onSelectedButton() {
        LatLng center = mMap.getCameraPosition().target;
        mToLocation = getLocation(center);

        router.getAddressLocationBased(mToLocation, mTargetAddressResultReceiver);
        ((JourneyMaps) view).getCustomTextViewAddress()
                .setCompoundDrawablesWithIntrinsicBounds
                        (R.drawable.ic_keyboard_arrow_up_white_24dp, 0, 0, 0);
    }

    private Location getLocation(LatLng latLng) {
        Location location = new Location("");
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);
        return location;
    }

    private void getEstimates(final Location fromLocation, final Location toLocation,
                              final Address fromAddress, final Address toAddress) {

        view.blockView();
        disposableObserver = mGetEstimatesService.getStopList(
                initStops(fromLocation, toLocation, fromAddress, toAddress),
                new AndroidService.GetStopListCallback() {
                    @Override
                    public void onSuccess(ArrayList<Estimate> estimateListResponse) {
                        view.unBlockView();
                        showEstimate(estimateListResponse);
                    }

                    @Override
                    public void onError(NetworkError networkError) {
                        view.unBlockView();
                        if (networkError.getError().getMessage().equalsIgnoreCase("timeout"))  {
                            showSnackbar(resourceManager.getTimeOutMessage());
                        }
                    }
                });
    }

    private String getStringAddress(Address address) {
        ArrayList<String> addressFragments = new ArrayList<>();
        for(int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
            addressFragments.add(address.getAddressLine(i));
        }
        return addressFragments.get(0);
    }

    public StopListRequest initStops(final Location fromLocation, final Location toLocation,
                                     final Address fromAddress, final Address toAddress) {
        StopEntity fromStop, toStop = null;
        fromStop = new StopEntity(new Double[]{fromLocation.getLatitude(),
                fromLocation.getLongitude()}, fromAddress.getAddressLine(0),
                fromAddress.getThoroughfare(), fromAddress.getFeatureName(),
                fromAddress.getLocality(), fromAddress.getCountryName(), "fake instructions",
                new ContactEntity("Fake name", "+34", 600000000));
        toStop =new StopEntity(new Double[]{toLocation.getLatitude(),
                    toLocation.getLongitude()}, toAddress.getAddressLine(0),
                toAddress.getThoroughfare(), toAddress.getFeatureName(),
                toAddress.getLocality(), toAddress.getCountryName(), "fake instructions",
                new ContactEntity("Fake name", "+34", 600000000));
        StopListRequest stopListRequest = new StopListRequest();
        stopListRequest.add(fromStop);
        stopListRequest.add(toStop);
        stopListRequest.setStart_at(null);// stopListRequest.setStart_at(mStopsManager.getStartAtIn1h());

        return stopListRequest;
    }

    private void showEstimate(ArrayList<Estimate> estimateListResponse) {
        router.openVehicleList((ArrayList<EstimateEntity>)
                new EstimateToEstimateEntityMapper().map(estimateListResponse));
    }
}