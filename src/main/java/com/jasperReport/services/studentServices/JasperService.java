package com.jasperReport.services.studentServices;

import com.jasperReport.data.models.StudentResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class JasperService {

//    public void getReportContext(String fileName, List<StudentResult> studentResult) throws JRException {
public void getReportContext(List<StudentResult> studentResult) throws JRException {

        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(studentResult);
        JasperReport report = JasperCompileManager.compileReport(filePath);
        Map<String, Object> parameters = new HashMap<>();
        // You can add any parameters you need here, for example:
         parameters.put("someKey", studentResult.);
        JasperPrint print = JasperFillManager.fillReport(report, jrBeanCollectionDataSource, n);
        JasperExportManager.exportReportToPdfFile(print, "");
        log.info("Report exported");
    }
}
