package com.andermaco.challenge.view.common.utils;

/**
 * Created by andermaco@gmail.com on 3/08/17.
 */

public interface StopsManager {

    String getAddressDirection(String address);

    String getAddressNumber(String address);

    /**
     * Just init start_at in a fake future time
     * @return
     */
    String getStartAtIn1h();
}
