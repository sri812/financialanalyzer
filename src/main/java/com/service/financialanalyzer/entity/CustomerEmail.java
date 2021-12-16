package com.service.financialanalyzer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_email")
public class CustomerEmail {

    @Id
    @GeneratedValue
    private Long id;

    @Email @NotBlank(message = "Please add at least one valid mail")
    private String email;
}
