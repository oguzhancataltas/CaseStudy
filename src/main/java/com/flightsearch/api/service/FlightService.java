package com.flightsearch.api.service;

import com.flightsearch.api.model.Flight;

import java.util.List;

public interface FlightService {
    Flight saveFlight(Flight flight);
    List<Flight> getAllFlights();
    Flight getFlightById(long id);
    Flight updateFlight(Flight flight, long id);
    void deleteFlight(long id);
    List<Flight> getFlightNotReturn(String departureAirport, String landingAirport, String departureDate);
    List<Flight> getFlight(String departureAirport, String landingAirport, String departureDate, String returnDate);

}
