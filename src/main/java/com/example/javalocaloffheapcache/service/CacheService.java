package com.example.javalocaloffheapcache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class CacheService {

    private Map<String, String> caches = Map.of(
            "key1", "Data1",
            "key2", "Data2",
            "key3", "Data3",
            "key4", "Data4"
    );

    @Cacheable(value = "cacheDetails", key = "#key")
    public String getCacheData(String key) {
        return caches.get(key);
    }

    @CachePut(value = "cacheDetails", cacheNames = "cacheValue", key = "#key")
    public void putCacheData(String key, String cacheValue) {
        //caches.put(key, cacheValue);
    }

    @CacheEvict(key = "#key", allEntries = true, value = "cacheDetails")
    public void evictCacheData(String key) {
        //caches.remove(key);
    }
}
