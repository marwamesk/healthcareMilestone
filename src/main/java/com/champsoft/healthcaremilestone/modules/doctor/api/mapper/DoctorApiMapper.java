package com.champsoft.healthcaremilestone.modules.doctor.api.mapper;

import com.champsoft.healthcaremilestone.modules.doctor.api.dto.DoctorResponse;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

public class DoctorApiMapper {

    private DoctorApiMapper() {}

    public static DoctorResponse toResponse(Doctor d) {
        return new DoctorResponse(
                d.getId().value(),
                d.getFirstName(),
                d.getLastName(),
                d.getSpecialty(),
                d.getStatus().name()
        );
    }
}