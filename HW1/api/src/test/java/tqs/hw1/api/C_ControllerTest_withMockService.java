package tqs.hw1.api;


import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CovidController.class)
public class C_ControllerTest_withMockService {
    @Autowired
    private MockMvc mvc;    //entry point to the web framework

    // inject required beans as "mockeable" objects
    // note that @AutoWire would result in NoSuchBeanDefinitionException


    @MockBean
    private CovidServiceImp service;


    @Test
    void getDataFromApiTest() throws Exception {

        CovidData data = new CovidData();
        data.setCountry("AFG");
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject("{\"data\":\"somedata\",\"more\":\"data\"}");
        }catch (JSONException err){
            System.err.println("Error: "+ err.toString());
        }
        when( service.getData(Mockito.any()) ).thenReturn( jsonObject);

        mvc.perform(
                get("/data").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.toJson(data)))
                .andExpect(status().isOk());

            
                verify(service, times(1)).getData(Mockito.any());

    }

}



