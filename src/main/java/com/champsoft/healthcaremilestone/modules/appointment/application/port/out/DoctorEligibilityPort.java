package com.champsoft.healthcaremilestone.modules.appointment.application.port.out;

public interface DoctorEligibilityPort {
    boolean exists(String doctorId);
}