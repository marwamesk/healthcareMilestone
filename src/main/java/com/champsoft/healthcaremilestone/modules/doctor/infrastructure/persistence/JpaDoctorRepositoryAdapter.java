package com.champsoft.healthcaremilestone.modules.doctor.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.doctor.application.port.out.DoctorRepositoryPort;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JpaDoctorRepositoryAdapter implements DoctorRepositoryPort {

    private final DoctorRepository repository;

    public JpaDoctorRepositoryAdapter(DoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Doctor save(Doctor doctor) {
        DoctorJpaEntity entity = DoctorMapper.toEntity(doctor);
        return DoctorMapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<Doctor> findById(UUID id) {
        return repository.findById(id)
                .map(DoctorMapper::toDomain);
    }

    @Override
    public List<Doctor> findAll() {
        return repository.findAll()
                .stream()
                .map(DoctorMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }
}