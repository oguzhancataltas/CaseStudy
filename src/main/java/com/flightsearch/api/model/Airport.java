package com.flightsearch.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "city")
    private String city;
}
