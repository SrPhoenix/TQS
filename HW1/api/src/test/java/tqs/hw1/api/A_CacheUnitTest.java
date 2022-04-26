package tqs.hw1.api;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


import tqs.hw1.api.service.Cache;
import tqs.hw1.api.model.CovidData;


public class A_CacheUnitTest {

    private Cache c = new Cache();

    @Test
    public void saveDataTest(){
        JSONObject json = new JSONObject("{data:\"something\"}");
        CovidData data = new CovidData();
        CovidData data2 = new CovidData();
        data2.setCity_name("Aveiro");
        c.put(data, json);
        
        assertEquals(c.get(data), json);
        assertEquals(c.get(data2), null);        
    }

    @Test
    public void TestTtl5Minutes(){
        try {
            JSONObject json = new JSONObject("{data:\"something2\"}");
            CovidData data3 = new CovidData();
            data3.setCity_name("Porto");
            c.put(data3, json);
            assertEquals(c.get(data3), json);
			Thread.sleep(TimeUnit.MINUTES.toMillis(4));
            assertEquals(c.get(data3), json);
			Thread.sleep(TimeUnit.MINUTES.toMillis(1));
            assertEquals(c.get(data3), null);
		}
        catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
              
    }
    
    
}
