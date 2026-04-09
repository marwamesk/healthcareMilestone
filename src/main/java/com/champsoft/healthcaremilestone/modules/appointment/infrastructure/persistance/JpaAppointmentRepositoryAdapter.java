package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance;

import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.AppointmentRepositoryPort;
import com.champsoft.healthcaremilestone.modules.appointment.domain.model.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaAppointmentRepositoryAdapter implements AppointmentRepositoryPort {

    private final SpringDataAppointmentRepository repo;

    public JpaAppointmentRepositoryAdapter(SpringDataAppointmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Appointment save(Appointment appointment) {
        AppointmentJpaEntity entity = toEntity(appointment);
        return toDomain(repo.save(entity));
    }

    @Override
    public Optional<Appointment> findById(UUID id) {
        return repo.findById(id).map(this::toDomain);
    }

    @Override
    public List<Appointment> findAll() {
        return repo.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return repo.existsById(id);
    }

    @Override
    public boolean existsOverlapping(UUID doctorId, LocalDateTime start, LocalDateTime end) {
        return repo.existsOverlapping(doctorId, start, end);
    }

    @Override
    public boolean existsOverlappingExcludingId(UUID id, UUID doctorId, LocalDateTime start, LocalDateTime end) {
        return repo.existsOverlappingExcludingId(id, doctorId, start, end);
    }

    // 🔁 DOMAIN → ENTITY
    private AppointmentJpaEntity toEntity(Appointment a) {
        AppointmentJpaEntity e = new AppointmentJpaEntity();

        e.setId(a.getId().value());
        e.setPatientId(a.getPatientId());
        e.setDoctorId(a.getDoctorId());
        e.setStartTime(a.getTimeSlot().start());
        e.setEndTime(a.getTimeSlot().end());
        e.setStatus(a.getStatus().name());

        return e;
    }

    // 🔁 ENTITY → DOMAIN
    private Appointment toDomain(AppointmentJpaEntity e) {
        Appointment a = new Appointment(
                new AppointmentId(e.getId()),
                e.getPatientId(),
                e.getDoctorId(),
                new TimeSlot(e.getStartTime(), e.getEndTime())
        );

        // restore status
        if (e.getStatus() != null) {
            if (e.getStatus().equals("CANCELLED")) {
                a.cancel();
            }
        }

        return a;
    }
}