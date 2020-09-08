package com.transaction.fraud.detection.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * In real scenario, this will be a separate service that exposes an API which provides aggregated data for a given customer.
 */
@Entity
@Data
public class MonthlyAggregatedData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Average amount spent my customer monthly.
    private Double avgMonthlySpentAmount;

    // Average frequency of transactions made by customer monthly.
    private Integer avgMonthlyFrequency;

}
