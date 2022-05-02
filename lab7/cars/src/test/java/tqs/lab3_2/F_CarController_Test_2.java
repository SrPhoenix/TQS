package tqs.lab3_2;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@WebMvcTest(CarController.class)
public class F_CarController_Test_2 {

    @MockBean 
    private CarManagerService service; 

    @Autowired
    private MockMvc mvc;



    @BeforeEach
    public void setUp(){
        RestAssuredMockMvc.mockMvc(mvc);
    }

    @AfterEach
    public void resetDb() {
        RestAssuredMockMvc.reset();
    }

    @Test
    void whenValidInput_thenCreateCar() throws Exception {
       Car c1 = new Car("maker1", "model1");

       when( service.save(Mockito.any()) ).thenReturn( c1);

       RestAssuredMockMvc.given().contentType( ContentType.JSON ).body( c1 ).post( "/api/cars" ).then().log().body().assertThat()
       .body("model", is( "model1" ) );


       verify(service, times(1)).save(Mockito.any());

   }

   @Test
    void givenCars_whenGetCars_thenStatus200() throws Exception {
        Car c1 = new Car("maker1", "model1");
        Car c2 = new Car("maker2", "model2");

        List<Car> allCars = Arrays.asList( c1, c2 );
        Mockito.when( service.getAllCars() ).thenReturn( allCars );

       //given().get("/api/cars").then().contentType( ContentType.JSON ).statusCode(200).assertThat().body( "$", hasSize(2) )
       //.and().body("[0].model" ,is("model1")).and().body("[1].maker" ,is("maker2")).then().log().body()

        RestAssuredMockMvc.given().get("/api/cars").then().log().all()
               .statusCode(200)
               .and()
               .body("$", hasSize(2))
               .body("[0].model", is("model1"))
               .body("[1].maker", is("maker2"));
   }

}
