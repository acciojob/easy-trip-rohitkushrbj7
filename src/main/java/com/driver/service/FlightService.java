package com.driver.service;

import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public String addFlight(Flight flight) {
        flightRepository.addFlight(flight);
        return "SUCCESS";
    }

    public double getShortestDurationOfPossibleBetweenTwoCities(City fromCity, City toCity) {
        double shortestDuration = Double.MAX_VALUE;
        boolean found = false;

        for (Flight flight : flightRepository.getAllFlights().values()) {
            if (flight.getFromCity() == fromCity && flight.getToCity() == toCity) {
                found = true;
                if (flight.getDuration() < shortestDuration) {
                    shortestDuration = flight.getDuration();
                }
            }
        }

        return found ? shortestDuration : -1;
    }

    public int calculateFlightFare(int flightId) {
        int bookings = flightRepository.getFlightBookings(flightId);
        return 3000 + bookings * 50;
    }

    public String bookATicket(int flightId, int passengerId) {
        Flight flight = flightRepository.getFlight(flightId);
        if (flight == null || flightRepository.getFlightBookings(flightId) >= flight.getMaxCapacity()) {
            return "FAILURE";
        }

        flightRepository.bookFlight(flightId);
        return "SUCCESS";
    }

    public String cancelATicket(int flightId, int passengerId) {
        // Business logic to be implemented
        return "FAILURE";
    }

    public String getAirportNameFromFlightId(int flightId) {
        Flight flight = flightRepository.getFlight(flightId);
        if (flight == null) {
            return null;
        }
        return flight.getFromCity().toString();
    }

    public int calculateRevenueOfAFlight(int flightId) {
        int bookings = flightRepository.getFlightBookings(flightId);
        return bookings * 3000 + (bookings - 1) * 50 * bookings / 2;
    }
}
