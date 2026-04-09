package com.champsoft.healthcaremilestone.modules.appointment.application.port.out;

import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

import java.util.Optional;
import java.util.UUID;

public interface DoctorLookupPort {

    Optional<Doctor> findById(UUID doctorId);

}