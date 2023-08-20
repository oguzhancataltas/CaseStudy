package com.flightsearch.api.service;

import com.flightsearch.api.model.Airport;
import com.flightsearch.api.model.Flight;

import java.util.List;

public interface AirportService {
    Airport saveAirport(Airport airport);
    List<Airport> getAllAirports();
    Airport getAirportById(long id);
    Airport updateAirport(Airport airport, long id);
    void deleteAirport(long id);
}
