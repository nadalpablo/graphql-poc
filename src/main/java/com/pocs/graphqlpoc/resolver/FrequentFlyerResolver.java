package com.pocs.graphqlpoc.resolver;

import java.util.List;

import org.springframework.stereotype.Component;
import com.pocs.graphqlpoc.model.FrequentFlyer;
import com.pocs.graphqlpoc.model.Trip;
import com.pocs.graphqlpoc.service.definition.TripServiceDefinition;
import graphql.kickstart.tools.GraphQLResolver;

@Component
public class FrequentFlyerResolver implements GraphQLResolver<FrequentFlyer> {

    private TripServiceDefinition tripServiceDefinition;

    public FrequentFlyerResolver(TripServiceDefinition tripServiceDefinition) {
        this.tripServiceDefinition = tripServiceDefinition;
    }

    public List<Trip> getTrips(FrequentFlyer frequentFlyer) {
        return tripServiceDefinition.getTripsByFrequentFlyerId(frequentFlyer.getId());
    }
}