package com.champsoft.healthcaremilestone.modules.patient.domain.model;

import com.champsoft.healthcaremilestone.modules.patient.domain.exception.ExpiredHealthInsuranceCardException;
import com.champsoft.healthcaremilestone.modules.patient.domain.exception.InvalidInsuranceCardNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class HealthInsuranceCard {

    private String healthCardNum;
    private LocalDate expiryDate;

    public HealthInsuranceCard(String card, LocalDate expiryDate) {


        if (card == null || card.isBlank()) {
            throw new InvalidInsuranceCardNumber(
                    "Health insurance card cannot be null or empty"
            );
        }

        // normalize input
        String cleaned = card.replaceAll("\\s+", "").toUpperCase();

        // validate format: XXXX12345678
        if (!cleaned.matches("^[A-Z]{4}\\d{8}$")) {
            throw new InvalidInsuranceCardNumber(
                    "Health insurance card invalid, correct format: BASM 4567 8907"
            );
        }

        // format nicely: XXXX 1234 5678
        String formatted = cleaned.substring(0, 4) + " " +
                cleaned.substring(4, 8) + " " +
                cleaned.substring(8, 12);

        // expiry validation
        if (expiryDate == null) {
            throw new ExpiredHealthInsuranceCardException(
                    "Expiry date cannot be null"
            );
        }

        if (expiryDate.isBefore(LocalDate.now())) {
            throw new ExpiredHealthInsuranceCardException(
                    "Health insurance card is expired"
            );
        }

        this.healthCardNum = formatted;
        this.expiryDate = expiryDate;
    }

    // explicit getter (optional but safe)
    public String insuranceCardNumber() {
        return healthCardNum;
    }
}