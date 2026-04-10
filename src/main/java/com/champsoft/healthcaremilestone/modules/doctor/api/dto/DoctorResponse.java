package com.champsoft.healthcaremilestone.modules.doctor.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class DoctorResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String speciality;
    private boolean active;

}