package com.company.main.reportGeneratorClient;

import com.company.main.model.ExecutionReport;

public interface ReportGenerator {
    public void sendReport(ExecutionReport executionReport);
}
