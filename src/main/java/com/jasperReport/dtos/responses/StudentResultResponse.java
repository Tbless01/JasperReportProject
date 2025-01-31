package com.jasperReport.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StudentResultResponse {
    private String name;

    private int maths;

    private int english;

    private int socialStudies;

    private int basicScience;
}
