package com.champsoft.healthcaremilestone.modules.doctor.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.DoctorLookupPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DoctorLookupAdapter implements DoctorLookupPort {

    private final SpringDataDoctorRepository repo;

    public DoctorLookupAdapter(SpringDataDoctorRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean existsById(UUID doctorId) {
        return repo.existsById(doctorId);
    }
}