package com.champsoft.healthcaremilestone.modules.doctor.domain.model;

import com.champsoft.healthcaremilestone.modules.doctor.domain.exception.DoctorLicenseExpiredException;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;

public class Doctor {

    @Getter
    private final UUID id;
    @Getter
    private final String name;
    @Getter
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
        return availabilities.stream().anyMatch(a -> a.matches(dateTime));
    }

    public boolean isLicenseValid() {
        return !licenseExpiryDate.isBefore(LocalDate.now());
    }

    public void validateLicense() {
        if (!isLicenseValid()) {
            throw new DoctorLicenseExpiredException("Doctor license expired");
        }
    }

}