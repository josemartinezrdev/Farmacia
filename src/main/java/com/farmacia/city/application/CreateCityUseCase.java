package com.farmacia.city.application;

import com.farmacia.city.domain.entity.City;
import com.farmacia.city.domain.service.CityService;

public class CreateCityUseCase {

    private final CityService cityService;

    public CreateCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute(City city) {
        cityService.addCity(city);
    }

}
