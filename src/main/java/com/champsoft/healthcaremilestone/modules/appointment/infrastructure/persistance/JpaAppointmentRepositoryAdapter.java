package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance;

import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.AppointmentRepositoryPort;
import com.champsoft.healthcaremilestone.modules.appointment.domain.model.*;
import com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance.AppointmentJpaEntity;
import com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance.SpringDataAppointmentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaAppointmentRepositoryAdapter implements AppointmentRepositoryPort {

    private final SpringDataAppointmentRepository repo;

    public JpaAppointmentRepositoryAdapter(SpringDataAppointmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Appointment save(Appointment appt) {
        AppointmentJpaEntity e = new AppointmentJpaEntity();
        e.setId(appt.id().value());
        e.setDoctorId(appt.doctorIdValue());
        e.setPatientId(appt.patientIdValue());
        e.setStatus(appt.status());
        e.setTime(appt.timeValue());
        repo.save(e);
        return appt;
    }

    @Override
    public Optional<Appointment> findById(String id) {
        return repo.findById(id).map(e ->
                new Appointment(
                        new AppointmentId(e.getId()),
                        new DoctorRef(e.getDoctorId()),
                        new PatientRef(e.getPatientId()),
                        new AppointmentTime(e.getTime())
                )
        );
    }

    @Override
    public List<Appointment> findAll() {
        return repo.findAll().stream().map(e ->
                new Appointment(
                        new AppointmentId(e.getId()),
                        new DoctorRef(e.getDoctorId()),
                        new PatientRef(e.getPatientId()),
                        new AppointmentTime(e.getTime())
                )
        ).toList();
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }
}