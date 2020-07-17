package com.pocs.graphqlpoc.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.pocs.graphqlpoc.model.FrequentFlyer;
import com.pocs.graphqlpoc.model.Trip;
import com.pocs.graphqlpoc.repository.TripRepository;
import com.pocs.graphqlpoc.service.definition.FrequentFlyerServiceDefinition;
import com.pocs.graphqlpoc.service.definition.TripServiceDefinition;

@Service
public class TripService implements TripServiceDefinition {

    private TripRepository tripRepository;
    private FrequentFlyerServiceDefinition frequentFlyerServiceDefinition;

    public TripService(TripRepository tripRepository, FrequentFlyerServiceDefinition frequentFlyerServiceDefinition) {
        this.tripRepository = tripRepository;
        this.frequentFlyerServiceDefinition = frequentFlyerServiceDefinition;
    }

    @Override
    public Page<Trip> getRecentTrips(int pageNumber, int pageSize) {
        return tripRepository.findAllByDepartureDateBeforeOrderByDepartureDateDesc(LocalDateTime.now(),
            pageSize > 0 ? PageRequest.of(pageNumber, pageSize) : Pageable.unpaged());
    }

    @Override
    public Trip createTrip(String origin, String destination, LocalDateTime departureDate, int flightNumber, String airline,
                           String frequentFlyerMembershipId) {
        return Optional.ofNullable(frequentFlyerServiceDefinition.getFrequentFlyerByMembershipId(frequentFlyerMembershipId))
            .map(FrequentFlyer::getId)
            .map(frequentFlyerId -> new Trip(origin, destination, departureDate, flightNumber, airline, frequentFlyerId))
            .map(tripRepository::save)
            .orElse(null);
    }

    @Override
    public List<Trip> getTripsByFrequentFlyerId(String frequentFlyerId) {
        return tripRepository.findAllByFrequentFlyerId(frequentFlyerId);
    }
}
