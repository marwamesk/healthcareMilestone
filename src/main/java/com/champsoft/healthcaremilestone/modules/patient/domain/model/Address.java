package com.champsoft.healthcaremilestone.modules.patient.domain.model;

import com.champsoft.healthcaremilestone.modules.patient.domain.exception.InvalidAddressException;
import lombok.Getter;

@Getter
public class Address {
    private final Integer streetNumber;
    private final String streetName;
    private final String city;
    private final String postalCode;
    private final String Country;

    public Address(Integer streetNumber, String streetName, String city, String postalCode, String country) {
        if(streetNumber == null || streetName.isEmpty() || city.isEmpty() || postalCode.isEmpty() || country.isEmpty())
            throw new InvalidAddressException("The address must be completed, you are missing information");
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        Country = country;
    }


}
