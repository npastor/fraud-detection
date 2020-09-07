package com.transaction.fraud.detection.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.transaction.fraud.detection.service.DailyTransactionDataCache;

@Service
public class DailyTransactionDataCacheImpl implements DailyTransactionDataCache {
    public static Map<Long, Double> customerDailySpendLimitExhausted = new HashMap<>();
    public static Map<Long, Integer> customerDailyFrequencyLimitExhausted = new HashMap<>();

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
        return customerDailySpendLimitExhausted.containsKey(key) ? customerDailySpendLimitExhausted.get(key) : null;
    }

    @Override
    public Integer getFreqLimitExhausted(Long key) {
        return customerDailyFrequencyLimitExhausted.containsKey(key) ? customerDailyFrequencyLimitExhausted.get(key) : null;
    }
}