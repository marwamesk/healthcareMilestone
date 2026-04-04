package com.champsoft.healthcaremilestone.modules.patient.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Patient {

    private final PatientId id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private final Health_insuranceCard insuranceCard;
    private Address address;
    private PatientStatus status;

    public Patient(PatientId id, String firstName, String lastName, String phoneNumber, String email, LocalDate dateOfBirth, Health_insuranceCard insuranceCard, Address address, PatientStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.insuranceCard = insuranceCard;
        this.address = address;
        this.status = status;
    }

    public PatientId id(){
        return id;
    }

    public String fullName(){
        return firstName+" "+ lastName;
    }

    public String firstName(){
        return firstName;
    }

    public String lastName(){
        return lastName;
    }

    public Health_insuranceCard insuranceCard(){
        return insuranceCard;
    }

    public PatientStatus status(){
        return status;
    }




}
