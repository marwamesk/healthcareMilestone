package com.champsoft.healthcaremilestone.modules.patient.domain.model;

import com.champsoft.healthcaremilestone.modules.patient.domain.exception.ExpiredHealthInsuranceCardException;
import com.champsoft.healthcaremilestone.modules.patient.domain.exception.InvalidInsuranceCardNumber;
import lombok.Getter;


import java.time.LocalDate;

public class Health_insuranceCard {
    private final String healthCardNum;
    @Getter
    private final LocalDate expiryDate;


    public Health_insuranceCard(String card, LocalDate expiryDate){
        if(card == null || !card.matches("[A-Za-z]{4}\\d{8}"))
            throw new InvalidInsuranceCardNumber("Health insurance card invalid, wrong format\n correct format: BASM 4567 8907");
        String healthCard = card.trim().toUpperCase();


        LocalDate today= LocalDate.now();
        if(expiryDate.isBefore(today))
            throw new ExpiredHealthInsuranceCardException("Health insurance card invalid(reason: it is expired)");

        this.healthCardNum=healthCard;
        this.expiryDate=expiryDate;
    }


    public String insuranceCardNumber(){
        return healthCardNum;
    }



}
