package com.champsoft.healthcaremilestone.modules.doctor.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.doctor.application.port.out.DoctorRepositoryPort;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JpaDoctorRepositoryAdapter implements DoctorRepositoryPort {

    private final SpringDataDoctorRepository repo;

    public JpaDoctorRepositoryAdapter(SpringDataDoctorRepository repo) {
        this.repo = repo;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return toDomain(repo.save(toEntity(doctor)));
    }

    @Override
    public Optional<Doctor> findById(UUID id) {
        return repo.findById(id).map(this::toDomain);
    }

    @Override
    public List<Doctor> findAll() {
        return repo.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }
    @Override
    public boolean existsById(UUID id) {
        return repo.existsById(id);
    }

    // mapping

    private DoctorJpaEntity toEntity(Doctor d) {
        DoctorJpaEntity e = new DoctorJpaEntity();

        e.setId(d.getId().value());
        e.setFirstName(d.getFirstName());
        e.setLastName(d.getLastName());
        e.setSpecialty(d.getSpecialty());
        e.setStatus(d.getStatus().name());

        return e;
    }

    private Doctor toDomain(DoctorJpaEntity e) {
        Doctor d = new Doctor(
                new DoctorId(e.getId()),
                e.getFirstName(),
                e.getLastName(),
                e.getSpecialty()
        );

        if ("INACTIVE".equals(e.getStatus())) {
            d.deactivate();
        }

        return d;
    }
}