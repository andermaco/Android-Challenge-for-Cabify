package com.andermaco.challenge.data.repository.datasource.mapper;

import com.andermaco.challenge.data.entity.VehicleEntity;
import com.andermaco.challenge.domain.model.Vehicle;

/**
 * Created by andermaco@gmail.com on 19/08/17.
 */

public class VehicleToVehicleEntityMapper extends Mapper<Vehicle, VehicleEntity> {
    @Override
    public VehicleEntity map(Vehicle value) {
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setId(value.getId());
        vehicleEntity.setName(value.getName());
        vehicleEntity.setShortName(value.getShortName());
        vehicleEntity.setDescription(value.getDescription());
        vehicleEntity.setIcon(value.getIcon());
        vehicleEntity.setIconsEntity(new IconsToIconsEntityMapper().map(value.getIcons()));
        return vehicleEntity;
    }

    @Override
    public Vehicle reverseMap(VehicleEntity value) {
        throw new UnsupportedOperationException();
    }
}
