package com.transaction.fraud.detection.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.fraud.detection.persistence.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
