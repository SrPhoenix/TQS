package tqs.hw1.api.service;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import tqs.hw1.api.model.CovidData;

@Component
public class Cache {
    private HashMap<CovidData, JSONObject> cache = new HashMap<>();
    private HashMap<CovidData, Timestamp> ttl = new HashMap<>();
    private static Logger logger = LogManager.getLogger(Cache.class);
    
    
    public JSONObject get(CovidData data){
        if(ttl.containsKey(data))  {
            logger.debug("data on cache");
            if((Timestamp.from(Instant.now()).getTime()-ttl.get(data).getTime()) < 300000){
                logger.debug("Retrieving data");
                return cache.get(data);
            }
            else   
                cache.remove(data);
                logger.debug("Discarting data due TTL policy");
        }
        return null;
    }
    public void put(CovidData data, JSONObject response){
        logger.debug("Caching up data");
        cache.put(data,response);
        ttl.put(data, Timestamp.from(Instant.now()));
    }
}
