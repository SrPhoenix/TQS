package tqs.hw1.api;
import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class Cache {
    HashMap<CovidData, JSONObject> cache = new HashMap<>();
    

    public JSONObject get(CovidData data){
        return null;

    }
}
