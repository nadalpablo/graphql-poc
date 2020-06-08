package com.pocs.graphqlpoc.service.definition;

import java.time.LocalDateTime;
import java.util.List;

import com.pocs.graphqlpoc.model.Trip;

public interface TripServiceDefinition {

    List<Trip> getRecentTrips(int pageNumber, int pageSize);

    Trip createTrip(String origin, String destination, LocalDateTime departureDate, int flightNumber, String airline,
                    String frequentFlyerMembershipId);
}
