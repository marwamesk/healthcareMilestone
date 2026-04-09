package com.champsoft.healthcaremilestone.modules.doctor.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.DoctorLookupPort;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class DoctorLookupAdapter implements DoctorLookupPort {

    private final DoctorRepository repository;

    public DoctorLookupAdapter(DoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Doctor> findById(UUID doctorId) {
        return repository.findById(doctorId)
                .map(DoctorMapper::toDomain);
    }
}