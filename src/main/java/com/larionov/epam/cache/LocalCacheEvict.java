package com.larionov.epam.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class LocalCacheEvict {
    @CacheEvict(cacheNames = "listProducts",allEntries = true)
    public void evictAllProducts() {
    }

    @CacheEvict(cacheNames = "product",allEntries = true)
    public void evictUserCache() {
    }
}
