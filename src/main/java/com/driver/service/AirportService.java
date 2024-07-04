package com.driver.service;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public String addAirport(Airport airport) {
        airportRepository.addAirport(airport);
        return "SUCCESS";
    }

    public String getLargestAirportName() {
        Map<String, Airport> airports = airportRepository.getAllAirports();
        String largestAirport = null;
        int maxTerminals = 0;

        for (Airport airport : airports.values()) {
            if (airport.getNoOfTerminals() > maxTerminals) {
                maxTerminals = airport.getNoOfTerminals();
                largestAirport = airport.getAirportName();
            } else if (airport.getNoOfTerminals() == maxTerminals) {
                if (largestAirport == null || airport.getAirportName().compareTo(largestAirport) < 0) {
                    largestAirport = airport.getAirportName();
                }
            }
        }
        return largestAirport;
    }

    public int getNumberOfPeopleOn(Date date, String airportName) {
        // Business logic to be implemented
        return 0;
    }
}
