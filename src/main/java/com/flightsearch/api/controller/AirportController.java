package com.flightsearch.api.controller;

import com.flightsearch.api.model.Airport;
import com.flightsearch.api.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    // build create airport REST API

    @PostMapping()
    public ResponseEntity<Airport> saveAirport(@RequestBody Airport airport) {
        return new ResponseEntity<Airport>(airportService.saveAirport(airport), HttpStatus.CREATED);
    }

    // build get all REST API
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    // build get airport by id REST API
    // http://localhost:8080/api/airportS/{id}
    @GetMapping("{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable("id") long airportId) {
        return new ResponseEntity<Airport>(airportService.getAirportById(airportId), HttpStatus.OK);
    }

    // build update airport REST API
    // http://localhost:8080/api/airportS/{id}
    @PutMapping("{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable("id") long id,
                                                 @RequestBody Airport airport) {
        return new ResponseEntity<Airport>(airportService.updateAirport(airport, id), HttpStatus.OK);
    }

    // build delete airport REST API
    // http://localhost:8080/api/airports/{id}
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable("id") long id) {
        // delete airport from DB
        airportService.deleteAirport(id);
        return new ResponseEntity<String>("Airport deleted successfully!", HttpStatus.OK);
    }

}
