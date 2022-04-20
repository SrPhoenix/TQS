package tqs.hw1.api;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class Cache {
    HashMap<CovidData, JSONObject> cache = new HashMap<>();
    HashMap<CovidData, Timestamp> ttl = new HashMap<>();
    

    public JSONObject get(CovidData data){
        if(ttl.containsKey(data))  {
            if((Timestamp.from(Instant.now()).getTime()-ttl.get(data).getTime()) < 300000)
                return cache.get(data);
            else   
                cache.remove(data);
        }
        return null;
    }
    public void put(CovidData data, JSONObject response){
        cache.put(data,response);
        ttl.put(data, Timestamp.from(Instant.now()));
    }
}
