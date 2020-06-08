package com.pocs.graphqlpoc.service.definition;

import com.pocs.graphqlpoc.model.FrequentFlyer;

public interface FrequentFlyerServiceDefinition {

    FrequentFlyer createFrequentFlyer(String membershipId, String firstName, String lastName, int points);

    FrequentFlyer getFrequentFlyer(String frequentFlyerId);
}
