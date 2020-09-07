package com.transaction.fraud.detection.service;

import java.util.List;

import com.transaction.fraud.detection.dto.TransactionDto;
import com.transaction.fraud.detection.dto.ValidationErrorDto;

public interface FraudDetectionService {

    public List<ValidationErrorDto> checkForFraud(TransactionDto transaction);

}
