package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.ACL;

import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.PatientEligibilityPort;
import org.springframework.stereotype.Component;

@Component
public class PatientEligibilityAdapter implements PatientEligibilityPort {
    @Override
    public boolean exists(String patientId) {
        return true;
    }
}