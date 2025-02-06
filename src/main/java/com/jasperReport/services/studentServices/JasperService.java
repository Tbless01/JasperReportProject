package com.jasperReport.services.studentServices;

import com.jasperReport.data.models.StudentResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class JasperService {

//    public void getReportStudentContext(List<StudentResult> studentResults) throws JRException, IOException {
public void getReportStudentContext(String name, List<StudentResult> studentResults) throws JRException, IOException {
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(studentResults);

        ClassPathResource resource = new ClassPathResource("StudentResult.jrxml");
        log.info("Attempting to load file from classpath: {}", resource.getPath());

        try (InputStream inputStream = resource.getInputStream()) {
            JasperReport report = JasperCompileManager.compileReport(inputStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("studentMarks", name);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, jrBeanCollectionDataSource);

            String userHome = System.getProperty("user.home");
            String documentsPath = userHome + File.separator + "Documents";
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportFileName = "school_report_" + timestamp + ".pdf";
            String fullPath = documentsPath + File.separator + reportFileName;

            try {
                JasperExportManager.exportReportToPdfFile(print, fullPath);
                log.info("Report exported successfully to: {}", fullPath);
            } catch (Exception e) {
                log.error("Error exporting report: {}", e.getMessage());
                throw e;
            }
        } catch (Exception e) {
            log.error("Error generating report: {}", e.getMessage());
            throw e;
        }
    }

    public void getReportAllStudentsContext(List<StudentResult> studentResults) throws JRException, IOException {
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(studentResults);

        ClassPathResource resource = new ClassPathResource("StudentResult.jrxml");
        log.info("Attempting to load file from classpath: {}", resource.getPath());

        try (InputStream inputStream = resource.getInputStream()) {
            JasperReport report = JasperCompileManager.compileReport(inputStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("studentMarks", "Scores");
            JasperPrint print = JasperFillManager.fillReport(report, parameters, jrBeanCollectionDataSource);

            String userHome = System.getProperty("user.home");
            String documentsPath = userHome + File.separator + "Documents";
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportFileName = "school_report_" + timestamp + ".pdf";
            String fullPath = documentsPath + File.separator + reportFileName;

            try {
                JasperExportManager.exportReportToPdfFile(print, fullPath);
                log.info("Report exported successfully to: {}", fullPath);
            } catch (Exception e) {
                log.error("Error exporting report: {}", e.getMessage());
                throw e;
            }
        } catch (Exception e) {
            log.error("Error generating report: {}", e.getMessage());
            throw e;
        }
    }

    }

