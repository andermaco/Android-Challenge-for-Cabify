package com.andermaco.challenge.view.common.utils;

import android.content.Context;
import com.andermaco.challenge.R;

/**
 * Created by andermaco@gmail.com on 31/07/17.
 */

public class AndroidResourceManager implements ResourceManager {

    private final Context context;

    public AndroidResourceManager(Context context) {
        this.context = context;
    }
    @Override
    public String getPermisionRationale() {
        return context.getResources().getString(R.string.permission_rationale);
    }

    @Override
    public String getPermissionDeniedDescription() {
        return context.getResources().getString(R.string.permission_denied_descripion);
    }

    @Override
    public String getYourPosition() {
        return context.getResources().getString(R.string.your_position);
    }

    @Override
    public String getAddressFound() {
        return context.getResources().getString(R.string.address_found);
    }

    @Override
    public String getAddressNotFound() {
        return context.getResources().getString(R.string.no_address_found);
    }

    @Override
    public String getSelectVehicle() {
        return context.getResources().getString(R.string.loading_select_vehicle);
    }

    @Override
    public String getNoLocation() {
        return context.getResources().getString(R.string.no_location);
    }

    @Override
    public String getTimeOutMessage() {
        return context.getString(R.string.timeout_reached);
    }

    @Override
    public String getLocationPermissionRequired() {
        return context.getString(R.string.location_permission_required);
    }
}
