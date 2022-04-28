package tqs.hw1.api;
import org.json.JSONObject;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import tqs.hw1.api.service.Cache;
import tqs.hw1.api.model.ModelRequest;
import tqs.hw1.api.model.ResponseData;


public class A_CacheUnitTest {

    private Cache c = new Cache();


    @Test
    @Order(0)
    public void saveDataTest(){
        assertEquals(c.getCacheKeySet().size(), 0);

        ResponseData response = new ResponseData();
        response.setIso("PRT");
        ModelRequest data = new ModelRequest();
        ModelRequest data2 = new ModelRequest();
        data2.setCity_name("Aveiro");
        c.put(data, response);
        
        assertEquals( response, c.get(data));
        assertEquals(null, c.get(data2) );     
        assertEquals(1, c.getCacheKeySet().size() );

    }
    @Test
    @Order(1)
    void testDataHasExpired() {
        try {
            ResponseData response = new ResponseData();
            response.setLast_update("Ontem");
            ModelRequest data5 = new ModelRequest();
            data5.setCity_name("canede");
            c.put(data5, response);
            assertFalse(c.hasExpired(data5));
			Thread.sleep(TimeUnit.MINUTES.toMillis(3));
            assertTrue(c.hasExpired(data5));
		}
        catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
    }

    @Test
    @Order(2)
    void testDeleteData() {
        ResponseData response = new ResponseData();
        response.setConfirmed("1000");
        ModelRequest data6 = new ModelRequest();
        data6.setCity_name("espinho");
        c.put(data6, response);
        
        assertEquals(response, c.get(data6));

        c.deleteDataFromCache(data6);
        
        assertEquals(null, c.get(data6));
    }

    @Test
    @Order(3)
    void testScheduleCleaningCache() {
        ModelRequest data3 = new ModelRequest();
        data3.setCity_name("Ovar");
        ResponseData response = new ResponseData();
        response.setDeaths("10000");
        c.put(data3, response);
        c.cleanExpiredCachedData();
        Set<ModelRequest> keys= c.getCacheKeySet();
        assertEquals(1, keys.size());
        assertEquals(data3, (ModelRequest)keys.toArray()[0]);

    }

    @Test
    @Order(4)
    public void TestGetNonExpiredData(){
        try {
            ResponseData response = new ResponseData();
            response.setName("Porto");
            ModelRequest data4 = new ModelRequest();
            data4.setCity_name("Porto");
            c.put(data4, response);
			Thread.sleep(TimeUnit.MINUTES.toMillis(2));
            assertEquals(response, c.get(data4));
		}
        catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
              
    }





    
    
}
