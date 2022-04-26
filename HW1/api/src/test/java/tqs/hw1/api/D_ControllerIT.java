package tqs.hw1.api;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import tqs.hw1.api.model.CovidData;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = ApiApplication.class)
@AutoConfigureMockMvc
public class D_ControllerIT {
    
    @Autowired
    private MockMvc mvc;
    
    @Test
     void getDataIT() throws IOException, Exception {
        CovidData data = new CovidData();
        data.setCountry("AFG");

        mvc.perform(
                get("/data?date=&country=AFG&region_name=&city_name=").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.toJson(data)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.[0].region.iso", is("AFG")));

            

    }

}
