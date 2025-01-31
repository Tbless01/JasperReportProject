package com.jasperReport.services.studentServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasperReport.data.models.StudentResult;
import com.jasperReport.data.repositories.ResultRepository;
import com.jasperReport.dtos.requests.StudentResultRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class StudentResultService {
    private final ResultRepository resultRepository;
    private final ObjectMapper objectMapper;

    public StudentResult saveStudentResult(StudentResultRequest studentResult) throws JsonProcessingException {
        StudentResult studentResultConvert = objectMapper.readValue(objectMapper.writeValueAsString(studentResult), StudentResult.class);
        return resultRepository.save(studentResultConvert);
    }

    public StudentResult getStudentResult(String firstName) {
        return resultRepository.findByFirstName(firstName);
    }

//    public List<StudentResult> getStudentResults() {
//
//    }

}
