package com.jasperReport.services.studentServices;

import com.jasperReport.data.models.StudentResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JasperService {

    public void getReportContext(String fileName, StudentResult studentResult) throws JRException {

        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(studentResult);
        JasperReport report = JasperCompileManager.compileReport(fileName);
        JasperPrint print = JasperFillManager.fillReport(report, jrBeanCollectionDataSource, n);
        JasperExportManager.exportReportToPdfFile(print, "");
        log.info("Report exported");
    }
}
