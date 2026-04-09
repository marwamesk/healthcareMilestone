package com.champsoft.healthcaremilestone.modules.doctor.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class DoctorResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate licenseExpiryDate;
    private boolean active;

}