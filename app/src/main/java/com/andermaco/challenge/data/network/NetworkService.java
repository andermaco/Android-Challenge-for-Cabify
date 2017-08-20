package com.andermaco.challenge.data.network;


import com.andermaco.challenge.domain.model.EstimateListResponse;
import com.andermaco.challenge.domain.model.StopListRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by andermaco@gmail.com on 2/08/17.
 */

public interface NetworkService {
    @POST("api/v2/estimate")
    Observable<EstimateListResponse> getEstimateList(@Body StopListRequest request);
}
