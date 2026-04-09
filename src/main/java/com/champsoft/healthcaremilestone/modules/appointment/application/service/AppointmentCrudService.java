package com.champsoft.healthcaremilestone.modules.appointment.application.service;

import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.*;

import com.champsoft.healthcaremilestone.modules.appointment.domain.exception.*;

import com.champsoft.healthcaremilestone.modules.appointment.domain.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Transactional
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

        if (!doctorLookup.existsById(doctorId)) {
            throw new DoctorNotFoundException("Doctor not found: " + doctorId);
        }

        if (repository.existsOverlapping(
                doctorId,
                timeSlot.start(),
                timeSlot.end()
        )) {
            throw new TimeSlotConflictException("Doctor already booked in this time slot");
        }

        Appointment appointment = new Appointment(
                new AppointmentId(UUID.randomUUID()),
                patientId,
                doctorId,
                timeSlot
        );

        return repository.save(appointment);
    }

    @Transactional(readOnly = true)
    public List<Appointment> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Appointment getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found: " + id));
    }

    public Appointment update(UUID id, UUID patientId, UUID doctorId, TimeSlot timeSlot) {

        Appointment existing = repository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found: " + id));

        if (!doctorLookup.existsById(doctorId)) {
            throw new DoctorNotFoundException("Doctor not found: " + doctorId);
        }


        if (repository.existsOverlappingExcludingId(
                id,
                doctorId,
                timeSlot.start(),
                timeSlot.end()
        )) {
            throw new TimeSlotConflictException("Doctor already booked in this time slot");
        }

        Appointment updated = new Appointment(
                existing.getId(),
                patientId,
                doctorId,
                timeSlot
        );

        return repository.save(updated);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new AppointmentNotFoundException("Appointment not found: " + id);
        }
        repository.deleteById(id);
    }
}