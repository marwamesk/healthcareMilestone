package com.champsoft.healthcaremilestone.modules.billing.domain.model;

import com.champsoft.healthcaremilestone.modules.patient.domain.model.Patient;

public record PatientRef(String patientId) {
    public PatientRef{
        if(patientId==null) throw new IllegalArgumentException("patientId is required");
        patientId = patientId.trim();
        if(patientId.isEmpty()) throw new IllegalArgumentException("patientId is required");
    }
}
