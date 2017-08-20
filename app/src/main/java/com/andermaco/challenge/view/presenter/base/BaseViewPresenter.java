package com.andermaco.challenge.view.presenter.base;


import com.andermaco.challenge.view.base.view.BaseView;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;

public abstract class BaseViewPresenter<T extends BaseView> implements BasePresenter {

    protected T view;
    protected Router router;
    protected ResourceManager resourceManager;

    public BaseViewPresenter(T view, Router router, ResourceManager resourceManager) {
        this.view = view;
        this.router = router;
        this.resourceManager = resourceManager;
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }
}
