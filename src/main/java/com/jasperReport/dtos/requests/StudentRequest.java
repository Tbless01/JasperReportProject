package com.jasperReport.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentRequest {
    private String firstName;

    private String lastName;

    private String middleName;

    private String parentEmail;

    private String parentPhone;

    private String fullAddress;
}