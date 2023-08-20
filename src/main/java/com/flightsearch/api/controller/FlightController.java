package com.flightsearch.api.controller;

import com.flightsearch.api.model.Flight;
import com.flightsearch.api.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // build create flight Rest API

    @PostMapping()
    public ResponseEntity<Flight> saveEmployee(@RequestBody Flight flight) {
        return new ResponseEntity<Flight>(flightService.saveFlight(flight), HttpStatus.CREATED);
    }

    // build get all flight Rest API
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // build get flight by id REST API
    // http://localhost:8080/api/flights/{id}
    @GetMapping("{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") long flightId) {
        return new ResponseEntity<Flight>(flightService.getFlightById(flightId),HttpStatus.OK);
    }

    // build update flight REST API
    // http://localhost:8080/api/flights/{id}
    @PutMapping("{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable("id") long id
                                               ,@RequestBody Flight flight) {
        return new ResponseEntity<Flight>(flightService.updateFlight(flight,id), HttpStatus.OK);
    }

    // build delete Flight REST API
    // http://localhost:8080/api/flights/{id}
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable("id") long id) {
        // delete flight from DB
        flightService.deleteFlight(id);
        return new ResponseEntity<String>("Flight deleted successfully!", HttpStatus.OK);
    }

    // build get Flight List
    @GetMapping("/findflights/{departureAirport}/{landingAirport}/{departureDate}/{returnDate}")
    public ResponseEntity<Flight> getFlightList(@PathVariable("departureAirport") String departureAirport,
                                                @PathVariable("landingAirport") String landingAirport,
                                                @PathVariable("departureDate") String departureDate,
                                                @PathVariable(name = "returnDate", required = false) String returnDate) {
        if (returnDate != null) {
            return new ResponseEntity<Flight>((Flight) flightService.getFlight(departureAirport, landingAirport, departureDate, returnDate), HttpStatus.OK);
        }
        return new ResponseEntity<Flight>((Flight) flightService.getFlightNotReturn(departureAirport, landingAirport, departureDate), HttpStatus.OK);
    }

}
