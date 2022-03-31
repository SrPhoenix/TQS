package tqs.lab3_2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CarController.class)
public class D_CarRestController_withMock {
    
    @Autowired
    private MockMvc mvc;


	@MockBean
    private CarManagerService cs;


    @Test
     void whenValidInput_thenCreateCar() throws  Exception {
        Car c1 = new Car("maker1", "model1");

        when( cs.save(Mockito.any()) ).thenReturn( c1);

        mvc.perform(
            post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(c1.toString()))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.model", is("model1")));;


        verify(cs, times(1)).save(Mockito.any());


    }

    @Test
     void givenCars_whenGetCars_thenStatus200() throws Exception {
        Car car1 = new Car("maker1", "model1");
        Car car2 = new Car("maker2", "model2");
        Car car3 = new Car("maker3", "model3");


        List<Car> allCar = Arrays.asList(car1, car2,car3);
        when( cs.getAllCars()).thenReturn(allCar);
        
        mvc.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].model", is("model1")))
                .andExpect(jsonPath("$[1].maker", is("maker2")))
                .andExpect(jsonPath("$[2].model", is("model3")))
                ;
    }


}
