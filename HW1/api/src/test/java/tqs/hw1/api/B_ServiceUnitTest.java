package tqs.hw1.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import tqs.hw1.api.service.Cache;
import tqs.hw1.api.service.CovidService;
import tqs.hw1.api.exception.APINotRespondingException;
import tqs.hw1.api.model.ModelRequest;
import tqs.hw1.api.model.ResponseData;

@ExtendWith(MockitoExtension.class)
public class B_ServiceUnitTest {
    
    @Mock
    Cache c;

    @InjectMocks
    CovidService service;


    @Test
    void getDataFromCacheTest() throws IOException, URISyntaxException, APINotRespondingException {
        
        ModelRequest data = new ModelRequest();
        data.setCity_name("Aveiro");

        ResponseData response = new ResponseData();
        response.setDeaths("10000");

        assertNotEquals(c, null);

        Mockito.when(c.get(data)).thenReturn(response);



        assertEquals(service.getData(data), response);

        Mockito.verify(c, times(1)).get(data);


    }

    @Test
    void getDataFromApiTest() throws IOException, URISyntaxException, APINotRespondingException {
        ModelRequest data = new ModelRequest();
        Mockito.when(c.get(Mockito.any())).thenReturn(null);

        data.setCountry("AFG");
        ResponseData[] response = service.getData(data);
        assertTrue(response.length > 0);
        assertEquals("AFG", response[0].getIso());
        Mockito.verify(c, times(1)).get(Mockito.any());

    }


} 
