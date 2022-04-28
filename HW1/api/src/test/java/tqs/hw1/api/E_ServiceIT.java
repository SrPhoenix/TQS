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
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import tqs.hw1.api.service.Cache;
import tqs.hw1.api.service.CovidService;
import tqs.hw1.api.exception.APINotRespondingException;
import tqs.hw1.api.model.ModelRequest;

@ExtendWith(MockitoExtension.class)
public class E_ServiceIT {
    

    @Autowired
    CovidService service;


    @Test
    void HitMissTest() throws IOException, URISyntaxException, APINotRespondingException {
        assertEquals(0, service.getHit());
        assertEquals(0, service.getMiss());
        assertEquals(0, service.getCountOfRequest());

        ModelRequest data = new ModelRequest();
        data.setCountry("AFG");
        service.getData(data);

        //assertEquals(1, service.getHit());
        assertEquals(0, service.getMiss());
        assertEquals(1, service.getCountOfRequest());

        ModelRequest data2 = new ModelRequest();
        data2.setCountry("This country doesnt exist");
        service.getData(data2);

        assertEquals(1, service.getHit());
        assertEquals(1, service.getMiss());
        assertEquals(2, service.getCountOfRequest());



    }



} 
