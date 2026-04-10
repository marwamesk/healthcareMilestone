package com.champsoft.healthcaremilestone.modules.patient.api.mapper;

import com.champsoft.healthcaremilestone.modules.patient.api.PatientController;
import com.champsoft.healthcaremilestone.modules.patient.api.dto.PatientResponse;
import com.champsoft.healthcaremilestone.modules.patient.api.dto.PatientResponseAddress;
import com.champsoft.healthcaremilestone.modules.patient.api.dto.PatientResponseHealthCard;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.Patient;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.PatientStatus;

import java.time.LocalDate;

public class PatientApiMapper {

    public static PatientResponse toResponse(Patient p){
        return new PatientResponse(
                p.id().getId(),
                p.firstName(),
                p.lastName(),
                p.status()
        );
    }

    public static PatientResponseAddress toResponseAddress(Patient p){
        return new PatientResponseAddress(
                p.id().getId(),
                p.firstName(),
                p.lastName(),
                p.getAddress().getStreetNumber(),
                p.getAddress().getStreetName(),
                p.getAddress().getCity(),
                p.getAddress().getPostalCode(),
                p.getAddress().getCountry(),
                p.status()
        );
    }

    public static PatientResponseHealthCard toResponseHealthCard(Patient p){
        return new PatientResponseHealthCard(
                p.id().getId(),
                p.firstName(),
                p.lastName(),
                p.insuranceCard().insuranceCardNumber(),
                p.insuranceCard().getExpiryDate(),
                p.status()
        );
    }

//    String id,
//    String firstName,
//    String lastName,
//    String cardNum,
//    LocalDate expiryDate,
//    PatientStatus status

}
