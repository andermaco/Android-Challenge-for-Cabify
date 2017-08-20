package com.andermaco.challenge.data.network;

import com.andermaco.challenge.domain.model.StopListRequest;
import com.andermaco.challenge.data.network.AndroidService.GetStopListCallback;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by andermaco@gmail.com on 3/08/17.
 */

public interface GetEstimatesService {
    DisposableObserver getStopList(StopListRequest request,
                                   final GetStopListCallback callback);
}
