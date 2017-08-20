package com.andermaco.challenge.data.repository.datasource.mapper;

import com.andermaco.challenge.data.entity.IconsEntity;
import com.andermaco.challenge.domain.model.Icons;

/**
 * Created by andermaco@gmail.com on 19/08/17.
 */

public class IconsToIconsEntityMapper extends Mapper<Icons, IconsEntity>{
    @Override
    public IconsEntity map(Icons value) {
        IconsEntity iconsEntity = new IconsEntity();
        iconsEntity.setRegular(value.getRegular());
        return iconsEntity;
    }

    @Override
    public Icons reverseMap(IconsEntity value) {
        throw new UnsupportedOperationException();
    }
}
