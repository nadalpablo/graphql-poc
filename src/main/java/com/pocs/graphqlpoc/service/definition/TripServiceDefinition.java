package com.pocs.graphqlpoc.service.definition;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import com.pocs.graphqlpoc.model.Trip;

public interface TripServiceDefinition {

    Page<Trip> getRecentTrips(int pageNumber, int pageSize);

    Trip createTrip(String origin, String destination, LocalDateTime departureDate, int flightNumber, String airline,
                    String frequentFlyerMembershipId);

    List<Trip> getTripsByFrequentFlyerId(String frequentFlyerId);
}
