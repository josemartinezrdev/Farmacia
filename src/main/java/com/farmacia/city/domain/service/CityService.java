package com.farmacia.city.domain.service;

import java.util.List;

import com.farmacia.city.domain.entity.City;

public interface CityService {

    public void addCity(City city);

    public void updateCity(City city);

    public void deleteCity(String id);

    City findCityById(String id);

    List<City> findAllCities();

}
