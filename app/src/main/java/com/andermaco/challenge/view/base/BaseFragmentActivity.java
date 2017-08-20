package com.andermaco.challenge.view.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import com.andermaco.challenge.App;
import com.andermaco.challenge.R;
import com.andermaco.challenge.di.DiComponent;
import com.andermaco.challenge.di.components.ApplicationComponent;
import com.andermaco.challenge.view.presenter.base.BasePresenter;
import com.andermaco.challenge.view.base.view.BaseView;
import butterknife.ButterKnife;

/**
 * Created by andermaco@gmail.com on 27/07/17.
 */

public abstract class BaseFragmentActivity extends FragmentActivity implements BaseView {

    private boolean isInjected = false;
    private BasePresenter presenter;
    protected DiComponent component;
    protected Dialog spinnerProgressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createBlockDialog();

        initViews();

        //Dependency injection
        ButterKnife.bind(this);
        injectDependencies();

        initPresenter();
    }

    /**
     * Set up dagger 2 component
     *
     * @param appComponent Application component
     */
    protected abstract void setupComponent(ApplicationComponent appComponent);

    private void injectDependencies() {
        if (!isInjected) {
            setupComponent(App.getApp(this).getApplicationComponent());
            isInjected = true;
        }
    }

    /**
     * @return The presenter attached to the activity. This must extends from {@link BasePresenter}
     */
    protected abstract BasePresenter getPresenter();

    /**
     * Initialize all views
     */
    protected abstract void initViews();

    /**
     * Specify the layout of the fragment to be inflated in the {@link BaseFragmentActivity#onCreate(Bundle)}
     */
    protected abstract int getLayoutResourceId();

    @Override
    public void blockView() {
        spinnerProgressDialog.show();
        spinnerProgressDialog.setContentView(R.layout.progress_dialog);
    }

    @Override
    public void unBlockView() {
        spinnerProgressDialog.dismiss();
    }

    protected void createBlockDialog() {
        spinnerProgressDialog = new ProgressDialog(this);
        spinnerProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        spinnerProgressDialog.setCanceledOnTouchOutside(false);
        spinnerProgressDialog.setCancelable(false);
    }

    /**
     * Destroy all objects
     */
    protected abstract void destroy();

    private void initPresenter() {
        if (presenter == null) {
            presenter = this.getPresenter();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().onDestroy();
        }
    }
}
