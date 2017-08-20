package com.andermaco.challenge.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andermaco.challenge.R;
import com.andermaco.challenge.data.entity.EstimateEntity;
import com.ander.components.CustomImageView;
import com.ander.components.CustomTextView;

import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VehicleItemRecyclerViewAdapter extends RecyclerView.Adapter<VehicleItemRecyclerViewAdapter.ViewHolder> {

    private ArrayList<EstimateEntity> mList;
    private final ResourceManager mResourceManager;
    private Context context;

    public VehicleItemRecyclerViewAdapter(Context context, ResourceManager resourceManager) {
        this.context = context;
        this.mResourceManager = resourceManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mList.get(position);
        holder.mIdView.setText(mList.get(position).getVehicleEntity().getName());
        Picasso.with(context)
                .load(mList.get(position).getVehicleEntity().getIconsEntity().getRegular())
                .into(holder.mImageView);
        holder.mPrice.setText(String.valueOf(mList.get(position).getTotalPrice()));
        String currencySymbol = String.valueOf(mList.get(position).getCurrencySimbol());
        holder.mCurrency.setText(currencySymbol == "null"?"":currencySymbol);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(ArrayList<EstimateEntity> list) {
        this.mList = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.vehicle_image)
        protected CustomImageView mImageView;

        @BindView(R.id.vehicle_name)
        protected CustomTextView mIdView;

        @BindView(R.id.vehicle_price)
        protected CustomTextView mPrice;

        @BindView(R.id.vehicle_currency)
        protected CustomTextView mCurrency;

        public final View mView;
        public EstimateEntity mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mIdView.getText() + "'";
        }
    }

}
