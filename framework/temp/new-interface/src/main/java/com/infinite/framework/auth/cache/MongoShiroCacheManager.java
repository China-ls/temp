package com.infinite.framework.auth.cache;

import com.mongodb.MongoClient;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import java.util.Map;

public class MongoShiroCacheManager implements CacheManager {
    private MongoClient mongo;
    private Map<String, Cache> cacheMap;

    public void setCacheMap(Map<String, Cache> cacheMap) {
        this.cacheMap = cacheMap;
    }

    public Map<String, Cache> getCacheMap() {
        return cacheMap;
    }

    public MongoShiroCacheManager(MongoClient mongo) {
        this.mongo = mongo;
    }

    public Cache getCache(String name) throws CacheException {
        if (null == cacheMap || cacheMap.size() <= 0) {
            return null;
        }
        Cache cache = cacheMap.get(name);
        if (null != cache && cache instanceof ShiroMongoCache) {
            ((ShiroMongoCache) cache).setMongo(mongo);
        }
        return cache;
    }
}
