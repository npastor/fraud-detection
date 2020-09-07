package com.transaction.fraud.detection.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * In real scenario, this will be separate service that exposes an API which provides aggregated data for a given customer.
 */
@Entity
@Data
public class MonthlyAggregatedData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double avgMonthlySpentAmount;

    private Integer avgMonthlyFrequency;

}
