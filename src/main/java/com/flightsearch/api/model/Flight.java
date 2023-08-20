package com.flightsearch.api.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "departure_airport", nullable = false)
    private String departureAirport;
    @Column(name = "landing_airport")
    private String landingAirport;
    @Column(name = "departure_date")
    private String departureDate;
    @Column(name = "revert_date")
    private String revertDate;
    @Column(name = "price", nullable = false)
    private double price;

}
