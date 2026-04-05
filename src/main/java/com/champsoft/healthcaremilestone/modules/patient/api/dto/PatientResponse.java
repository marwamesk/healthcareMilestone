package com.champsoft.healthcaremilestone.modules.patient.api.dto;

import com.champsoft.healthcaremilestone.modules.patient.domain.model.Patient;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.PatientStatus;

public record PatientResponse(
        String id,
        String firstName,
        String lastName,
        PatientStatus status
) {
}
