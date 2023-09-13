package com.nevinabradley.maintenancerequestserver.domain.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceCreationException extends RuntimeException{
    //sends an error that says there was an issue creating the request
    public ResourceCreationException(String message) {
        super(message);
    }
}
