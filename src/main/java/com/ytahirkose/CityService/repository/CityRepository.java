package com.ytahirkose.CityService.repository;

import com.ytahirkose.CityService.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City, String> {
}
