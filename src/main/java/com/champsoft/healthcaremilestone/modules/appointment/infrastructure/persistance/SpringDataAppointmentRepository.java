package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SpringDataAppointmentRepository extends JpaRepository<AppointmentJpaEntity, UUID> {
}
