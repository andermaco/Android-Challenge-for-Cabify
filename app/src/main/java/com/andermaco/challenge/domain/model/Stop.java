package com.andermaco.challenge.domain.model;


import com.andermaco.challenge.data.entity.ContactEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andermaco@gmail.com on 2/08/17.
 */

public class Stop implements Cloneable {
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

    public Stop(Double[] loc, String name, String address, String num, String city,
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
}
