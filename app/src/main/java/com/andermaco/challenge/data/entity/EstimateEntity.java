package com.andermaco.challenge.data.entity;


import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andermaco@gmail.com on 1/08/17.
 */

public class EstimateEntity extends Entity implements Parcelable {

    @SerializedName("vehicle_type")
    protected VehicleEntity vehicleEntity;

    @SerializedName("total_price")
    protected int totalPrice;

    @SerializedName("currency")
    protected String currency;

    @SerializedName("currency_symbol")
    protected String currencySimbol;

    @SerializedName("price_formatted")
    protected String priceFormated;

    public VehicleEntity getVehicleEntity() {
        return vehicleEntity;
    }

    public void setVehicleEntity(VehicleEntity vehicleEntity) {
        this.vehicleEntity = vehicleEntity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencySimbol() {
        return currencySimbol;
    }

    public void setCurrencySimbol(String currencySimbol) {
        this.currencySimbol = currencySimbol;
    }

    public String getPriceFormated() {
        return priceFormated;
    }

    public void setPriceFormated(String priceFormated) {
        this.priceFormated = priceFormated;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.vehicleEntity, flags);
        dest.writeInt(this.totalPrice);
        dest.writeString(this.currency);
        dest.writeString(this.currencySimbol);
        dest.writeString(this.priceFormated);
    }

    public EstimateEntity() {
    }

    protected EstimateEntity(Parcel in) {
        this.vehicleEntity = in.readParcelable(VehicleEntity.class.getClassLoader());
        this.totalPrice = in.readInt();
        this.currency = in.readString();
        this.currencySimbol = in.readString();
        this.priceFormated = in.readString();
    }

    public static final Parcelable.Creator<EstimateEntity> CREATOR = new Parcelable.Creator<EstimateEntity>() {
        @Override
        public EstimateEntity createFromParcel(Parcel source) {
            return new EstimateEntity(source);
        }

        @Override
        public EstimateEntity[] newArray(int size) {
            return new EstimateEntity[size];
        }
    };
}
