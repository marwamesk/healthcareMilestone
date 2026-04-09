package com.champsoft.healthcaremilestone.modules.doctor.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<DoctorJpaEntity, UUID> {
}