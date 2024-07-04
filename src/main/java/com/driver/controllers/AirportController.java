package com.driver.controllers;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import com.driver.service.AirportService;
import com.driver.service.FlightService;
import com.driver.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AirportController {
    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/add_airport")
    public String addAirport(@RequestBody Airport airport) {
        return airportService.addAirport(airport);
    }

    @GetMapping("/get-largest-aiport")
    public String getLargestAirportName() {
        return airportService.getLargestAirportName();
    }

    @GetMapping("/get-shortest-time-travel-between-cities")
    public double getShortestDurationOfPossibleBetweenTwoCities(@RequestParam("fromCity") City fromCity, @RequestParam("toCity") City toCity) {
        return flightService.getShortestDurationOfPossibleBetweenTwoCities(fromCity, toCity);
    }

    @GetMapping("/get-number-of-people-on-airport-on/{date}")
    public int getNumberOfPeopleOn(@PathVariable("date") Date date, @RequestParam("airportName") String airportName) {
        return airportService.getNumberOfPeopleOn(date, airportName);
    }

    @GetMapping("/calculate-fare")
    public int calculateFlightFare(@RequestParam("flightId") Integer flightId) {
        return flightService.calculateFlightFare(flightId);
    }

    @PostMapping("/book-a-ticket")
    public String bookATicket(@RequestParam("flightId") Integer flightId, @RequestParam("passengerId") Integer passengerId) {
        return flightService.bookATicket(flightId, passengerId);
    }

    @PutMapping("/cancel-a-ticket")
    public String cancelATicket(@RequestParam("flightId") Integer flightId, @RequestParam("passengerId") Integer passengerId) {
        return flightService.cancelATicket(flightId, passengerId);
    }

    @GetMapping("/get-count-of-bookings-done-by-a-passenger/{passengerId}")
    public int countOfBookingsDoneByPassengerAllCombined(@PathVariable("passengerId") Integer passengerId) {
        return passengerService.countOfBookingsDoneByPassenger(passengerId);
    }

    @PostMapping("/add-flight")
    public String addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @GetMapping("/get-aiportName-from-flight-takeoff/{flightId}")
    public String getAirportNameFromFlightId(@PathVariable("flightId") Integer flightId) {
        return flightService.getAirportNameFromFlightId(flightId);
    }

    @GetMapping("/calculate-revenue-collected/{flightId}")
    public int calculateRevenueOfAFlight(@PathVariable("flightId") Integer flightId) {
        return flightService.calculateRevenueOfAFlight(flightId);
    }

    @PostMapping("/add-passenger")
    public String addPassenger(@RequestBody Passenger passenger) {
        return passengerService.addPassenger(passenger);
    }
}
