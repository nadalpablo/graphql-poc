package com.pocs.graphqlpoc.model.exception;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class EntityDoesNotExistException extends RuntimeException implements GraphQLError {

    private static final int ERROR_CODE = 404;
    private static final String ERROR_MESSAGE = "exception.entity-does-not-exist";

    public EntityDoesNotExistException() {
        super(ERROR_MESSAGE);
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> customAttributes = Maps.newLinkedHashMap();
        customAttributes.put("errorCode", ERROR_CODE);
        customAttributes.put("errorMessage", ERROR_MESSAGE);
        return customAttributes;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }
}
