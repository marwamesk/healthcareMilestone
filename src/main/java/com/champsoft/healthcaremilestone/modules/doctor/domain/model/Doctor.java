package com.champsoft.healthcaremilestone.modules.doctor.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Doctor {

    private final DoctorId id;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String specialty;
    private DoctorStatus status;

    public Doctor(DoctorId id, String firstName, String lastName, String specialty) {
        if (firstName == null || lastName == null || specialty == null) {
            throw new IllegalArgumentException("Doctor fields cannot be null");
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.status = DoctorStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = DoctorStatus.INACTIVE;
    }
}