package com.champsoft.healthcaremilestone.modules.doctor.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

public class DoctorMapper {

    public static Doctor toDomain(DoctorJpaEntity entity) {
        String fullName = entity.getFirstName() + " " + entity.getLastName();

        return new Doctor(
                entity.getId(),
                fullName,
                entity.getLicenseExpiryDate()
        );
    }

    public static DoctorJpaEntity toEntity(Doctor doctor) {
        DoctorJpaEntity entity = new DoctorJpaEntity();

        entity.setId(doctor.getId());

        String[] parts = doctor.getName().split(" ", 2);
        entity.setFirstName(parts[0]);
        entity.setLastName(parts.length > 1 ? parts[1] : "");

        entity.setLicenseExpiryDate(doctor.getLicenseExpiryDate());

        return entity;
    }
}