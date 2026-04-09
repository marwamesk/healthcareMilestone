package com.champsoft.healthcaremilestone.modules.doctor.application.service;

import com.champsoft.healthcaremilestone.modules.doctor.application.port.out.DoctorRepositoryPort;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorCrudService {

    private final DoctorRepositoryPort repository;

    public DoctorCrudService(DoctorRepositoryPort repository) {
        this.repository = repository;
    }

    @Transactional
    public Doctor create(Doctor doctor) {
        return repository.save(doctor);
    }

    @Transactional(readOnly = true)
    public List<Doctor> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Doctor getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found: " + id));
    }

    @Transactional
    public Doctor update(UUID id, Doctor doctor) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Doctor not found: " + id);
        }
        return repository.save(doctor);
    }

    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Doctor not found: " + id);
        }
        repository.deleteById(id);
    }
}