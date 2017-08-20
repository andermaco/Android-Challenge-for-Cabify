package com.andermaco.challenge.view.activity;

import android.view.ViewGroup;

import com.ander.components.CustomTextView;
import com.andermaco.challenge.view.base.view.BaseView;

/**
 * Created by andermaco@gmail.com on 28/07/17.
 */

public interface JourneyMapsView extends BaseView {

    ViewGroup getContainer();

    CustomTextView getCustomTextViewAddress();

    CustomTextView getCustomTextViewButton();
}
