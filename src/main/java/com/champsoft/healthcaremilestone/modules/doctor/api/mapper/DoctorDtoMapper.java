package com.champsoft.healthcaremilestone.modules.doctor.api.mapper;

import com.champsoft.healthcaremilestone.modules.doctor.api.dto.DoctorResponse;
import com.champsoft.healthcaremilestone.modules.doctor.api.dto.CreateDoctorRequest;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

import java.util.UUID;

public class DoctorDtoMapper {

    public static Doctor toDomain(CreateDoctorRequest request) {

        return new Doctor(
                UUID.randomUUID().toString(),
                request.getFirstName(),
                request.getLastName(),
                request.getSpeciality(),
                request.getLicenseExpiryDate()
        );
    }

    public static DoctorResponse toResponse(Doctor doctor) {

        DoctorResponse response = new DoctorResponse();
        response.setId(String.valueOf(UUID.fromString(doctor.getId())));
        response.setFirstName(doctor.getFirstName());
        response.setLastName(doctor.getLastName());
        response.setSpeciality(doctor.getSpecialty());
        response.setActive(doctor.isActive());

        return response;
    }
}