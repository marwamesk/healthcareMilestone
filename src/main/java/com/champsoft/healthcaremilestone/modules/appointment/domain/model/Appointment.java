package com.champsoft.healthcaremilestone.modules.appointment.domain.model;

public class Appointment {

    private final AppointmentId id;
    private final DoctorRef doctorId;
    private final PatientRef patientId;
    private AppointmentTime time;
    private AppointmentStatus status;

    public Appointment(AppointmentId id,
                       DoctorRef doctorId,
                       PatientRef patientId,
                       AppointmentTime time) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.time = time;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public AppointmentId id() { return id; }
    public DoctorRef doctorId() { return doctorId; }
    public PatientRef patientId() { return patientId; }
    public AppointmentTime time() { return time; }
    public AppointmentStatus status() { return status; }

    public String doctorIdValue() { return doctorId.value(); }
    public String patientIdValue() { return patientId.value(); }
    public java.time.LocalDateTime timeValue() { return time.value(); }

    public void complete() { this.status = AppointmentStatus.COMPLETED; }
    public void cancel() { this.status = AppointmentStatus.CANCELLED; }
    public void reschedule(AppointmentTime newTime) {
        if (status != AppointmentStatus.SCHEDULED) {
            throw new RuntimeException("Only scheduled appointments can be rescheduled");
        }
        this.time = newTime;
    }
}