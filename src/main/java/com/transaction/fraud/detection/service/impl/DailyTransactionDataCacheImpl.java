package com.transaction.fraud.detection.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.transaction.fraud.detection.service.DailyTransactionDataCache;

/**
 * In a real system, this could be cache shared by all services. This cache would record all daily transactions made per customer. It will
 * be invalidated in 24 hrs.
 */
@Service
public class DailyTransactionDataCacheImpl implements DailyTransactionDataCache {
    public static Map<Long, Double> customerDailySpendLimitExhausted = new HashMap<>();
    public static Map<Long, Integer> customerDailyFrequencyLimitExhausted = new HashMap<>();
    /** This is hardcoded for assignment sake, but in real application this would be updated by transaction service
    * after every succesful transaction.
    */
    static {
        customerDailySpendLimitExhausted.put(1L, 100.0);
        customerDailySpendLimitExhausted.put(2L, 200.0);
        customerDailySpendLimitExhausted.put(3L, 300.0);
        customerDailySpendLimitExhausted.put(4L, 100.0);

        customerDailyFrequencyLimitExhausted.put(1L, 5);
        customerDailyFrequencyLimitExhausted.put(2L, 1);
        customerDailyFrequencyLimitExhausted.put(3L, 2);
        customerDailyFrequencyLimitExhausted.put(4L, 3);
    }

    @Override
    public Double getSpendLimitExhausted(Long key) {
        return customerDailySpendLimitExhausted.get(key);
    }

    @Override
    public Integer getFreqLimitExhausted(Long key) {
        return customerDailyFrequencyLimitExhausted.get(key);
    }
}
