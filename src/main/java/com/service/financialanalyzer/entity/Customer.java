package com.service.financialanalyzer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.Valid;
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
    @GeneratedValue
    private Long customerId;

    @NotBlank(message = "Customer Name is mandatory")
    private String customerName;

    @Digits(integer = 10, message = "Mobile Number must have 10 digits", fraction = 0)
    private Long mobileNumber;

    @PositiveOrZero(message = "Opening balance cannot be negative")
    private Double balance;

    @NotBlank(message = "Nationality is mandatory")
    private String nationality;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @Column(name = "govt_id_type") @NotBlank(message = "Govt ID Type is mandatory")
    private String govtIdType;

    @Column(unique = true) @NotBlank(message = "Govt ID is mandatory")
    private String govtId;

    @Past
    private LocalDate dob;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid", referencedColumnName = "customerId")
    private Set<@Valid CustomerEmail> emails;


}
