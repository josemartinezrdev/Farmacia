package com.farmacia.city.application;

import com.farmacia.city.domain.entity.City;
import com.farmacia.city.domain.service.CityService;

public class UpdateCityUseCase {

    private final CityService cityService;

    public UpdateCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute(City city) {
        cityService.updateCity(city);
    }

}
