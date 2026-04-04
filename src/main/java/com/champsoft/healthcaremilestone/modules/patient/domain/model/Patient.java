package com.champsoft.healthcaremilestone.modules.patient.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Patient {

    private final PatientId id;
    private String firstName;
    private String lastName;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private LocalDate dateOfBirth;
    private final Health_insuranceCard insuranceCard;
    @Getter
    private final Address address;
    @Getter
    @Setter
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

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }




}
