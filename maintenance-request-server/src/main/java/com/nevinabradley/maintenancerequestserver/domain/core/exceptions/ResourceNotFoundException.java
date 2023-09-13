package com.nevinabradley.maintenancerequestserver.domain.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    //sends an error that says that the searched item couldn't be found
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
