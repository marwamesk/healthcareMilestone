package com.champsoft.healthcaremilestone.modules.patient.infrastructure.persistence;

import com.champsoft.healthcaremilestone.modules.patient.domain.model.Address;
import com.champsoft.healthcaremilestone.modules.patient.domain.model.Health_insuranceCard;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="patients")
public class PatientJpaEntity {

    @Id
    public String id;

    @Column(nullable = false)
    public String firstName;

    @Column(nullable = false)
    public String lastName;

    @Column(nullable = false,unique = true)
    public String phoneNumber;

    @Column(nullable = false,unique = true)
    public String email;

    @Column(nullable = false)
    public LocalDate dateOfBirth;

    @Embedded
    public Health_insuranceCard insuranceCard;

    @Embedded
    public Address address;

    @Column(nullable = false)
    public String status;


}
