package com.pocs.graphqlpoc.resolver;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import com.pocs.graphqlpoc.model.FrequentFlyer;
import com.pocs.graphqlpoc.model.Trip;
import com.pocs.graphqlpoc.service.definition.FrequentFlyerServiceDefinition;
import com.pocs.graphqlpoc.service.definition.TripServiceDefinition;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    private FrequentFlyerServiceDefinition frequentFlyerServiceDefinition;
    private TripServiceDefinition tripServiceDefinition;

    public MutationResolver(FrequentFlyerServiceDefinition frequentFlyerServiceDefinition,
                            TripServiceDefinition tripServiceDefinition) {
        this.frequentFlyerServiceDefinition = frequentFlyerServiceDefinition;
        this.tripServiceDefinition = tripServiceDefinition;
    }

    public FrequentFlyer createFrequentFlyer(String membershipId, String firstName, String lastName, int points) {
        return frequentFlyerServiceDefinition.createFrequentFlyer(membershipId, firstName, lastName, points);
    }

    public Trip createTrip(String origin, String destination, LocalDateTime departureDate, int flightNumber,
                           String airline, String frequentFlyerMembershipId) {
        return tripServiceDefinition.createTrip(origin, destination, departureDate, flightNumber, airline,
            frequentFlyerMembershipId);
    }
}