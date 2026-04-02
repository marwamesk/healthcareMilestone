package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class AppointmentJpaEntity {

    @Id
    private UUID id;

    private UUID patientId;
    private UUID doctorId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String status;

    // getters & setters
}