package com.andermaco.challenge.view.presenter;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.andermaco.challenge.R;
import com.andermaco.challenge.view.activity.Loading;
import com.andermaco.challenge.view.activity.LoadingView;
import com.andermaco.challenge.view.presenter.base.BasePresenter;
import com.andermaco.challenge.view.presenter.base.BaseViewPresenter;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/**
 * Created by andermaco@gmail.com on 30/07/17.
 */

public class LoadingPresenter extends BaseViewPresenter implements BasePresenter {
    private final static int ROUTE_TO_SETTINGS_TIMEOUT_MILLISECONDS        = 2500;
    private FusedLocationProviderClient mFusedLocationClient;
    private Location mLastLocation;
    private Animation mAnimation;

    public LoadingPresenter(LoadingView view, Router router,
                            ResourceManager resourceManager) {
        super(view, router, resourceManager);
    }

    @Override
    public void onStart() {
        initFusedLocationProvider();

    }

    @Override
    public void onResume() {
        if (!checkPermissions()) {
            requestPermissions();
        } else {
            getLastLocation();
            startRotatingImage();
        }
    }

    @Override
    public void onPause() {

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

    private void initFusedLocationProvider() {
        this.mFusedLocationClient =
                LocationServices.getFusedLocationProviderClient((Loading) view);
    }

    @SuppressWarnings("MissingPermission")
    public void getLastLocation() {
         mFusedLocationClient.getLastLocation()
                 .addOnCompleteListener((Loading) view, new OnCompleteListener<Location>() {
                     @Override
                     public void onComplete(@NonNull Task<Location> task) {
                         if (task.isSuccessful() && task.getResult() != null) {
                            mLastLocation = task.getResult();
                        } else {
                            showSnackbar(resourceManager.getNoLocation());
                        }
                     }
                 });
    }

    public void startRotatingImage() {
        mAnimation = AnimationUtils.loadAnimation(((Loading) view),
                R.anim.cabify_rotate_animation);
        mAnimation.setRepeatMode(Animation.INFINITE);

        ((Loading) view).getLoadingImage().startAnimation(mAnimation);
        mAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
               getLastLocation();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation.cancel();
                animation.reset();
                router.openMap(mLastLocation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
    }

    public void showSnackbar(final String text) {
        if (view != null) {
            Snackbar.make(((LoadingView) view).getContainer(), text, Snackbar.LENGTH_LONG).show();
        }
    }

    public void showSnackbar(final String text, final int actionStringId,
                             View.OnClickListener listener) {
        if (view != null) {
            Snackbar.make(view.getContainer(), text, Snackbar.LENGTH_LONG).show();
        }
    }

    public void openSettings() {
        router.openSettings();
    }

    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission((Loading) view,
                Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

     private void requestPermissions() {
        boolean shouldProvideRationale =
                ActivityCompat.shouldShowRequestPermissionRationale((Loading) view,
                        Manifest.permission.ACCESS_FINE_LOCATION);

        // Provide an additional rationale to the user. This would happen if the user denied the
        // request previously, but didn't check the "Don't ask again" checkbox.
        if (shouldProvideRationale) {
            showLocationPermissionRequired();
        } else {
            router.startLocationPermissionRequest();
        }
    }

    public void showLocationPermissionRequired() {
        showSnackbar(resourceManager.getLocationPermissionRequired());
        routeToSettingsHandler();
    }

     private void routeToSettingsHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                router.openSettings();
            }
        }, ROUTE_TO_SETTINGS_TIMEOUT_MILLISECONDS);
    }
}
