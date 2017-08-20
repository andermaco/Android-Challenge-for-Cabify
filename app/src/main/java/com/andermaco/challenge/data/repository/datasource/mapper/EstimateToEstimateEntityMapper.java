package com.andermaco.challenge.data.repository.datasource.mapper;

import com.andermaco.challenge.data.entity.EstimateEntity;
import com.andermaco.challenge.domain.model.Estimate;

/**
 * Created by andermaco@gmail.com on 19/08/17.
 */

public class EstimateToEstimateEntityMapper extends Mapper<Estimate, EstimateEntity>  {
    @Override
    public EstimateEntity map(Estimate value) {
        EstimateEntity estimateEntity = new EstimateEntity();
        estimateEntity.setVehicleEntity(new VehicleToVehicleEntityMapper().map(value.getVehicle()));
        estimateEntity.setTotalPrice(value.getTotalPrice());
        estimateEntity.setCurrency(value.getCurrency());
        estimateEntity.setCurrencySimbol(value.getCurrencySimbol());
        estimateEntity.setPriceFormated(value.getPriceFormated());
        return estimateEntity;
    }

    @Override
    public Estimate reverseMap(EstimateEntity value) {
        throw new UnsupportedOperationException();
    }

}
