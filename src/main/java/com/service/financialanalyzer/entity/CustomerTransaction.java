package com.service.financialanalyzer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_transactions")
@Getter
@Setter
@ToString
public class CustomerTransaction {

    @Id
    private Integer transactionId;
    private Integer customerId;
    private Integer amount;
    private Long transactionDesc;
    private String paymentType;
    private String transactionTimestamp;



}
