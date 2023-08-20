package com.flightsearch.api.repository;

import com.flightsearch.api.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAirportAndLandingAirportAndDepartureDate(String departureAirport, String landingAirport, String departureDate);

    List<Flight> findByDepartureAirportAndLandingAirportAndDepartureDateRevertDate(String departureAirport, String landingAirport, String departureDate, String revertDate);
}
