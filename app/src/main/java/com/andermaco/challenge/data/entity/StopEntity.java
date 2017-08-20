package com.andermaco.challenge.data.entity;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andermaco@gmail.com on 2/08/17.
 */

public class StopEntity extends Entity implements Cloneable, Parcelable {
    @SerializedName("loc")
    @Expose
    Double[] loc;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("address")
    @Expose
    String address;

    @SerializedName("num")
    @Expose
    String num;

    @SerializedName("city")
    @Expose
    String city;

    @SerializedName("country")
    @Expose
    String country;

    @SerializedName("instr")
    @Expose
    String instr;

    @SerializedName("contact")
    @Expose
    ContactEntity contact;

    public StopEntity(Double[] loc, String name, String address, String num, String city,
                      String country, String instr, ContactEntity contact) {
        this.loc = loc;
        this.name = name;
        this.address = address;
        this.num = num;
        this.city = city;
        this.country = country;
        this.instr = instr;
        this.contact = contact;
    }

    public Double[] getLoc() {
        return loc;
    }

    public void setLoc(Double[] loc) {
        this.loc = loc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInstr() {
        return instr;
    }

    public void setInstr(String instr) {
        this.instr = instr;
    }

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeArray(this.loc);
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeString(this.num);
        dest.writeString(this.city);
        dest.writeString(this.country);
        dest.writeString(this.instr);
        dest.writeParcelable(this.contact, flags);
    }

    protected StopEntity(Parcel in) {
        this.loc = (Double[]) in.readArray(Double[].class.getClassLoader());
        this.name = in.readString();
        this.address = in.readString();
        this.num = in.readString();
        this.city = in.readString();
        this.country = in.readString();
        this.instr = in.readString();
        this.contact = in.readParcelable(ContactEntity.class.getClassLoader());
    }

    public static final Parcelable.Creator<StopEntity> CREATOR = new Parcelable.Creator<StopEntity>() {
        @Override
        public StopEntity createFromParcel(Parcel source) {
            return new StopEntity(source);
        }

        @Override
        public StopEntity[] newArray(int size) {
            return new StopEntity[size];
        }
    };
}
