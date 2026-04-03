package com.champsoft.healthcaremilestone.modules.appointment.domain.model;

import java.util.UUID;

public class Appointment {

    private final AppointmentId id;
    private final UUID patientId;
    private final UUID doctorId;
    private final TimeSlot timeSlot;
    private AppointmentStatus status;

    public Appointment(AppointmentId id, UUID patientId, UUID doctorId, TimeSlot timeSlot) {

        if (patientId == null || doctorId == null) {
            throw new IllegalArgumentException("Patient and Doctor required");
        }

        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.timeSlot = timeSlot;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public AppointmentId getId() { return id; }
    public UUID getPatientId() { return patientId; }
    public UUID getDoctorId() { return doctorId; }
    public TimeSlot getTimeSlot() { return timeSlot; }
    public AppointmentStatus getStatus() { return status; }

    public void cancel() {
        if (status == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Cannot cancel completed appointment");
        }
        this.status = AppointmentStatus.CANCELLED;
    }
}