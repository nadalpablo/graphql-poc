package com.pocs.graphqlpoc.service.implementation;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.pocs.graphqlpoc.model.FrequentFlyer;
import com.pocs.graphqlpoc.model.Trip;
import com.pocs.graphqlpoc.model.exception.EntityDoesNotExistException;
import com.pocs.graphqlpoc.repository.FrequentFlyerRepository;
import com.pocs.graphqlpoc.repository.TripRepository;
import com.pocs.graphqlpoc.service.definition.TripServiceDefinition;

@Service
public class TripService implements TripServiceDefinition {

    private TripRepository tripRepository;
    private FrequentFlyerRepository frequentFlyerRepository;

    public TripService(TripRepository tripRepository, FrequentFlyerRepository frequentFlyerRepository) {
        this.tripRepository = tripRepository;
        this.frequentFlyerRepository = frequentFlyerRepository;
    }

    @Override
    public Page<Trip> getRecentTrips(int pageNumber, int pageSize) {
        return tripRepository.findAllByDepartureDateBeforeOrderByDepartureDateDesc(LocalDateTime.now(),
            pageSize > 0 ? PageRequest.of(pageNumber, pageSize) : Pageable.unpaged());
    }

    @Override
    public Trip createTrip(String origin, String destination, LocalDateTime departureDate, int flightNumber, String airline,
                           String frequentFlyerMembershipId) {
        FrequentFlyer frequentFlyer = frequentFlyerRepository.findByMembershipId(frequentFlyerMembershipId)
            .orElseThrow(() -> new EntityDoesNotExistException());

        Trip trip = new Trip(origin, destination, departureDate, flightNumber, airline, frequentFlyer.getId());
        trip = tripRepository.save(trip);

        frequentFlyer.addTrip(trip);
        frequentFlyerRepository.save(frequentFlyer);

        return trip;
    }
}
