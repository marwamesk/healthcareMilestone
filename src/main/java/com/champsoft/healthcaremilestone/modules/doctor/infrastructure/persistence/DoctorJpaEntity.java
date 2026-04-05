package com.champsoft.healthcaremilestone.modules.doctor.infrastructure.persistence;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "doctors")
public class DoctorJpaEntity {

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String specialty;
    private String status;

    // getters & setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}