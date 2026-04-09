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
    private final String name;
    private final LocalDate licenseExpiryDate;

    private final List<DoctorAvailability> availabilities = new ArrayList<>();

    public Doctor(UUID id, String name, LocalDate licenseExpiryDate) {
        this.id = id;
        this.name = name;
        this.licenseExpiryDate = licenseExpiryDate;
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
            throw new DoctorLicenseExpiredException("Doctor license expired: " + name);
        }
    }

    /**
     * Doctor is active if the license is valid
     */
    public boolean isActive() {
        return isLicenseValid();
    }
}