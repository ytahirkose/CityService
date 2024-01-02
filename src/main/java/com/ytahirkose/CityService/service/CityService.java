package com.ytahirkose.CityService.service;

import com.ytahirkose.CityService.model.City;
import com.ytahirkose.CityService.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    };

    public City addCity(City newCity) {
        return cityRepository.save(newCity);
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(String cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City Not Found"));
    }

    public City putCityById(String id, City newCity) {
        return cityRepository.save(newCity);
    }
}
