package pl.training.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.training.cars.model.Car;
import pl.training.cars.model.Cars;

@RestController
public class CarsController {

	@Autowired
    private Cars cars;

    @GetMapping("/cars")
    public List<Car> getAllCars(){
    	cars = new Cars();
        return cars.getCars();
    }

}
