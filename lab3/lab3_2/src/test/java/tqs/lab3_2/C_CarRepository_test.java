package tqs.lab3_2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class C_CarRepository_test {



    // get a test-friendly Entity Manager
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    void whenFindCarById_thenReturnCar() {
        // arrange a new car and insert into db
        Car c1 = new Car("maker1", "model1");
        entityManager.persistAndFlush(c1); //ensure data is persisted at this point

        // test the query method of interest
        Car found = carRepository.findByCarId(c1.getCarId());
        assertThat( found ).isEqualTo(c1);
    }

    @Test
    void whenInvalidCarName_thenReturnNull() {
        Car fromDb = carRepository.findByCarId(-99L);
        assertThat(fromDb).isNull();
    }

    @Test
    void whenFindEmployedByExistingId_thenReturnCar() {
        Car c2 = new Car("maker2", "model2");
        entityManager.persistAndFlush(c2);

        Car fromDb = carRepository.findByCarId(c2.getCarId());
        assertThat(fromDb).isNotNull();
        assertThat(fromDb.getCarId()).isEqualTo( c2.getCarId());
    }

    @Test
    void whenInvalidId_thenReturnNull() {
        Car fromDb = carRepository.findById(-111L).orElse(null);
        assertThat(fromDb).isNull();
    }

    @Test
    void givenSetOfCars_whenFindAll_thenReturnAllCars() {
        Car c3 = new Car("maker3", "model3");
        Car c4 = new Car("maker4", "model4");
        Car c5 = new Car("maker5", "model5");

        entityManager.persist(c3);
        entityManager.persist(c4);
        entityManager.persist(c5);
        entityManager.flush();

        List<Car> allCars = carRepository.findAll();

        assertThat(allCars).hasSize(3).extracting(Car::getModel).containsOnly(c3.getModel(), c4.getModel(), c5.getModel());
    }

}
