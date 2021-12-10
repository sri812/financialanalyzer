package com.service.financialanalyzer.entity;

public interface TransactionAggregationDTO {
    String getTransactionMonth();
    Double getTotalIncoming();
    Double getTotalOutgoing();
    Double getClosingBalance();
    Integer getCustomerNumber();
}
