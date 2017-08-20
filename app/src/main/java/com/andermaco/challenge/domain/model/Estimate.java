package com.andermaco.challenge.domain.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by andermaco@gmail.com on 1/08/17.
 */

public class Estimate {

    @SerializedName("vehicle_type")
    protected Vehicle vehicle;

    @SerializedName("total_price")
    protected int totalPrice;

    @SerializedName("currency")
    protected String currency;

    @SerializedName("currency_symbol")
    protected String currencySimbol;

    @SerializedName("price_formatted")
    protected String priceFormated;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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


}
