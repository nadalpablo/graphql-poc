package com.pocs.graphqlpoc.resolver;

import java.util.List;

import org.springframework.stereotype.Component;
import com.pocs.graphqlpoc.model.Trip;
import com.pocs.graphqlpoc.service.definition.TripServiceDefinition;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private TripServiceDefinition tripServiceDefinition;

    public QueryResolver(TripServiceDefinition tripServiceDefinition) {
        this.tripServiceDefinition = tripServiceDefinition;
    }

    public List<Trip> getRecentTrips(int pageNumber, int pageSize) {
        return tripServiceDefinition.getRecentTrips(pageNumber, pageSize);
    }
}