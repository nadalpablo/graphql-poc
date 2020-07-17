package com.pocs.graphqlpoc.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.pocs.graphqlpoc.model.Trip;

@Repository
public interface TripRepository extends MongoRepository<Trip, String> {

    Page<Trip> findAllByDepartureDateBeforeOrderByDepartureDateDesc(LocalDateTime departureDate, Pageable pageable);

    List<Trip> findAllByFrequentFlyerId(String frequentFlyerId);
}
