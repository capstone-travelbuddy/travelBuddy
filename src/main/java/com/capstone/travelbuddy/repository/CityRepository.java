package com.capstone.travelbuddy.repository;

import com.capstone.travelbuddy.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
