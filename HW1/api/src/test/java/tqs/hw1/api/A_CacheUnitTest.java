package tqs.hw1.api;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;

public class A_CacheUnitTest {

    Cache c = new Cache();

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
