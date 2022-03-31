package tqs.lab3_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarManagerService {

    @Autowired
    public CarRepository carRepository;

    public Car save(Car c){
        return carRepository.save(c);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Optional<Car> getCarDetails(Long carId){
        Car c  = carRepository.findByCarId(carId);
        return c != null ? Optional.of(c) : null;
    }
}

