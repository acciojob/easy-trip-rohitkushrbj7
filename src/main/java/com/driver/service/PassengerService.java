package com.driver.service;

import com.driver.model.Passenger;
import com.driver.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public String addPassenger(Passenger passenger) {
        passengerRepository.addPassenger(passenger);
        return "SUCCESS";
    }

    public int countOfBookingsDoneByPassenger(int passengerId) {
        return passengerRepository.getPassengerBookings(passengerId);
    }
}
