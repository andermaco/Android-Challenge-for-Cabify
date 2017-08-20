package com.andermaco.challenge.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.andermaco.challenge.R;
import com.andermaco.challenge.common.constants.BundleConstants;
import com.andermaco.challenge.di.components.ApplicationComponent;
import com.andermaco.challenge.di.components.vehicle.DaggerVehicleListComponent;
import com.andermaco.challenge.di.components.vehicle.VehicleListComponent;
import com.andermaco.challenge.di.modules.PresentationModule;
import com.andermaco.challenge.di.modules.views.VehicleListViewModule;
import com.andermaco.challenge.data.entity.EstimateEntity;
import com.andermaco.challenge.view.base.BaseFragmentActivity;
import com.andermaco.challenge.view.presenter.base.BasePresenter;
import com.andermaco.challenge.view.adapter.VehicleItemRecyclerViewAdapter;
import com.andermaco.challenge.view.presenter.VehicleListPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by andermaco@gmail.com on 4/08/17.
 */

public class VehicleList extends BaseFragmentActivity implements VehicleListView {

    @Inject
    VehicleListPresenter presenter;

    @Inject
    VehicleItemRecyclerViewAdapter adapter;

    @BindView(R.id.list)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        ArrayList<EstimateEntity> list = (ArrayList<EstimateEntity>) bundle.get(BundleConstants.BUNDLE_CONST_VEHICLE_LIST);
        adapter.setList(list);

    }

    @Override
    protected void setupComponent(ApplicationComponent appComponent) {
        component = DaggerVehicleListComponent.builder()
                .applicationComponent(appComponent)
                .presentationModule(new PresentationModule(this))
                .vehicleListViewModule(new VehicleListViewModule(this))
                .build();
        ((VehicleListComponent) component).inject(this);
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
        return R.layout.activity_vehicle;
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void destroy() {

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
        return null;
    }

}
