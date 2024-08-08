package com.farmacia.city.application;

import java.util.List;

import com.farmacia.city.domain.entity.City;
import com.farmacia.city.domain.service.CityService;

public class FindCityUseCase {
    private final CityService cityService;

    public FindCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> execute() {
        List<City> cities = cityService.findAllCities();
        return cities;
    }
}
