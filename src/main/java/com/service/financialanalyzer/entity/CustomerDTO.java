package com.service.financialanalyzer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class CustomerDTO {

    @NotBlank(message = "Customer Name is mandatory")
    private String customerName;

    private Double balance;

    @NotBlank(message = "Nationality is mandatory")
    private String nationality;

    @NotBlank(message = "State is mandatory")
    private String state;

    private String address;

    @Column(name = "govt_id_type") @NotBlank(message = "Govt ID Type is mandatory")
    private String govtIdType;

    @NotBlank(message = "Govt ID is mandatory")
    private String govtId;

    @Past
    private LocalDate dob;

}

