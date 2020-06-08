package com.pocs.graphqlpoc.service.implementation;

import org.springframework.stereotype.Service;
import com.pocs.graphqlpoc.model.FrequentFlyer;
import com.pocs.graphqlpoc.model.exception.EntityDoesNotExistException;
import com.pocs.graphqlpoc.repository.FrequentFlyerRepository;
import com.pocs.graphqlpoc.service.definition.FrequentFlyerServiceDefinition;

@Service
public class FrequentFlyerService implements FrequentFlyerServiceDefinition {

    private FrequentFlyerRepository frequentFlyerRepository;

    public FrequentFlyerService(FrequentFlyerRepository frequentFlyerRepository) {
        this.frequentFlyerRepository = frequentFlyerRepository;
    }

    @Override
    public FrequentFlyer createFrequentFlyer(String membershipId, String firstName, String lastName, int points) {
        FrequentFlyer frequentFlyer = new FrequentFlyer(membershipId, firstName, lastName, points);
        return frequentFlyerRepository.save(frequentFlyer);
    }

    @Override
    public FrequentFlyer getFrequentFlyer(String frequentFlyerId) {
        return frequentFlyerRepository.findById(frequentFlyerId).orElseThrow(() -> new EntityDoesNotExistException());
    }
}
