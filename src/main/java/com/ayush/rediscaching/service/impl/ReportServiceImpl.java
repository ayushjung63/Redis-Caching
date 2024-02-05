package com.ayush.rediscaching.service.impl;

import com.ayush.rediscaching.dto.ReportData;
import com.ayush.rediscaching.dto.ReportRequest;
import com.ayush.rediscaching.service.CacheService;
import com.ayush.rediscaching.service.ReportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    Logger log=LoggerFactory.getLogger(ReportService.class);

    @Autowired
    private CacheService cacheService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<ReportData> getReportDataList(ReportRequest reportRequest) throws InterruptedException, JsonProcessingException {
        log.info("Request Body {}",reportRequest.toString());
        String redisKey=reportRequest.getId()+"_"+reportRequest.getFromDate()+"_"+reportRequest.getToDate();
        String cachedData = cacheService.getReportDataFromCache(redisKey);
        if (cachedData!=null){
            log.info("---------Cache Hit-----------");
            return objectMapper.readValue(cachedData, new TypeReference<List<ReportData>>() {});
        }
        // expensive method call that takes 10s
        List<ReportData> responseList = findReportDataList(reportRequest);
        return responseList;
    }

    private List<ReportData> findReportDataList(ReportRequest reportRequest) throws InterruptedException, JsonProcessingException {
        log.info("-----------Cache Miss----------");
        Thread.sleep(10000);
        String redisKey=reportRequest.getId()+"_"+reportRequest.getFromDate()+"_"+reportRequest.getToDate();
        List<ReportData> reportDataList = Arrays.asList(
                new ReportData(1, "Report Data 1", reportRequest.getFromDate(), reportRequest.getToDate()),
                new ReportData(2, "Report Data 2", reportRequest.getFromDate(), reportRequest.getToDate())
        );
        cacheService.cacheReportData(redisKey,objectMapper.writeValueAsString(reportDataList));
        return reportDataList;
    }
}
