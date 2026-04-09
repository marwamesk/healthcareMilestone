package com.champsoft.healthcaremilestone.modules.doctor.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

public class DoctorMapper {

    // DOMAIN → ENTITY
    public static DoctorJpaEntity toEntity(Doctor doctor) {
        DoctorJpaEntity e = new DoctorJpaEntity();

        e.setId(doctor.getId());
        e.setFirstName(doctor.getFirstName());
        e.setLastName(doctor.getLastName());
        e.setSpecialty(doctor.getSpecialty());
        e.setLicenseExpiryDate(doctor.getLicenseExpiryDate());
        e.setActive(doctor.isActive());

        return e;
    }

    // ENTITY → DOMAIN
    public static Doctor toDomain(DoctorJpaEntity e) {

        Doctor doctor = new Doctor(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getSpecialty(),
                e.getLicenseExpiryDate()
        );

        // restore active state
        if (!e.isActive()) {
            doctor.deactivate();
        }

        return doctor;
    }
}