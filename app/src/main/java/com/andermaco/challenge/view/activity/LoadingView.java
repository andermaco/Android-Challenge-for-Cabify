package com.andermaco.challenge.view.activity;

import android.view.View;

import com.andermaco.challenge.view.base.view.BaseView;
import com.andermaco.challenge.view.common.utils.ResourceManager;

/**
 * Created by andermaco@gmail.com on 30/07/17.
 */

public interface LoadingView extends BaseView {
    View getLoadingImage();

    ResourceManager getResourceManager();
}
