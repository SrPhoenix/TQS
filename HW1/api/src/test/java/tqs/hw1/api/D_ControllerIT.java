package tqs.hw1.api;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
