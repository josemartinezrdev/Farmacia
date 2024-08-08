package com.farmacia.city.application;

import com.farmacia.city.domain.service.CityService;

public class DeleteCityUseCase {

    private final CityService cityService;

    public DeleteCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute(String id) {
        cityService.deleteCity(id);
    }
}
