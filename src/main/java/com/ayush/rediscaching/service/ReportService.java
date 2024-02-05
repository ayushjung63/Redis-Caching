package com.ayush.rediscaching.service;

import com.ayush.rediscaching.dto.ReportData;
import com.ayush.rediscaching.dto.ReportRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ReportService {
    List<ReportData> getReportDataList(ReportRequest reportRequest) throws InterruptedException, JsonProcessingException;
}
