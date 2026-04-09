package com.champsoft.healthcaremilestone.modules.doctor.api.mapper;

import com.champsoft.healthcaremilestone.modules.doctor.api.dto.CreateDoctorRequest;
import com.champsoft.healthcaremilestone.modules.doctor.api.dto.DoctorResponse;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

import java.util.UUID;

public class DoctorDtoMapper {

    // Map CreateDoctorRequest DTO → Doctor domain
    public static Doctor toDomain(CreateDoctorRequest request) {
        return new Doctor(
                UUID.randomUUID(),
                request.getFirstName() + " " + request.getLastName(),
                request.getLicenseExpiryDate()
        );
    }

    // Map Doctor domain → DoctorResponse DTO
    public static DoctorResponse toResponse(Doctor doctor) {
        // Split full name into first/last
        String[] parts = doctor.getFirstName().split(" ", 2);

        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId());
        response.setFirstName(parts[0]);
        response.setLastName(parts.length > 1 ? parts[1] : "");
        response.setLicenseExpiryDate(doctor.getLicenseExpiryDate());
        response.setActive(doctor.isActive());

        return response;
    }
}