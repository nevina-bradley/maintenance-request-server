package com.nevinabradley.maintenancerequestserver.domain.maintenanceRequest.services;

import com.nevinabradley.maintenancerequestserver.domain.core.exceptions.ResourceCreationException;
import com.nevinabradley. maintenancerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.nevinabradley.maintenancerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;

import java.util.List;

public interface MaintenanceRequestService {
    //creates a maintenance request
    MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;

    //takes in an id
    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;

    //takes in an email
    MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException;

    //gets all requests and puts them in a list to return
    List<MaintenanceRequest> getAll();

    //updates a given request
    MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException;

    //deletes a given request
    void delete(Long id);
}
