package pl.training.cars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.training.cars.model.Car;
import pl.training.cars.model.Cars;

@RestController
@RequestMapping("/cars")
public class CarsController {

	@Autowired
    private Cars cars;

    @GetMapping("/all")
    public List<Car> getAllCars(){
        return cars.getCars();
    }
    
    @GetMapping("/byHP/{horsePower}")
    public List<Car> getCarsByHorsePower(@PathVariable(value = "horsePower") int horsePower){
    	List<Car> result = new ArrayList<>();
    	
    	for(Car car : cars.getCars()) {
    		if(car.getHorsePower() >= horsePower) {
    			result.add(car);
    		}
    	}
    	
        return result;
    }
    
    @PostMapping("/add")
    public String addCar(@RequestBody Car car){
        cars.addCar(car);
        
        return "New car added " + car.toString();
    }
}
