package com.champsoft.healthcaremilestone.modules.patient.api.dto;

import com.champsoft.healthcaremilestone.modules.patient.domain.model.PatientStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PatientResponseAddress (
        String id,
        String firstName,
        String lastName,
        Integer streetNumber,
        String streetName,
        String city,
        String postalCode,
        String Country,
        PatientStatus status
){
}
