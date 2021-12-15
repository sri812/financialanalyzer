package com.service.financialanalyzer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {

    @Id
    @JsonIgnore
    @GeneratedValue
    private Long customerId;

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

    @NotBlank(message = "Govt ID is mandatory")
    private String govtId;

    @Past
    private LocalDate dob;


}
