package com.ayush.rediscaching.service;

import com.ayush.rediscaching.dto.ReportData;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CacheService {
    void cacheReportData(String redisKey, String responseString) throws JsonProcessingException;
    String getReportDataFromCache(String redisKey) throws JsonProcessingException;
}
