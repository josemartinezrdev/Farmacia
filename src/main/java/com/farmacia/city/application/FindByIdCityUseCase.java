package com.farmacia.city.application;

import com.farmacia.city.domain.entity.City;
import com.farmacia.city.domain.service.CityService;

public class FindByIdCityUseCase {

    private final CityService cityService;

    public FindByIdCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public City execute(String idciudad) {
        return cityService.findCityById(idciudad);
    }
}
