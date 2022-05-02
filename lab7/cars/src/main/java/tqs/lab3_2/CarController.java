package tqs.lab3_2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CarController {
    
    private final CarManagerService carManagerService;

    public CarController(CarManagerService carManagerService) {
        this.carManagerService = carManagerService;
    }

    @PostMapping("/cars" )
    public ResponseEntity<Car> createCar(@RequestBody CarDTO car) {
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carManagerService.save( car.toCarEntity() );
        return new ResponseEntity<>(saved, status);
    }


    @GetMapping(path="/cars" )
    public List<Car> getAllCars() {
        return carManagerService.getAllCars();
    }
}
