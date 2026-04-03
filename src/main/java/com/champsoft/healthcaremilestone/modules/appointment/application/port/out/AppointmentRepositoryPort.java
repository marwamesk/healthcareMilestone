package com.champsoft.healthcaremilestone.modules.appointment.application.port.out;


import com.champsoft.healthcaremilestone.modules.appointment.domain.model.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepositoryPort {

    Appointment save(Appointment appointment);

    Optional<Appointment> findById(UUID id);

    List<Appointment> findAll();

    void deleteById(UUID id);
}