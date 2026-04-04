package com.champsoft.healthcaremilestone.modules.patient.application.service;

import com.champsoft.healthcaremilestone.modules.patient.application.exception.DuplicatePatientException;
import com.champsoft.healthcaremilestone.modules.patient.application.port.out.PatientRepositoryPort;
import com.champsoft.healthcaremilestone.modules.patient.domain.exception.PatientNotFoundException;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientCrudService {

    private final PatientRepositoryPort repo;

    public PatientCrudService(PatientRepositoryPort repo){
        this.repo =repo;
    }

    @Transactional
    public Patient create(String firstName, String lastName, String phoneNumber, String email, LocalDate dateOfBirth, Health_insuranceCard insuranceCard, Address address, PatientStatus status){
        Health_insuranceCard h = new Health_insuranceCard(insuranceCard.insuranceCardNumber(),insuranceCard.getExpiryDate());
        if(repo.existByInsuranceCard(h.insuranceCardNumber())) throw new DuplicatePatientException("Patient already exists");
        Address address1 = new Address(address.getStreetNumber(),address.getStreetName(), address.getCity(),address.getPostalCode(), address.getCountry());
        var patient = new Patient(PatientId.newId(),firstName,lastName,phoneNumber,email,dateOfBirth,insuranceCard,address,status);

        return repo.save(patient);
    }

    @Transactional(readOnly = true)
    public Patient findById(String id){
        return repo.findById(new PatientId(id)).orElseThrow(()-> new PatientNotFoundException("Patient: " + id+" not found"));
    }

    @Transactional(readOnly = true)
    public List<Patient> list(){
        return repo.findAll();
    }




}
