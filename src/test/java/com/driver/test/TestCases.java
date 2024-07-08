package com.driver.test;

import com.driver.controllers.AirportController;
import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TestCases {

    @Mock
    private AirportController airportController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddAirport() {
        Airport airport = new Airport();
        airport.setAirportName("Test Airport");
        airport.setNoOfTerminals(3);
        airport.setCity(City.DELHI);
        when(airportController.addAirport(airport)).thenReturn("SUCCESS");
        assert "SUCCESS".equals(airportController.addAirport(airport));
    }

    @Test
    public void testGetLargestAirportName() {
        when(airportController.getLargestAirportName()).thenReturn("Test Airport");
        assert "Test Airport".equals(airportController.getLargestAirportName());
    }

    @Test
    public void testGetShortestDurationOfPossibleBetweenTwoCities() {
        when(airportController.getShortestDurationOfPossibleBetweenTwoCities(City.DELHI, City.BANGLORE)).thenReturn(2.5);
        assert 2.5 == airportController.getShortestDurationOfPossibleBetweenTwoCities(City.DELHI, City.BANGLORE);
    }

    @Test
    public void testGetNumberOfPeopleOn() {
        Date date = new Date();
        when(airportController.getNumberOfPeopleOn(date, "Test Airport")).thenReturn(100);
        assert 100 == airportController.getNumberOfPeopleOn(date, "Test Airport");
    }

    @Test
    public void testCalculateFlightFare() {
        when(airportController.calculateFlightFare(1)).thenReturn(3100);
        assert 3100 == airportController.calculateFlightFare(1);
    }

    @Test
    public void testBookATicket() {
        when(airportController.bookATicket(1, 1)).thenReturn("SUCCESS");
        assert "SUCCESS".equals(airportController.bookATicket(1, 1));
    }

    @Test
    public void testCancelATicket() {
        when(airportController.cancelATicket(1, 1)).thenReturn("SUCCESS");
        assert "SUCCESS".equals(airportController.cancelATicket(1, 1));
    }

    @Test
    public void testCountOfBookingsDoneByPassengerAllCombined() {
        when(airportController.countOfBookingsDoneByPassengerAllCombined(1)).thenReturn(5);
        assert 5 == airportController.countOfBookingsDoneByPassengerAllCombined(1);
    }

    @Test
    public void testAddFlight() {
        Flight flight = new Flight();
        flight.setFlightId(1);
        flight.setFromCity(City.DELHI);
        flight.setToCity(City.BANGLORE);
        flight.setMaxCapacity(200);
        flight.setFlightDate(new Date());
        flight.setDuration(2.5);
        when(airportController.addFlight(flight)).thenReturn("SUCCESS");
        assert "SUCCESS".equals(airportController.addFlight(flight));
    }

    @Test
    public void testGetAirportNameFromFlightId() {
        when(airportController.getAirportNameFromFlightId(1)).thenReturn("Test Airport");
        assert "Test Airport".equals(airportController.getAirportNameFromFlightId(1));
    }

    @Test
    public void testCalculateRevenueOfAFlight() {
        when(airportController.calculateRevenueOfAFlight(1)).thenReturn(15000);
        assert 15000 == airportController.calculateRevenueOfAFlight(1);
    }

    @Test
    public void testAddPassenger() {
        Passenger passenger = new Passenger();
        passenger.setPassengerId(1);
        passenger.setEmail("test@test.com");
        passenger.setName("Test Passenger");
        passenger.setAge(25);
        when(airportController.addPassenger(passenger)).thenReturn("SUCCESS");
        assert "SUCCESS".equals(airportController.addPassenger(passenger));
    }
}
