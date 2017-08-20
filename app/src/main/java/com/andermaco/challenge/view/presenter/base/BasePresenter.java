package com.andermaco.challenge.view.presenter.base;



import com.andermaco.challenge.view.base.view.BaseView;

/**
 * The presenter will be the bridge between Activity or Fragment or Activity.
 * Basically a presenter will communicate the results of background tasks (like a server request
 * or query to database) that are needed to affect the UI
 */
public interface BasePresenter<T extends BaseView> {
    /**
     * This method will be executed on activity/fragment's onStart method
     */
    void onStart();

    void onResume();

    void onPause();

    /**
     * This method will be executed on activity/fragment's onStop method
     */
    void onStop();

    /**
     * This method will be executed on activity/fragment's onDestroy method
     */
    void onDestroy();

    void onBackPressed();

}
