package com.ayush.rediscaching.controller;

import com.ayush.rediscaching.dto.ReportData;
import com.ayush.rediscaching.dto.ReportRequest;
import com.ayush.rediscaching.service.ReportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping("/report-data")
    public List<ReportData> fetchReportData(@RequestBody ReportRequest reportRequest) throws InterruptedException, JsonProcessingException {
        return reportService.getReportDataList(reportRequest);
    }
}
