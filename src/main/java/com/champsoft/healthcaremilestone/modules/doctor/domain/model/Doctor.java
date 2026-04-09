package com.champsoft.healthcaremilestone.modules.doctor.domain.model;

import com.champsoft.healthcaremilestone.modules.doctor.domain.exception.DoctorLicenseExpiredException;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Doctor {

    private final UUID id;

    private String firstName;
    private String lastName;
    private String specialty;

    private LocalDate licenseExpiryDate;
    private boolean active;

    private final List<DoctorAvailability> availabilities = new ArrayList<>();

    public Doctor(UUID id, String firstName, String lastName, String specialty, LocalDate licenseExpiryDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.licenseExpiryDate = licenseExpiryDate;
        this.active = true;
    }

    public Doctor(UUID id, String firstName, LocalDate licenseExpiryDate) {
        this.id = id;
        this.firstName = firstName;
        this.licenseExpiryDate = licenseExpiryDate;
        this.active = true;
        this.lastName = firstName;
        this.specialty = firstName;
    }


    public void addAvailability(DoctorAvailability availability) {
        availabilities.add(availability);
    }

    public boolean isAvailable(LocalDateTime dateTime) {
        return availabilities.stream().noneMatch(a -> a.matches(dateTime));
    }



    public boolean isLicenseValid() {
        return licenseExpiryDate != null && !licenseExpiryDate.isBefore(LocalDate.now());
    }

    public void validateLicense() {
        if (!isLicenseValid()) {
            throw new DoctorLicenseExpiredException("Doctor license expired: " + firstName + " " + lastName);
        }
    }



    public void updateInfo(String firstName, String lastName, String specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public void updateLicense(LocalDate expiryDate) {
        if (expiryDate == null) {
            throw new RuntimeException("Expiry date cannot be null");
        }
        this.licenseExpiryDate = expiryDate;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
}