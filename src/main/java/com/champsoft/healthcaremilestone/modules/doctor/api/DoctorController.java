package com.champsoft.healthcaremilestone.modules.doctor.api;

import com.champsoft.healthcaremilestone.modules.doctor.api.dto.*;
import com.champsoft.healthcaremilestone.modules.doctor.api.mapper.DoctorDtoMapper;
import com.champsoft.healthcaremilestone.modules.doctor.application.service.DoctorCrudService;
import com.champsoft.healthcaremilestone.modules.doctor.domain.model.Doctor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorCrudService service;

    public DoctorController(DoctorCrudService service) {
        this.service = service;
    }

    @PostMapping
    public DoctorResponse create(@RequestBody CreateDoctorRequest request) {
        Doctor doctor = DoctorDtoMapper.toDomain(request);
        return DoctorDtoMapper.toResponse(service.create(doctor));
    }

    @GetMapping
    public List<DoctorResponse> getAll() {
        return service.getAll()
                .stream()
                .map(DoctorDtoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DoctorResponse getById(@PathVariable UUID id) {
        return DoctorDtoMapper.toResponse(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}