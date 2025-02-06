package com.jasperReport.services.studentServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasperReport.data.models.StudentResult;
import com.jasperReport.data.repositories.ResultRepository;
import com.jasperReport.dtos.requests.StudentResultRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class StudentResultService {
    private final ResultRepository resultRepository;
    private final ObjectMapper objectMapper;
    private final JasperService jasperService;

    public StudentResult saveStudentResult(StudentResultRequest studentResult) throws JsonProcessingException {
        StudentResult studentResultConvert = objectMapper.readValue(objectMapper.writeValueAsString(studentResult), StudentResult.class);
        return resultRepository.save(studentResultConvert);
    }

    public StudentResult getStudentResult(String firstName) {
//        generateReport(firstName);
        return resultRepository.findByFirstName(firstName);
    }

    public List<StudentResult> getAllStudentResult() {
//        generateReport(firstName);
        return resultRepository.findAll();
    }


    public void generateReportForAStudent(String firstName) throws JRException, IOException {
        StudentResult studentResult = getStudentResult(firstName);
        if (studentResult != null) {
            List<StudentResult> studentResults = List.of(studentResult); // Create a list from the single result
            jasperService.getReportStudentContext(firstName, studentResults); // Call the JasperService to generate the report
        } else {
            log.warn("No student result found for first name: {}", firstName);
        }

    }

    public void generateReportAllStudents() throws JRException, IOException {
        List<StudentResult> studentResults = getAllStudentResult();
        if (studentResults != null) {
           jasperService.getReportAllStudentsContext(studentResults);
        } else {
            log.warn("No student result found");
        }

    }
}
