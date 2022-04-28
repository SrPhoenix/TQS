package tqs.hw1.api.service;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import tqs.hw1.api.model.CovidData;

@Component
public class Cache {
    private HashMap<CovidData, JSONObject> cache = new HashMap<>();
    private HashMap<CovidData, Timestamp> ttl = new HashMap<>();
    private static Logger logger = LogManager.getLogger(Cache.class);
    private int miss;
    private int hit;
    
    private int timeToLive; // in seconds

    public Cache(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public Cache() {
        this.timeToLive = 120;
    }

    
    public JSONObject get(CovidData data){
        logger.info("Checking if data {} in cache",data);
        if(ttl.containsKey(data))  {
            logger.info("data is in cache");
            return cache.get(data);
        }
        logger.info("data is not in cache");

        return null;
    }
    public void put(CovidData data, JSONObject response){
        logger.info("Caching up data {} with the response {}",data,response.toString());
        cache.put(data,response);
        ttl.put(data, Timestamp.from(Instant.now()));
    }

    private void deleteDataFromCache(CovidData data) {
        logger.info("Deleting data {} from cache", data);
        cache.remove(data);
        ttl.remove(data);
    }

    private boolean hasExpired(CovidData data) {
        logger.info("Checking if data {} is expired", data);
        Date mostRecentExpiredDate = new Date(System.currentTimeMillis() - this.timeToLive * 1000);
        return ttl.get(data).before(mostRecentExpiredDate);
    }

    @Scheduled(fixedRate = 60 * 1000)
    private void cleanExpiredCachedData() {
        logger.info("Running scheduled method to clean expired cached data");

        for (CovidData data : cache.keySet()) {
            logger.info("Deleting expired data: {}", data);
            if (hasExpired(data))
                deleteDataFromCache(data);
        }

    }

    public void plusMiss(){
        miss++;
    }

    public void plusHit(){
        hit++;
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
