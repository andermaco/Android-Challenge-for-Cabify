package com.andermaco.challenge.data.entity;

import android.os.Parcelable;


/**
 * Created by andermaco@gmail.com on 4/08/17.
 */

public class EstimateModel extends EstimateEntity implements Parcelable {


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeParcelable((VehicleModel) this.vehicleEntity, flags);
        dest.writeInt(this.totalPrice);
        dest.writeString(this.currency);
        dest.writeString(this.currencySimbol);
        dest.writeString(this.priceFormated);
    }

    public EstimateModel() {
    }

    protected EstimateModel(android.os.Parcel in) {
        this.vehicleEntity = in.readParcelable(VehicleEntity.class.getClassLoader());
        this.totalPrice = in.readInt();
        this.currency = in.readString();
        this.currencySimbol = in.readString();
        this.priceFormated = in.readString();
    }

    public static final android.os.Parcelable.Creator<EstimateModel> CREATOR = new android.os.Parcelable.Creator<EstimateModel>() {
        @Override
        public EstimateModel createFromParcel(android.os.Parcel source) {
            return new EstimateModel(source);
        }

        @Override
        public EstimateModel[] newArray(int size) {
            return new EstimateModel[size];
        }
    };
}
