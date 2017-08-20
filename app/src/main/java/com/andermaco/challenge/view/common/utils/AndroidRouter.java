package com.andermaco.challenge.view.common.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;

import com.andermaco.challenge.BuildConfig;
import com.andermaco.challenge.R;
import com.andermaco.challenge.common.constants.BundleConstants;
import com.andermaco.challenge.common.constants.LocationConstants;
import com.andermaco.challenge.data.entity.EstimateEntity;
import com.andermaco.challenge.data.entity.IconsEntity;
import com.andermaco.challenge.view.activity.JourneyMaps;
import com.andermaco.challenge.view.activity.VehicleList;
import com.andermaco.challenge.view.managers.location.AddressResultReceiver;
import com.andermaco.challenge.view.managers.location.FetchAddressIntentService;

import java.util.ArrayList;

/**
 * Created by andermaco@gmail.com on 31/07/17.
 */

public class AndroidRouter implements Router {

    private final Activity activity;

    public AndroidRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goBack() {

    }

    @Override
    public void goBackOnActivityResult(int resultCode) {

    }

    @Override
    public void openMap(Location location) {
        Intent intent = new Intent(this.activity, JourneyMaps.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra(BundleConstants.BUNDLE_CONST_LAST_KNOWN_LOCATON, location);
        activity.startActivity(intent);
    }

    @Override
    public void openSettings() {
        // Build intent that displays the App settings screen.
        Intent intent = new Intent();
        intent.setAction(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package",
                BuildConfig.APPLICATION_ID, null);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    public final static int REQUEST_PERMISSIONS_REQUEST_CODE    = 12;
    @Override
    public void startLocationPermissionRequest() {
         ActivityCompat.requestPermissions(activity,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_PERMISSIONS_REQUEST_CODE);
    }

    @Override
    public void getAddressLocationBased(Location location,
                                        AddressResultReceiver addressResultReceiver) {
        Intent intent = new Intent(this.activity, FetchAddressIntentService.class);
        intent.putExtra(LocationConstants.RECEIVER, addressResultReceiver);
        intent.putExtra(LocationConstants.LOCATION_DATA_EXTRA, location);
        activity.startService(intent);
    }

    @Override
    public void openVehicleList(ArrayList<EstimateEntity> estimateListResponse) {
        Intent intent = new Intent(this.activity, VehicleList.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(BundleConstants.BUNDLE_CONST_VEHICLE_LIST, estimateListResponse);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.enter_activity, R.anim.exit_activity);
    }

    @Override
    public void openVehicleListIcon(IconsEntity iconsEntity) {
        Intent intent = new Intent(this.activity, VehicleList.class);
        intent.putExtra(BundleConstants.BUNDLE_CONST_VEHICLE_LIST, iconsEntity);
        activity.startActivity(intent);
    }
}
