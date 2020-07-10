package com.pocs.graphqlpoc.resolver;

import org.springframework.stereotype.Component;
import com.pocs.graphqlpoc.model.FrequentFlyer;
import com.pocs.graphqlpoc.model.Trip;
import com.pocs.graphqlpoc.service.definition.FrequentFlyerServiceDefinition;
import graphql.kickstart.tools.GraphQLResolver;

@Component
public class TripResolver implements GraphQLResolver<Trip> {

    private FrequentFlyerServiceDefinition frequentFlyerServiceDefinition;

    public TripResolver(FrequentFlyerServiceDefinition frequentFlyerServiceDefinition) {
        this.frequentFlyerServiceDefinition = frequentFlyerServiceDefinition;
    }

    public FrequentFlyer getFrequentFlyer(Trip trip) {
        return frequentFlyerServiceDefinition.getFrequentFlyerById(trip.getFrequentFlyerId());
    }
}