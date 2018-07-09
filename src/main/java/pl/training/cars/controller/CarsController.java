package pl.training.cars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/cars/{horsePower}")
    public List<Car> getCarsByHorsePower(@PathVariable(value = "horsePower") int horsePower){
    	cars = new Cars();
    	List<Car> result = new ArrayList<>();
    	
    	for(Car car : cars.getCars()) {
    		if(car.getHorsePower() >= horsePower) {
    			result.add(car);
    		}
    	}
    	
        return result;
    }
}
