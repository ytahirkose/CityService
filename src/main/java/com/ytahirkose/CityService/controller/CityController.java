package com.ytahirkose.CityService.controller;

import com.ytahirkose.CityService.model.City;

import com.ytahirkose.CityService.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> getCities() {
        return new ResponseEntity<>(cityService.getAllCities(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") String cityId) {
        return new ResponseEntity<>(cityService.getCityById(cityId), OK);
    }

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City newCity) {
        return new ResponseEntity<>(cityService.addCity(newCity), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> putCity(@PathVariable String id, @RequestBody City newCity) {
        return new ResponseEntity<>(cityService.putCityById(id, newCity), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(OK);
    }

}
