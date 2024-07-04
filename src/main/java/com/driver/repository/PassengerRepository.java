package com.driver.repository;

import com.driver.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PassengerRepository {
    private Map<Integer, Passenger> passengerMap = new HashMap<>();
    private Map<Integer, Integer> passengerBookings = new HashMap<>();

    public void addPassenger(Passenger passenger) {
        passengerMap.put(passenger.getPassengerId(), passenger);
        passengerBookings.put(passenger.getPassengerId(), 0);
    }

    public Passenger getPassenger(int passengerId) {
        return passengerMap.get(passengerId);
    }

    public Map<Integer, Passenger> getAllPassengers() {
        return passengerMap;
    }

    public void bookPassenger(int passengerId) {
        passengerBookings.put(passengerId, passengerBookings.get(passengerId) + 1);
    }

    public void cancelPassengerBooking(int passengerId) {
        passengerBookings.put(passengerId, passengerBookings.get(passengerId) - 1);
    }

    public int getPassengerBookings(int passengerId) {
        return passengerBookings.get(passengerId);
    }
}
