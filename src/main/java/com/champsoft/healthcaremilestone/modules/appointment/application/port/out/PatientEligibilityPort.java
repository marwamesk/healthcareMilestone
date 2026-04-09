package com.champsoft.healthcaremilestone.modules.appointment.application.port.out;

public interface PatientEligibilityPort {
    boolean exists(String patientId);
}