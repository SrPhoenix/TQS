package tqs.hw1.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import tqs.hw1.api.service.Cache;
import tqs.hw1.api.service.CovidService;
import tqs.hw1.api.model.CovidData;

@ExtendWith(MockitoExtension.class)
public class B_ServiceUnitTest {
    
    @Mock
    Cache c;

    @InjectMocks
    CovidService service;


    @Test
    void getDataFromCacheTest() throws IOException {
        CovidData data = new CovidData();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject("{\"data\":\"somedata\",\"more\":\"data\"}");
        }catch (JSONException err){
            System.err.println("Error: "+ err.toString());
        }
        data.setCity_name("Aveiro");
        assertNotEquals(c, null);
        Mockito.when(c.get(data)).thenReturn(jsonObject);

        assertNotEquals(jsonObject, null);
        assertEquals(service.getData(data), jsonObject);


    }

    @Test
    void getDataFromApiTest() throws IOException {
        CovidData data = new CovidData();
        Mockito.when(c.get(Mockito.any())).thenReturn(null);
        assertNotEquals(service.getData(data), null);

    }


} 
