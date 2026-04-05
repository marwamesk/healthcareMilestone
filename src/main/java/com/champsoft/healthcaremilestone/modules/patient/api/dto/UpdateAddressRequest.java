package com.champsoft.healthcaremilestone.modules.patient.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateAddressRequest (
        @NotBlank String id,
        @NotNull Integer streetNumber,
        @NotBlank String streetName,
        @NotBlank String city,
        @NotBlank String postalCode,
        @NotBlank String Country
){
}
