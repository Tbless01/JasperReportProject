package com.jasperReport.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StudentResultRequest {
    private String firstName;

    private int maths;

    private int english;

    private int socialStudies;

    private int basicScience;
}
