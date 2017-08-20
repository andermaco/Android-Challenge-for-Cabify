package com.andermaco.challenge.view.presenter;

import com.andermaco.challenge.R;
import com.andermaco.challenge.data.entity.EstimateModel;
import com.andermaco.challenge.view.activity.VehicleList;
import com.andermaco.challenge.view.activity.VehicleListView;
import com.andermaco.challenge.view.presenter.base.BasePresenter;
import com.andermaco.challenge.view.presenter.base.BaseViewPresenter;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;

import java.util.ArrayList;

/**
 * Created by andermaco@gmail.com on 4/08/17.
 */

public class VehicleListPresenter extends BaseViewPresenter implements BasePresenter {

    ArrayList<EstimateModel> list;

    public VehicleListPresenter(VehicleListView view, Router router, ResourceManager resourceManager) {
        super(view, router, resourceManager);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

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
        ((VehicleList) view)
                .overridePendingTransition(R.anim.exit_activity, R.anim.enter_activity);
    }

    public void setList(ArrayList<EstimateModel> list) {
        this.list = list;

    }
}
