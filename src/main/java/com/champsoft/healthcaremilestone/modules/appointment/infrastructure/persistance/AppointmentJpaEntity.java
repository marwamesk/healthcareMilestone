package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "appointments")
public class AppointmentJpaEntity {

    // getters & setters
    @Id
    private UUID id;

    private UUID patientId;
    private UUID doctorId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String status;

}