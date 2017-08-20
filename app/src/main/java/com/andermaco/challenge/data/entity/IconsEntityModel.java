package com.andermaco.challenge.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by andermaco@gmail.com on 4/08/17.
 */

public class IconsEntityModel extends IconsEntity implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.regular);
    }

    public IconsEntityModel() {
    }

    protected IconsEntityModel(Parcel in) {
        this.regular = in.readString();
    }

    public static final Parcelable.Creator<IconsEntityModel> CREATOR = new Parcelable.Creator<IconsEntityModel>() {
        @Override
        public IconsEntityModel createFromParcel(Parcel source) {
            return new IconsEntityModel(source);
        }

        @Override
        public IconsEntityModel[] newArray(int size) {
            return new IconsEntityModel[size];
        }
    };
}
