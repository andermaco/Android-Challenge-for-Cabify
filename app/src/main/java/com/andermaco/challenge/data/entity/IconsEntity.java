package com.andermaco.challenge.data.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andermaco@gmail.com on 1/08/17.
 */

public class IconsEntity extends Entity implements Parcelable {
    @SerializedName("regular")
    protected String regular;

    public IconsEntity() {
    }

    public IconsEntity(String regular) {
        this.regular = regular;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.regular);
    }

    protected IconsEntity(Parcel in) {
        this.regular = in.readString();
    }

    public static final Parcelable.Creator<IconsEntity> CREATOR = new Parcelable.Creator<IconsEntity>() {
        @Override
        public IconsEntity createFromParcel(Parcel source) {
            return new IconsEntity(source);
        }

        @Override
        public IconsEntity[] newArray(int size) {
            return new IconsEntity[size];
        }
    };
}
