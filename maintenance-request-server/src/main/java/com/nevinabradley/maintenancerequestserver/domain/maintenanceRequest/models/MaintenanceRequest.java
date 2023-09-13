package com.nevinabradley.maintenancerequestserver.domain.maintenanceRequest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;


@Entity // JPA to save to the database
@NoArgsConstructor // Non argument constructor
@RequiredArgsConstructor // parameterized constructor
@Data // getters and setters
public class MaintenanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //declares id
    private Long id;

    @NonNull
    //declares first name
    private String firstName;

    @NonNull
    //declares last name
    private String lastName;

    @NonNull
    //declares email
    private String email;

    @NonNull
    //declares apartment number
    private String aptNo;

    @NonNull
    //declares description
    private String description;

    @NonNull
    //declares date and time the request was created at
    private Date createAt;

    //format the outputs/variables
    public String toString(){
        return String.format("%d %s %s %s %s %s t", id, firstName, lastName, email, aptNo, description, createAt);
    }
}
