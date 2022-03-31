package tqs.lab3_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test scenario: verify the logic of the Service, mocking the response of the datasource
 * Results in standard unit test with mocks
 */
@ExtendWith(MockitoExtension.class)
class B_CarService_Test {

    // mocking the responses of the repository (i.e., no database will be used)
    // lenient is required because we load more expectations in the setup
    // than those used in some tests. As an alternative, the expectations
    // could move into each test method and be trimmed (no need for lenient then)
    @Mock( lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService carService;

    @BeforeEach
    public void setUp() {

        //these expectations provide an alternative to the use of the repository
        Car car1 = new Car("maker1", "model1");
        car1.setCarId(111L);

        //Car car2 = new Car("model2", "maker2");
        //Car car3 = new Car("model3", "maker3");

        //List<Car> allCars = Arrays.asList(car1, car2, car3);

        //Mockito.when(carRepository.findByName(car1.getName())).thenReturn(car1);
        //Mockito.when(carRepository.findByName(car3.getName())).thenReturn(car3);
        //Mockito.when(carRepository.findByName("wrong_name")).thenReturn(null);
        Mockito.when(carRepository.findByCarId(car1.getCarId())).thenReturn(car1);
        //Mockito.when(carRepository.findAll()).thenReturn(allCars);
        Mockito.when(carRepository.findByCarId(-99L)).thenReturn(null);
    }

    @Test
     void getCarDetails_valid() {
        Long id = 111L;
        Optional<Car> found = carService.getCarDetails(id);

        assertThat(found.get().getCarId()).isEqualTo(id);
    }


    @Test
     void getCarDetails_Nonvalid() {
        Long id = -99L;
        Optional<Car> found = carService.getCarDetails(id);

        assertThat(found).isEqualTo(null);
    }


}
