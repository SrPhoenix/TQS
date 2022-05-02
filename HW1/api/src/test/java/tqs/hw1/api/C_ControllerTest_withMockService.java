package tqs.hw1.api;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;



import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import tqs.hw1.api.service.CovidService;
import tqs.hw1.api.model.ModelRequest;
import tqs.hw1.api.model.Region;
import tqs.hw1.api.model.ResponseData;
import tqs.hw1.api.model.ResponseDataArray;
import tqs.hw1.api.controller.CovidController;


@WebMvcTest(CovidController.class)
public class C_ControllerTest_withMockService {
    @Autowired
    private MockMvc mvc;    //entry point to the web framework

    // inject required beans as "mockeable" objects
    // note that @AutoWire would result in NoSuchBeanDefinitionException


    @MockBean
    private CovidService service;


    @Test
    void getDataFromApiTest() throws Exception {

        ModelRequest data = new ModelRequest();
        data.setCountry("AFG");
        ResponseData response = new ResponseData();
        Region rg = new Region();
        rg.setIso("AFG");
        response.setRegion(rg);

        ResponseDataArray array = new ResponseDataArray();
        array.add(response);
        
        when( service.getData(Mockito.any()) ).thenReturn( array);

        mvc.perform(
                get("/data").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.toJson(data)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data.[0].region.iso", is("AFG")));

            
                verify(service, times(1)).getData(Mockito.any());

    }

}



