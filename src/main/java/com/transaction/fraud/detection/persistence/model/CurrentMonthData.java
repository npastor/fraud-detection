package com.transaction.fraud.detection.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * In real system, this will be separate service that exposes an API which provides data for a given customer for the current month.
 */
@Entity
@Data
public class CurrentMonthData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This represents the total amount spent by the customer for current month.
    private Double monthlyAmountSpent;

    // This represents the transaction frequency for the customer in current month.
    private Integer monthlyFrequency;

}
