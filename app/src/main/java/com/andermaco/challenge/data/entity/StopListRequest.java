package com.andermaco.challenge.data.entity;


import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andermaco@gmail.com on 2/08/17.
 */

public class StopListRequest implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.list);
        dest.writeString(this.start_at);
    }

    public StopListRequest() {
    }

    protected StopListRequest(Parcel in) {
        this.list = in.createTypedArrayList(StopEntity.CREATOR);
        this.start_at = in.readString();
    }

    public static final Parcelable.Creator<StopListRequest> CREATOR = new Parcelable.Creator<StopListRequest>() {
        @Override
        public StopListRequest createFromParcel(Parcel source) {
            return new StopListRequest(source);
        }

        @Override
        public StopListRequest[] newArray(int size) {
            return new StopListRequest[size];
        }
    };
}
