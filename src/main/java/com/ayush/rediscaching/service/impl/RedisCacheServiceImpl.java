package com.ayush.rediscaching.service.impl;

import com.ayush.rediscaching.dto.ReportData;
import com.ayush.rediscaching.service.CacheService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisCacheServiceImpl implements CacheService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public void cacheReportData(String redisKey, String responseString) {
        redisTemplate.opsForValue().set(redisKey,responseString);
    }

    @Override
    public String getReportDataFromCache(String redisKey)  {
        String responseString = redisTemplate.opsForValue().get(redisKey);
        if (responseString==null) return null;
        return responseString;
    }
}
