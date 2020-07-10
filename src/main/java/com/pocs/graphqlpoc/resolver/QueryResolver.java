package com.pocs.graphqlpoc.resolver;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.pocs.graphqlpoc.model.FrequentFlyer;
import com.pocs.graphqlpoc.model.Trip;
import com.pocs.graphqlpoc.service.definition.FrequentFlyerServiceDefinition;
import com.pocs.graphqlpoc.service.definition.TripServiceDefinition;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private FrequentFlyerServiceDefinition frequentFlyerServiceDefinition;
    private TripServiceDefinition tripServiceDefinition;

    public QueryResolver(FrequentFlyerServiceDefinition frequentFlyerServiceDefinition,
                         TripServiceDefinition tripServiceDefinition) {
        this.frequentFlyerServiceDefinition = frequentFlyerServiceDefinition;
        this.tripServiceDefinition = tripServiceDefinition;
    }

    public Page<FrequentFlyer> getFrequentFlyers(int pageNumber, int pageSize) {
        return frequentFlyerServiceDefinition.getFrequentFlyers(pageNumber, pageSize);
    }

    public FrequentFlyer getFrequentFlyer(String membershipId) {
        return frequentFlyerServiceDefinition.getFrequentFlyerByMembershipId(membershipId);
    }

    public Page<Trip> getRecentTrips(int pageNumber, int pageSize) {
        return tripServiceDefinition.getRecentTrips(pageNumber, pageSize);
    }
}