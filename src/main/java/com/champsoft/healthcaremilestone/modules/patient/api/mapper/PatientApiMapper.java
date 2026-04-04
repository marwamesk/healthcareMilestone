package com.champsoft.healthcaremilestone.modules.patient.api.mapper;

import com.champsoft.healthcaremilestone.modules.patient.api.PatientController;
import com.champsoft.healthcaremilestone.modules.patient.api.dto.PatientResponse;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.Patient;

public class PatientApiMapper {

    public static PatientResponse toResponse(Patient p){
        return new PatientResponse(
                p.id().getId(),
                p.firstName(),
                p.lastName()
        );
    }
}
