package com.champsoft.healthcaremilestone.modules.appointment.domain.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Appointment {

    private final AppointmentId id;
    private UUID patientId;
    private UUID doctorId;
    private TimeSlot timeSlot;
    private AppointmentStatus status;

    public Appointment(AppointmentId id, UUID patientId, UUID doctorId, TimeSlot timeSlot) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.timeSlot = timeSlot;
        this.status = AppointmentStatus.SCHEDULED; // ✅ FIXED
    }

    public void cancel() {
        if (status == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Cannot cancel completed appointment");
        }
        this.status = AppointmentStatus.CANCELLED;
    }

    public void complete() {
        if (status != AppointmentStatus.SCHEDULED) {
            throw new IllegalStateException("Only scheduled appointments can be completed");
        }
        this.status = AppointmentStatus.COMPLETED;
    }

    public void reschedule(TimeSlot newTimeSlot) {
        if (status != AppointmentStatus.SCHEDULED) {
            throw new IllegalStateException("Only scheduled appointments can be rescheduled");
        }
        this.timeSlot = newTimeSlot;
    }
}