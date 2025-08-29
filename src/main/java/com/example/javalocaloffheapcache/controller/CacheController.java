package com.example.javalocaloffheapcache.controller;

import com.example.javalocaloffheapcache.service.CacheService;
import org.ehcache.config.ResourcePools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private CacheService cacheService;

    @GetMapping("/{id}")
    public String getCacheById(@PathVariable("id") String id) {
        return cacheService.getCacheData(id);
    }

    @PutMapping
    public void putInCache(@RequestParam("key") String key, @RequestParam("value") String value) {
        cacheService.putCacheData(key,value);
    }

    @DeleteMapping
    public void deleteInCache(@RequestParam("key") String key) {
         cacheService.evictCacheData(key);
    }

}
