package com.champsoft.healthcaremilestone.modules.appointment.application.service;

import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.AppointmentRepositoryPort;
import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.DoctorLookupPort;
import com.champsoft.healthcaremilestone.modules.appointment.domain.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentCrudService {

    private final AppointmentRepositoryPort repository;
    private final DoctorLookupPort doctorLookup;

    public AppointmentCrudService(
            AppointmentRepositoryPort repository,
            DoctorLookupPort doctorLookup
    ) {
        this.repository = repository;
        this.doctorLookup = doctorLookup;
    }

    public Appointment create(UUID patientId, UUID doctorId, TimeSlot timeSlot) {

        // doctor must exist
        if (!doctorLookup.existsById(doctorId)) {
            throw new RuntimeException("Doctor does not exist");
        }

        // overlap validation
        if (repository.existsOverlapping(
                doctorId,
                timeSlot.getStart(),
                timeSlot.getEnd()
        )) {
            throw new RuntimeException("Doctor already has an appointment in this time slot");
        }

        Appointment appointment = new Appointment(
                new AppointmentId(UUID.randomUUID()),
                patientId,
                doctorId,
                timeSlot
        );

        return repository.save(appointment);
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }

    public Appointment getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}