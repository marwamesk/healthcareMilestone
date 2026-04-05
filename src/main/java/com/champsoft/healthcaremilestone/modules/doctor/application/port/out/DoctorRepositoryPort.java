package com.champsoft.healthcaremilestone.modules.doctor.application.port.out;

import com.champsoft.healthcaremilestone.modules.doctor.domain.model.*;

import java.util.*;

public interface DoctorRepositoryPort {

    Doctor save(Doctor doctor);

    Optional<Doctor> findById(UUID id);

    List<Doctor> findAll();

    void deleteById(UUID id);

    boolean existsById(UUID id);
}