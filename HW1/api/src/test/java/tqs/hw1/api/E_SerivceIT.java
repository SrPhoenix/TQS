package tqs.hw1.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import tqs.hw1.api.service.Cache;
import tqs.hw1.api.service.CovidService;
import tqs.hw1.api.model.CovidData;

@ContextConfiguration(classes = Cache.class)
@SpringBootTest
public class E_SerivceIT {
    


    @Autowired
    CovidService service;


    @Test
    void HitMissTest() throws IOException {
        assertEquals(service.getHit_miss()[0], 0);
        assertEquals(service.getHit_miss()[1], 0);
        assertEquals(service.getCountOfRequest(), 0);
        CovidData data = new CovidData();
        data.setCountry("AFG");
        service.getData(data);

        assertEquals(service.getHit_miss()[0], 1);
        assertEquals(service.getHit_miss()[1], 0);
        assertEquals(service.getCountOfRequest(), 1);

        data.setCountry("This country doesnt exist");
        service.getData(data);

        assertEquals(service.getHit_miss()[0], 1);
        assertEquals(service.getHit_miss()[1], 1);
        assertEquals(service.getCountOfRequest(), 2);

    }

} 
