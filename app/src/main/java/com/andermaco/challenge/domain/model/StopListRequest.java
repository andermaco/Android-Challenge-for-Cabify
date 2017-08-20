package com.andermaco.challenge.domain.model;


import com.andermaco.challenge.data.entity.StopEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andermaco@gmail.com on 2/08/17.
 */

public class StopListRequest {

    @SerializedName("stops")
    @Expose
    private List<StopEntity> list = new ArrayList<>();

    @SerializedName("start_at")
    @Expose private String start_at;

    public void add(StopEntity stopEntity) {
        list.add(stopEntity);
    }

    public List<StopEntity> getList() {
        return list;
    }

    public void setList(List<StopEntity> list) {
        this.list = list;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

}
