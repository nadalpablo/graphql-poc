package com.pocs.graphqlpoc.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.pocs.graphqlpoc.model.FrequentFlyer;

@Repository
public interface FrequentFlyerRepository extends MongoRepository<FrequentFlyer, String> {

    Optional<FrequentFlyer> findByMembershipId(String membershipId);
}
