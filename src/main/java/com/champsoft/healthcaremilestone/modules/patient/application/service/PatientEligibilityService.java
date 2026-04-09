package com.champsoft.healthcaremilestone.modules.patient.application.service;

import com.champsoft.healthcaremilestone.modules.billing.domain.exception.InvalidStatusRefund;
import com.champsoft.healthcaremilestone.modules.billing.domain.model.BillingId;
import com.champsoft.healthcaremilestone.modules.patient.application.port.out.PatientRepositoryPort;
import com.champsoft.healthcaremilestone.modules.patient.domain.exception.PatientEligibilityAppointmentException;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.Patient;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.PatientId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientEligibilityService {


    private final PatientRepositoryPort repo;

    public PatientEligibilityService(PatientRepositoryPort repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public boolean isEligibleForAppointment(String id){
        var v= repo.findById(PatientId.of(id)).orElseThrow(()-> new PatientEligibilityAppointmentException("Must be 18 years old and plus to book appointment"));
        return  v.isEligibleForAppointment();
    }
}
