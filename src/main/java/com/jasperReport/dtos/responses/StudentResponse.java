package com.jasperReport.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String parentEmail;

    private String parentPhone;

    private String fullAddress;
}
