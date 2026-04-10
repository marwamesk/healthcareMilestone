package com.champsoft.healthcaremilestone.modules.patient.api.dto;

import com.champsoft.healthcaremilestone.modules.patient.domain.model.PatientStatus;

import java.time.LocalDate;

public record PatientResponseHealthCard(
        String id,
        String firstName,
        String lastName,
        String cardNum,
        LocalDate expiryDate,
        PatientStatus status
) {
}
