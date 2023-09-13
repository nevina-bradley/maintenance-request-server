package com.nevinabradley.maintenancerequestserver.domain.maintenanceRequest.controllers;

import com.nevinabradley.maintenancerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import com.nevinabradley.maintenancerequestserver.domain.maintenanceRequest.services.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//sets up the front end local host page
@CrossOrigin(origins="http://localhost:3000")
//sends the data as a json object to this page
@RequestMapping("/api/v1/maintenance-request")

public class MaintenanceRequestController {
    private MaintenanceRequestService maintenanceRequestService;

    @Autowired
    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequestService) {this.maintenanceRequestService = maintenanceRequestService;}

    @GetMapping
    public ResponseEntity<List<MaintenanceRequest>> getAll() {
        //gets and returns all maintenance requests
        List<MaintenanceRequest> maintenanceRequests = maintenanceRequestService.getAll();
        return new ResponseEntity<>(maintenanceRequests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaintenanceRequest> create(@RequestBody MaintenanceRequest maintenanceRequest) {
        //posts and creates a new maintenance request
        maintenanceRequest = maintenanceRequestService.create(maintenanceRequest);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MaintenanceRequest> getById(@PathVariable("id") Long id){
        //gets a maintenance request by a searched id
        MaintenanceRequest maintenanceRequest = maintenanceRequestService.getById(id);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<MaintenanceRequest> getByEmail(@RequestParam String email){
        //gets a maintenance request by a searched email
        MaintenanceRequest maintenanceRequest = maintenanceRequestService.getByEmail(email);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<MaintenanceRequest> update(@PathVariable("id") Long id, @RequestBody MaintenanceRequest maintenanceRequestDetail){
        //updates an existing maintenance request and returns it
        maintenanceRequestDetail = maintenanceRequestService.update(id, maintenanceRequestDetail);
        return new ResponseEntity<>(maintenanceRequestDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        //deletes a chosen maintenance request
        maintenanceRequestService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
