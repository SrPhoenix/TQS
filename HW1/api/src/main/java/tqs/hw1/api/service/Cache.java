package tqs.hw1.api.service;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tqs.hw1.api.model.ModelRequest;
import tqs.hw1.api.model.ResponseDataArray;

@Component
public class Cache {
    private HashMap<ModelRequest, ResponseDataArray> cache = new HashMap<>();
    private HashMap<ModelRequest, Timestamp> ttl = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(Cache.class);
    private int miss;
    private int hit;
    
    private int timeToLive; // in seconds

    public Cache(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public Cache() {
        this.timeToLive = 180;
    }

    
    public ResponseDataArray get(ModelRequest data){
        logger.info("Checking if data {} in cache",data);
        if(ttl.containsKey(data))  {
            logger.info("data is in cache");
            return cache.get(data);
        }
        logger.info("data is not in cache");

        return null;
    }
    public void put(ModelRequest data, ResponseDataArray response){
        logger.info("Caching up data {} with the response {}",data,response.toString());
        cache.put(data,response);
        ttl.put(data, Timestamp.from(Instant.now()));
    }

    public void deleteDataFromCache(ModelRequest data) {
        logger.info("Deleting data {} from cache", data);
        cache.remove(data);
        ttl.remove(data);
    }

    public boolean hasExpired(ModelRequest data) {
        logger.info("Checking if data {} is expired", data);
        Date mostRecentExpiredDate = new Date(System.currentTimeMillis() - this.timeToLive * 1000);
        return ttl.get(data).before(mostRecentExpiredDate);
    }

    @Scheduled(fixedRate = 60 * 1000)
    public void cleanExpiredCachedData() {
        logger.info("Running scheduled method to clean expired cached data");

        for (ModelRequest data : cache.keySet()) {
            logger.info("Deleting expired data: {}", data);
            if (hasExpired(data))
                deleteDataFromCache(data);
        }

    }

    public Set<ModelRequest> getCacheKeySet(){
        return cache.keySet();
    }

    public void plusMiss(){
        miss++;
        logger.info("Number of missing requests: {}", miss);
    }

    public void plusHit(){
        hit++;
        logger.info("Number of hit requests: {}", hit);

    }

    public int getHit(){
        return hit;
    }

    public int getMiss(){
        return miss;
    }
    public int getCountOfRequest(){
        return hit+miss;
    }
}
