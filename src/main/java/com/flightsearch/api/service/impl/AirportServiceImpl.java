package com.flightsearch.api.service.impl;

import com.flightsearch.api.exception.ResourceNotFoundException;
import com.flightsearch.api.model.Airport;
import com.flightsearch.api.repository.AirportRepository;
import com.flightsearch.api.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(long id) {
        return airportRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Airport", "Id", id));
    }

    @Override
    public Airport updateAirport(Airport airport, long id) {

        Airport existingAirport = airportRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Airport", "Id", id));

        existingAirport.setCity(airport.getCity());

        // save existing Airport to DB
        airportRepository.save(existingAirport);

        return existingAirport;
    }

    @Override
    public void deleteAirport(long id) {
        // check whether a airport exist in a DB or not
        airportRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Airport", "Id", id));
        airportRepository.deleteById(id);
    }
}
