package com.andermaco.challenge.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.andermaco.challenge.App;
import com.andermaco.challenge.di.components.ApplicationComponent;
import com.andermaco.challenge.view.presenter.base.BasePresenter;

import butterknife.ButterKnife;


/**
 * Created by andermaco@gmail.com on 27/07/17.
 */

public abstract class BaseFragment extends Fragment {

    private BaseActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(getLayoutResourceId(), container, false);

        activity = (BaseActivity) getActivity();

        // Bind views
        bindViews(rootView);

        // Inject objects with Dagger 2
        injectDependencies();

        // Init views
        initViews(rootView);

//TODO Uncomment and implement on inherited classes on further use
//        if (getPresenter() != null) {
//            setDataToPresenter();
//        }

        return rootView;
    }


    /**
     * Specify the layout of the fragment to be inflated in the {@link BaseFragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    protected abstract int getLayoutResourceId();

    /**
     * This method will setup the injector and will commit the dependencies injections.
     */
    protected abstract void setupComponent(ApplicationComponent applicationComponent);

    /**
     * Initialize all views for that fragment
     * @param rootView Fragment's root view
     */
    protected abstract void initViews(View rootView);

    /**
     * @return The presenter attached to the fragment. This must extends from {@link BasePresenter}
     */
    protected abstract BasePresenter getPresenter();

    /**
     * Replace all the annotated fields with ButterKnife annotations with the proper value
     */
    private void bindViews(View rootView) {
        ButterKnife.bind(this, rootView);
    }

        /**
     * Inject Dagger 2 dependencies
     */
    private void injectDependencies() {
        setupComponent(App.getApp(getActivity()).getApplicationComponent());
    }
}
