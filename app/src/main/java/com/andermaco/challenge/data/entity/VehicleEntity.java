package com.andermaco.challenge.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andermaco@gmail.com on 1/08/17.
 */

public class VehicleEntity extends Entity implements Parcelable {
    @SerializedName(value = "_id")
    protected String id;

    @SerializedName(value = "name")
    protected String name;

    @SerializedName(value = "short_name")
    protected String shortName;

    @SerializedName(value = "description")
    protected String description;

    @SerializedName(value = "icon")
    protected String icon;

    @SerializedName(value = "iconsEntity")
    protected IconsEntity iconsEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public IconsEntity getIconsEntity() {
        return iconsEntity;
    }

    public void setIconsEntity(IconsEntity iconsEntity) {
        this.iconsEntity = iconsEntity;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.shortName);
        dest.writeString(this.description);
        dest.writeString(this.icon);
        dest.writeParcelable(this.iconsEntity, flags);
    }

    public VehicleEntity() {
    }

    protected VehicleEntity(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.shortName = in.readString();
        this.description = in.readString();
        this.icon = in.readString();
        this.iconsEntity = in.readParcelable(IconsEntity.class.getClassLoader());
    }

    public static final Parcelable.Creator<VehicleEntity> CREATOR = new Parcelable.Creator<VehicleEntity>() {
        @Override
        public VehicleEntity createFromParcel(Parcel source) {
            return new VehicleEntity(source);
        }

        @Override
        public VehicleEntity[] newArray(int size) {
            return new VehicleEntity[size];
        }
    };
}
