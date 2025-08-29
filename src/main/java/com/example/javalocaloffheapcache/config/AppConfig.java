package com.example.javalocaloffheapcache.config;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.EhcacheCachingProvider;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;

@Configuration
@EnableCaching
public class AppConfig {
    @Bean
    public JCacheCacheManager cacheManager() {
        EhcacheCachingProvider provider = (EhcacheCachingProvider) Caching.getCachingProvider();

        org.ehcache.config.CacheConfiguration<Object, Object> ehcacheConfig =
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        Object.class, Object.class,
                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                                .offheap(100, MemoryUnit.MB)
                ).build();

        org.ehcache.config.Configuration config = ConfigurationBuilder.newConfigurationBuilder()
                .withCache("testcache", ehcacheConfig)
                .build();

        CacheManager cacheManager = provider.getCacheManager(
                provider.getDefaultURI(),
                config
        );

        return new JCacheCacheManager(cacheManager);
    }
}
