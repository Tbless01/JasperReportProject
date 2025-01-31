package com.jasperReport.services.studentServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasperReport.data.models.StudentData;
import com.jasperReport.data.repositories.StudentDataRepository;
import com.jasperReport.dtos.requests.StudentRequest;
import com.jasperReport.dtos.responses.StudentResponse;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentDataRepository studentDataRepository;
    private final ObjectMapper objectMapper;

    public StudentResponse addStudent(StudentRequest studentRequest) throws JsonProcessingException {
        StudentData studentData = objectMapper.readValue(objectMapper.writeValueAsString(studentRequest), StudentData.class);
        StudentData savedStudentData =studentDataRepository.save(studentData);
        return objectMapper.readValue(objectMapper.writeValueAsString(savedStudentData), StudentResponse.class);
    }

//    public List<StudentResponse> getAllStudents() {
//
//    }

}
