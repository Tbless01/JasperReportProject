package com.jasperReport.controllers.studentControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jasperReport.data.models.StudentResult;
import com.jasperReport.dtos.requests.StudentResultRequest;
import com.jasperReport.services.studentServices.StudentResultService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/jasper/v1/api")
@RequiredArgsConstructor
public class StudentResultController {

    private final StudentResultService studentResultService;

    @PostMapping("")
    public ResponseEntity<StudentResult> addStudentResult(@RequestBody StudentResultRequest studentResultRequest) throws JsonProcessingException {
        StudentResult studentResult = studentResultService.saveStudentResult(studentResultRequest);
        return new ResponseEntity<>(studentResult, CREATED);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<StudentResult> getUserDetailsByEmailOrNo(
            @PathVariable String firstName
    ) throws JRException, IOException {
        studentResultService.generateReportForAStudent(firstName);
        StudentResult studentResult = studentResultService.getStudentResult(firstName);
        return new ResponseEntity<>(studentResult, OK);
    }
    @GetMapping("/all")
    public ResponseEntity<String> getAllStudents() throws JRException, IOException {
        studentResultService.generateReportAllStudents();
        return new ResponseEntity<>("List of Students result generated successfully", OK);
    }

}
