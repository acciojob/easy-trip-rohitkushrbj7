package com.driver.config;

import com.driver.repository.AirportRepository;
import com.driver.repository.FlightRepository;
import com.driver.repository.PassengerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AirportRepository airportRepository() {
        return new AirportRepository();
    }

    @Bean
    public FlightRepository flightRepository() {
        return new FlightRepository();
    }

    @Bean
    public PassengerRepository passengerRepository() {
        return new PassengerRepository();
    }
}
