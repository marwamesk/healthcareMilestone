package com.champsoft.healthcaremilestone.modules.doctor.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "doctors")
public class DoctorJpaEntity {

    // getters & setters
    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String specialty;
    private String status;

}