package com.champsoft.healthcaremilestone.modules.appointment.application.service;




import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.AppointmentRepositoryPort;
import com.champsoft.healthcaremilestone.modules.appointment.domain.model.AppointmentId;
import com.champsoft.healthcaremilestone.modules.appointment.domain.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class AppointmentCrudService {

    private final AppointmentRepositoryPort repository;

    public AppointmentCrudService(AppointmentRepositoryPort repository) {
        this.repository = repository;
    }

    public Appointment create(UUID patientId, UUID doctorId, TimeSlot timeSlot) {

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