package com.company.main.reportGeneratorClient.internal;

import com.company.main.model.ExecutionReport;
import com.company.main.reportGeneratorClient.ReportGenerator;

public class ConsoleReportGenerator implements ReportGenerator {

    @Override
    public void sendReport(ExecutionReport executionReport) {
        System.out.println(executionReport.toString());
    }
}
