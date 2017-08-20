package com.andermaco.challenge.view.common.utils;

import android.location.Location;

import com.andermaco.challenge.data.entity.EstimateEntity;
import com.andermaco.challenge.data.entity.IconsEntity;
import com.andermaco.challenge.view.managers.location.AddressResultReceiver;

import java.util.ArrayList;


/**
 * Created by andermaco@gmail.com
 */
public interface Router {

    void goBack();

    void goBackOnActivityResult(int resultCode);

    void openMap(Location location);

    void openSettings();

    void startLocationPermissionRequest();

    void getAddressLocationBased(Location location, AddressResultReceiver addressResultReceiver);

    void openVehicleList(ArrayList<EstimateEntity> estimateListResponse);

    void openVehicleListIcon(IconsEntity iconsEntity);
}
