package com.driver.repository;

import com.driver.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FlightRepository {
    private Map<Integer, Flight> flightMap = new HashMap<>();
    private Map<Integer, Integer> flightBookings = new HashMap<>();

    public void addFlight(Flight flight) {
        flightMap.put(flight.getFlightId(), flight);
        flightBookings.put(flight.getFlightId(), 0);
    }

    public Flight getFlight(int flightId) {
        return flightMap.get(flightId);
    }

    public Map<Integer, Flight> getAllFlights() {
        return flightMap;
    }

    public void bookFlight(int flightId) {
        flightBookings.put(flightId, flightBookings.get(flightId) + 1);
    }

    public void cancelFlightBooking(int flightId) {
        flightBookings.put(flightId, flightBookings.get(flightId) - 1);
    }

    public int getFlightBookings(int flightId) {
        return flightBookings.get(flightId);
    }
}
