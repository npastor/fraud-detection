package com.transaction.fraud.detection.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * In real system, this will be separate service that exposes an API which will fetch customer information based on customerId. Keeping it
 * very simple to cover basic scenarios.
 */
@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @OneToOne()
    @JoinColumn()
    private MonthlyAggregatedData monthlyAggregatedData;

    @OneToOne()
    @JoinColumn()
    private CurrentMonthData currentMonthData;

    private String billingName;

    // Configurable property set by customer to add a daily spend limit.
    private Double dailySpendLimit;

    // Configurable property set by customer to add a daily transaction frequency limit.
    private Integer dailyAllowedFrequency;
}
