package com.crm.dto;

import com.crm.model.CallList;
import lombok.Data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public @Data class EmailDto {

    @Email
    @NotEmpty
    private String to;

    private String subject;

    private String text;

    private CallList callList;

}
