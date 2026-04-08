package com.champsoft.healthcaremilestone.modules.doctor.application.service;
import com.champsoft.healthcaremilestone.modules.doctor.application.port.out.DoctorRepositoryPort;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorCrudService {

    private final DoctorRepositoryPort repo;

    public DoctorCrudService(DoctorRepositoryPort repo) {
        this.repo = repo;
    }

    public Doctor create(String firstName, String lastName, String specialty) {
        Doctor doctor = new Doctor(
                DoctorId.newId(),
                firstName,
                lastName,
                specialty
        );

        return repo.save(doctor);
    }

    public List<Doctor> getAll() {
        return repo.findAll();
    }

    public Doctor getById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }
    public Doctor update(UUID id, String firstName, String lastName, String specialty) {

        Doctor doctor = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setSpecialty(specialty);

        return repo.save(doctor);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}