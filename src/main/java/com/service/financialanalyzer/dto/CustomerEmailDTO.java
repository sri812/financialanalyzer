package com.service.financialanalyzer.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEmailDTO {

    @Email
    @NotBlank(message = "Please add at least one valid mail")
    private String email;
}
