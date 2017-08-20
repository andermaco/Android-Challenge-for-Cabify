package com.andermaco.challenge.data.entity;

import android.os.Parcelable;


/**
 * Created by andermaco@gmail.com on 4/08/17.
 */

public class VehicleModel extends VehicleEntity implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.shortName);
        dest.writeString(this.description);
        dest.writeString(this.icon);
        dest.writeParcelable((IconsEntityModel)this.iconsEntity, flags);
    }

    public VehicleModel() {
    }

    protected VehicleModel(android.os.Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.shortName = in.readString();
        this.description = in.readString();
        this.icon = in.readString();
        this.iconsEntity = in.readParcelable(IconsEntity.class.getClassLoader());
    }

    public static final android.os.Parcelable.Creator<VehicleModel> CREATOR = new android.os.Parcelable.Creator<VehicleModel>() {
        @Override
        public VehicleModel createFromParcel(android.os.Parcel source) {
            return new VehicleModel(source);
        }

        @Override
        public VehicleModel[] newArray(int size) {
            return new VehicleModel[size];
        }
    };
}
