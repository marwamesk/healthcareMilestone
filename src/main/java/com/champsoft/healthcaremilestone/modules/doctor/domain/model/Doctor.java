package com.champsoft.healthcaremilestone.modules.doctor.domain.model;

public class Doctor {

    private final DoctorId id;
    private String firstName;
    private String lastName;
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

    public DoctorId getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSpecialty() { return specialty; }
    public DoctorStatus getStatus() { return status; }

    public void deactivate() {
        this.status = DoctorStatus.INACTIVE;
    }
}