package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.ACL;

import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.DoctorEligibilityPort;
import org.springframework.stereotype.Component;

@Component
public class DoctorEligibilityAdapter implements DoctorEligibilityPort {
    @Override
    public boolean exists(String doctorId) {
        return true; // replace with real repo call
    }
}