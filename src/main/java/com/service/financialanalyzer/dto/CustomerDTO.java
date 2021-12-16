package com.service.financialanalyzer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    @NotBlank(message = "Customer Name is mandatory")
    private String customerName;

    private Long mobileNumber;

    private Double balance;

    @NotBlank(message = "Nationality is mandatory")
    private String nationality;

    @NotBlank(message = "State is mandatory")
    private String state;

    private String address;

    @Column(name = "govt_id_type") @NotBlank(message = "Govt ID Type is mandatory")
    private String govtIdType;

    @Column(unique = true) @NotBlank(message = "Govt ID is mandatory")
    private String govtId;

    @Past
    private LocalDate dob;

    private Set<@Valid CustomerEmailDTO> emails;


}

