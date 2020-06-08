package com.pocs.graphqlpoc.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trips")
public class Trip {

    @Id
    private String id;

    private String origin;
    private String destination;
    private LocalDateTime departureDate;
    private int flightNumber;
    private String airline;
    private String frequentFlyerId;

    public Trip() {
        // No-arg constructor
    }

    public Trip(String origin, String destination, LocalDateTime departureDate, int flightNumber, String airline,
                String frequentFlyerId) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.frequentFlyerId = frequentFlyerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFrequentFlyerId() {
        return frequentFlyerId;
    }

    public void setFrequentFlyerId(String frequentFlyerId) {
        this.frequentFlyerId = frequentFlyerId;
    }

    @Override
    public String toString() {
        return "{\"Trip\":{"
            + "\"id\":\"" + id + "\""
            + ", \"origin\":\"" + origin + "\""
            + ", \"destination\":\"" + destination + "\""
            + ", \"departureDate\":" + departureDate
            + ", \"flightNumber\":\"" + flightNumber + "\""
            + ", \"airline\":\"" + airline + "\""
            + ", \"frequentFlyerId\":\"" + frequentFlyerId + "\""
            + "}}";
    }
}
