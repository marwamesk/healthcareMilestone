package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.UUID;

public interface SpringDataAppointmentRepository
        extends JpaRepository<AppointmentJpaEntity, UUID> {

    @Query("""
        SELECT COUNT(a) > 0 FROM AppointmentJpaEntity a
        WHERE a.doctorId = :doctorId
        AND a.startTime < :endTime
        AND a.endTime > :startTime
    """)
    boolean existsOverlappingAppointment(
            UUID doctorId,
            LocalDateTime startTime,
            LocalDateTime endTime
    );
}