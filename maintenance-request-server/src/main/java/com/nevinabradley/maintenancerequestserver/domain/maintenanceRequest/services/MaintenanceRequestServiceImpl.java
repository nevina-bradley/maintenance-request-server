package com.nevinabradley.maintenancerequestserver.domain.maintenanceRequest.services;

import com.nevinabradley.maintenancerequestserver.domain.core.exceptions.ResourceCreationException;
import com.nevinabradley.maintenancerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.nevinabradley.maintenancerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import com.nevinabradley.maintenancerequestserver.domain.maintenanceRequest.repos.MaintenanceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {
    private MaintenanceRequestRepo maintenanceRequestRepo;

    @Autowired
    public MaintenanceRequestServiceImpl(MaintenanceRequestRepo maintenanceRequestRepo) {this.maintenanceRequestRepo = maintenanceRequestRepo;}

    @Override
    public MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
        //sends an error if an email already exists in the database
        Optional<MaintenanceRequest> optional = maintenanceRequestRepo.findByEmail(maintenanceRequest.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Maintenance request with email already exists: " + maintenanceRequest.getEmail());
        maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
        //sends an error if an id that was searched doesn't exist
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No maintenance request with id: " + id));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
        //sends an error if an email that was searched doesn't exist
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("No maintenance request with email: " + email));
        return maintenanceRequest;
    }

    @Override
    //lists all maintenance requests in the database
    public List<MaintenanceRequest> getAll() {return maintenanceRequestRepo.findAll();}

    @Override
    public MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException {
        //get all fields and update anything that has changed
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequest.setFirstName(maintenanceRequestDetail.getFirstName());
        maintenanceRequest.setLastName(maintenanceRequestDetail.getLastName());
        maintenanceRequest.setEmail(maintenanceRequestDetail.getEmail());
        maintenanceRequest.setAptNo(maintenanceRequestDetail.getAptNo());
        maintenanceRequest.setDescription(maintenanceRequestDetail.getDescription());
        maintenanceRequest.setCreateAt(maintenanceRequestDetail.getCreateAt());
        maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public void delete(Long id) {
        //delete a request
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequestRepo.delete(maintenanceRequest);
    }
}
