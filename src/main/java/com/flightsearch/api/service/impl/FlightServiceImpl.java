package com.flightsearch.api.service.impl;

import com.flightsearch.api.exception.ResourceNotFoundException;
import com.flightsearch.api.model.Flight;
import com.flightsearch.api.repository.FlightRepository;
import com.flightsearch.api.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(long id) {

        return flightRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Flight", "Id", id));
    }

    @Override
    public Flight updateFlight(Flight flight, long id) {

        // we need to check whether flight with given id is existing in DB or not

        Flight existingFlight = flightRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Flight", "Id", id));

        existingFlight.setDepartureAirport(flight.getDepartureAirport());
        existingFlight.setLandingAirport(flight.getLandingAirport());
        existingFlight.setDepartureDate(flight.getDepartureDate());
        existingFlight.setRevertDate(flight.getRevertDate());
        existingFlight.setPrice(flight.getPrice());
        // save existing Flight to DB
        flightRepository.save(existingFlight);

        return existingFlight;
    }

    @Override
    public void deleteFlight(long id) {
        // check whether a flight exist in a DB or not
        flightRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Flight", "Id", id));

        flightRepository.deleteById(id);
    }

    @Override
    public List<Flight> getFlightNotReturn(String departureAirport, String landingAirport, String departureDate) {
        return flightRepository.findByDepartureAirportAndLandingAirportAndDepartureDate(departureAirport,landingAirport, departureDate);
    }

    @Override
    public List<Flight> getFlight(String departureAirport, String landingAirport, String departureDate, String returnDate) {
        return flightRepository.findByDepartureAirportAndLandingAirportAndDepartureDateRevertDate(departureAirport,landingAirport, departureDate, returnDate);
    }


}
