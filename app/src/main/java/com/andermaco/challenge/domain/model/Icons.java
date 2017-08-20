package com.andermaco.challenge.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andermaco@gmail.com on 1/08/17.
 */

public class Icons {
    @SerializedName("regular")
    protected String regular;

    public Icons() {
    }

    public Icons(String regular) {
        this.regular = regular;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

}
