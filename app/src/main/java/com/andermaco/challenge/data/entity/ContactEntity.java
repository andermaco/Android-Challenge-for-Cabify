package com.andermaco.challenge.data.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andermaco@gmail.com on 2/08/17.
 */

public class ContactEntity implements Parcelable {

    @SerializedName("name")
    String name;

    @SerializedName("mobile_cc")
    String mobile_cc;

    @SerializedName("mobile_num")
    int mobile_num;

    public ContactEntity(String name, String mobile_cc, int mobile_num) {
        this.name = name;
        this.mobile_cc = mobile_cc;
        this.mobile_num = mobile_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_cc() {
        return mobile_cc;
    }

    public void setMobile_cc(String mobile_cc) {
        this.mobile_cc = mobile_cc;
    }

    public int getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(int mobile_num) {
        this.mobile_num = mobile_num;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.mobile_cc);
        dest.writeInt(this.mobile_num);
    }

    protected ContactEntity(Parcel in) {
        this.name = in.readString();
        this.mobile_cc = in.readString();
        this.mobile_num = in.readInt();
    }

    public static final Parcelable.Creator<ContactEntity> CREATOR = new Parcelable.Creator<ContactEntity>() {
        @Override
        public ContactEntity createFromParcel(Parcel source) {
            return new ContactEntity(source);
        }

        @Override
        public ContactEntity[] newArray(int size) {
            return new ContactEntity[size];
        }
    };
}
