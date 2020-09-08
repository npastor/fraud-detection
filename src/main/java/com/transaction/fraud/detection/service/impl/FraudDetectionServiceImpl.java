package com.transaction.fraud.detection.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.fraud.detection.dto.TransactionDto;
import com.transaction.fraud.detection.dto.ValidationErrorDto;
import com.transaction.fraud.detection.persistence.model.CurrentMonthData;
import com.transaction.fraud.detection.persistence.model.Customer;
import com.transaction.fraud.detection.persistence.model.MonthlyAggregatedData;
import com.transaction.fraud.detection.persistence.repository.CustomerRepository;
import com.transaction.fraud.detection.service.DailyTransactionDataCache;
import com.transaction.fraud.detection.service.FraudDetectionService;

/**
 * In real system, this would be part of rules engine, which based on provided data, will either give out a risk score or would provide
 * information about failed rules and risk level associated with it.
 */
@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private DailyTransactionDataCache dailyTransactionDataCache;

    @Override
    public List<ValidationErrorDto> checkForFraud(TransactionDto transaction) {

        List<ValidationErrorDto> validations = new ArrayList<>();

        Customer customer = customerRepo.findById(transaction.getCustomerId()).orElse(null);

        if (customer == null) {
            return validations; // TODO throw bad request exception
        }

        // Check for billing name
        if (!transaction.getBillingName().equalsIgnoreCase(customer.getBillingName())) {
            validations.add(ValidationErrorDto.builder()
                                              .field("billingName")
                                              .message("Billing Name does not match with registered customer name.")
                                              .build());
        }

        MonthlyAggregatedData monthlyAggregatedData = customer.getMonthlyAggregatedData();
        CurrentMonthData currentMonthData = customer.getCurrentMonthData();

        // Check if this transaction would take current month's total to above aggregated amount spent by this customer monthly
        if (Double.compare(Double.sum(transaction.getAmount(), currentMonthData.getMonthlyAmountSpent()),
                           monthlyAggregatedData.getAvgMonthlySpentAmount()) > 0) {
            validations.add(ValidationErrorDto.builder()
                                              .field("amount")
                                              .message("This transaction will result in amount spent in current month by customer to exceed the average amount spent by this customer monthly.")
                                              .build());
        }

        // Check against monthly transaction frequency of the user.
        if (Double.compare(currentMonthData.getMonthlyFrequency(),
                           monthlyAggregatedData.getAvgMonthlyFrequency()) >= 0) {
            validations.add(ValidationErrorDto.builder()
                                              .field("frequency")
                                              .message("Monthly transaction frequency crossed.")
                                              .build());
        }

        Double spendLimitExhausted = dailyTransactionDataCache.getSpendLimitExhausted(customer.getCustomerId());

        // Check whether daily spend limit of customer will be exhausted by this transaction
        if (Double.compare(Double.sum(spendLimitExhausted, transaction.getAmount()),
                           customer.getDailySpendLimit()) > 0) {
            validations.add(ValidationErrorDto.builder()
                                              .field("amount")
                                              .message("Daily transaction amount spend limit crossed.")
                                              .build());
        }
        Integer freqLimitExhausted = dailyTransactionDataCache.getFreqLimitExhausted(customer.getCustomerId());

        // Check whether daily frequency limit of customer will be exhausted by this transaction
        if ((freqLimitExhausted + 1) > customer.getDailyAllowedFrequency()) {
            validations.add(ValidationErrorDto.builder()
                                              .field("frequency")
                                              .message("Daily transaction frequency limit crossed.")
                                              .build());
        }

        return validations;
    }

}
