//package com.champsoft.healthcaremilestone.modules.appointment.infrastructure.persistance;
//
//
//
//import com.champsoft.healthcaremilestone.modules.appointment.application.port.out.AppointmentRepositoryPort;
//import com.champsoft.healthcaremilestone.modules.appointment.domain.model.*;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Repository
//public class JpaAppointmentRepositoryAdapter implements AppointmentRepositoryPort {
//
//    private final SpringDataAppointmentRepository repo;
//
//    public JpaAppointmentRepositoryAdapter(SpringDataAppointmentRepository repo) {
//        this.repo = repo;
//    }
//
//    @Override
//    public Appointment save(Appointment appointment) {
//        AppointmentJpaEntity entity = toEntity(appointment);
//        return toDomain(repo.save(entity));
//    }
//
//    @Override
//    public Optional<Appointment> findById(UUID id) {
//        return repo.findById(id).map(this::toDomain);
//    }
//
//    @Override
//    public List<Appointment> findAll() {
//        return repo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteById(UUID id) {
//        repo.deleteById(id);
//    }
//
//    private AppointmentJpaEntity toEntity(Appointment a) {
//        AppointmentJpaEntity e = new AppointmentJpaEntity();
////        e.setId(a.getId().value());
////        e.setPatientId(a.getPatientId());
////        e.setDoctorId(a.getDoctorId());
////        e.setStartTime(a.getTimeSlot().getStart());
////        e.setEndTime(a.getTimeSlot().getEnd());
////        e.setStatus(a.getStatus().name());
//        return e;
//    }
//
//    private Appointment toDomain(AppointmentJpaEntity e) {
//        return new Appointment(
//                new AppointmentId(e.getId()),
//                e.getPatientId(),
//                e.getDoctorId(),
//                new TimeSlot(e.getStartTime(), e.getEndTime())
//        );
//    }
//}