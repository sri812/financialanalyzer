package com.service.financialanalyzer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "customer_transactions")
@Getter
@Setter
@ToString
public class CustomerTransaction {

    @Id
    private Integer transactionId;

//    @ManyToOne
//    @JoinColumn(name = "customerID", nullable = false)
//    private Customer customer;

    private Integer amount;

    private Long transactionDesc;

    private String paymentType;

    private String transactionTimestamp;

}
