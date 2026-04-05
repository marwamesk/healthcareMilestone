package com.champsoft.healthcaremilestone.modules.appointment.application.port.out;

import java.util.UUID;

public interface DoctorLookupPort {
    boolean existsById(UUID doctorId);
}