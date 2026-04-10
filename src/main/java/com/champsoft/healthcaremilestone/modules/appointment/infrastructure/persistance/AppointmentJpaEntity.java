package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance;

import com.champsoft.healthcaremilestone.modules.appointment.domain.model.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "appointment")
public class AppointmentJpaEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String doctorId;

    @Column(nullable = false)
    private String patientId;

    @Column(nullable = false)
    private String billingId;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @Column(nullable = false)
    private LocalDateTime time;
}