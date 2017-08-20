package com.andermaco.challenge.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andermaco@gmail.com on 1/08/17.
 */

public class Vehicle {
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

    @SerializedName(value = "icons")
    protected Icons icons;

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

    public Icons getIcons() {
        return icons;
    }

    public void setIcons(Icons icons) {
        this.icons = icons;
    }

}
