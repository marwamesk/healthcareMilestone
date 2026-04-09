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
    AND a.startTime < :end
    AND a.endTime > :start
""")
    boolean existsOverlapping(UUID doctorId, LocalDateTime start, LocalDateTime end);

    @Query("""
    SELECT COUNT(a) > 0 FROM AppointmentJpaEntity a
    WHERE a.id <> :id
    AND a.doctorId = :doctorId
    AND a.startTime < :end
    AND a.endTime > :start
""")
    boolean existsOverlappingExcludingId(UUID id, UUID doctorId, LocalDateTime start, LocalDateTime end);

}