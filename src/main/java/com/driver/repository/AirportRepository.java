package com.driver.repository;

import com.driver.model.Airport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AirportRepository {
    private Map<String, Airport> airportMap = new HashMap<>();

    public void addAirport(Airport airport) {
        airportMap.put(airport.getAirportName(), airport);
    }

    public Airport getAirport(String airportName) {
        return airportMap.get(airportName);
    }

    public Map<String, Airport> getAllAirports() {
        return airportMap;
    }
}
