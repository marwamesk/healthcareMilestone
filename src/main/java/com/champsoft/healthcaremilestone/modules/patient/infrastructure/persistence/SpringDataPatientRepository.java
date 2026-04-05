package com.champsoft.healthcaremilestone.modules.patient.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.appointment.domain.model.Appointment;
import com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance.AppointmentJpaEntity;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataPatientRepository extends JpaRepository<PatientJpaEntity,String> {

    Optional<PatientJpaEntity> findById(String id);
    boolean existsById(String id);


}
