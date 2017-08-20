package com.andermaco.challenge.view.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.andermaco.challenge.R;
import com.andermaco.challenge.di.components.ApplicationComponent;
import com.andermaco.challenge.di.components.loading.DaggerLoadingComponent;
import com.andermaco.challenge.di.components.loading.LoadingComponent;
import com.andermaco.challenge.di.modules.PresentationModule;
import com.andermaco.challenge.di.modules.views.LoadingViewModule;
import com.andermaco.challenge.view.base.BaseActivity;
import com.andermaco.challenge.view.presenter.base.BasePresenter;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.presenter.LoadingPresenter;

import javax.inject.Inject;

import butterknife.BindView;


public class Loading extends BaseActivity implements LoadingView {

    public final static int REQUEST_PERMISSIONS_REQUEST_CODE    = 12;

    @BindView(R.id.loading_image)
    ImageView loadingView;

    @BindView(R.id.loading_container)
    ViewGroup viewGroup;

    @Inject
    LoadingPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    protected void setupComponent(ApplicationComponent appComponent) {
        component = DaggerLoadingComponent.builder()
                .applicationComponent(appComponent)
                .loadingViewModule(new LoadingViewModule(this))
                .presentationModule(new PresentationModule(this))
                .build();
        ((LoadingComponent) component).inject(this);
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void initViews() {
        setContentView(getLayoutResourceId());
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_loading;
    }

    @Override
    protected void destroy() {

    }

    @Override
    public View getLoadingImage() {
        return loadingView;
    }

    @Override
    public ResourceManager getResourceManager() {
        return presenter.getResourceManager();
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void blockView() {

    }

    @Override
    public void unBlockView() {

    }

    @Override
    public ViewGroup getContainer() {
        return viewGroup;
    }

        @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length <= 0) {
                // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                presenter.showLocationPermissionRequired();
            }
        }
    }


}
