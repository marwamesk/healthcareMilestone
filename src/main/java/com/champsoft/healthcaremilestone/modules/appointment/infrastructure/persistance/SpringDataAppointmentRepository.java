package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance;

import com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance.AppointmentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAppointmentRepository
        extends JpaRepository<AppointmentJpaEntity, String> {}