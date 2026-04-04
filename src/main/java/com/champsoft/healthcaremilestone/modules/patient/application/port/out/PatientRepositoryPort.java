package com.champsoft.healthcaremilestone.modules.patient.application.port.out;

import com.champsoft.healthcaremilestone.modules.patient.domain.model.Health_insuranceCard;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.Patient;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.PatientId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepositoryPort {

    Patient save(Patient patient);

    Optional<Patient> findById(PatientId patientId);

    List<Patient> findAll();

    void deleteById(PatientId patientId);

    boolean existsById(PatientId patientId);
    boolean existByInsuranceCard(String cardNumber);
}
