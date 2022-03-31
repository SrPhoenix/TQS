package tqs.lab3_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
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

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = CarMngrApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "application-integrationtest.properties")
public class Ex3_mysqlIntegration {
    @Autowired
    private MockMvc mvc;


	@Autowired
    private CarRepository repository;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }

    @Test
     void whenValidInput_thenCreateCar() throws IOException, Exception {
        Car c1 = new Car("maker1", "model1");

        //when( cs.save(Mockito.any()) ).thenReturn( c1);

        mvc.perform(
            post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(c1.toString()))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.model", is("model1")));;


        //verify(cs, times(1)).save(Mockito.any());

        List<Car> found = repository.findAll();
        assertThat(found).extracting(Car::getModel).containsOnly("model1");
    }

    @Test
     void givenCars_whenGetCars_thenStatus200() throws Exception {
        createTestCar("maker1", "model1");
        createTestCar("maker2", "model2");



        mvc.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
                .andExpect(jsonPath("$[0].model", is("model1")))
                .andExpect(jsonPath("$[1].maker", is("maker2")));
    }

    private void createTestCar(String maker, String model) {
        Car car = new Car(maker, model);
        repository.saveAndFlush(car);
    }

}
