package com.transaction.fraud.detection.service;

/**
 * In a real system, this could be cache shared by all services. This cache would record all daily transactions made per customer. It will
 * be invalidated in 24 hrs.
 */
public interface DailyTransactionDataCache {

    public Double getSpendLimitExhausted(Long key);

    public Integer getFreqLimitExhausted(Long key);

}
