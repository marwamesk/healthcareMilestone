package com.champsoft.healthcaremilestone.modules.doctor.api.mapper;

import com.champsoft.healthcaremilestone.modules.doctor.api.dto.*;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

import java.util.UUID;

public class DoctorDtoMapper {

    public static Doctor toDomain(CreateDoctorRequest request) {
        return new Doctor(
                UUID.randomUUID(),
                request.getFirstName() + " " + request.getLastName(),
                request.getLicenseExpiryDate()
        );
    }

    public static DoctorResponse toResponse(Doctor doctor) {
        String[] parts = doctor.getName().split(" ", 2);

        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId());
        response.setFirstName(parts[0]);
        response.setLastName(parts.length > 1 ? parts[1] : "");
        response.setLicenseExpiryDate(doctor.getLicenseExpiryDate());
        response.setActive(doctor.isActive());

        return response;
    }
}