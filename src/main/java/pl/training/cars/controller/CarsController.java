package pl.training.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.training.cars.exceptions.ResourceNotFoundException;
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
    
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable(value = "id") Long id){
    	try {
    		if(cars.checkIfCarExists(id) == false) {
    			throw new ResourceNotFoundException();
    		}else {
    			return cars.findById(id);
    		} 		
    	}catch(ResourceNotFoundException e) {
    		System.out.println("Couldn't find car with id " + id);
    	}
    	
    	return null;
    }
    
    @PostMapping("/add")
    public String addCar(@RequestBody Car car){
        cars.addCar(car);
        
        return "New car added with id: " + car.getId();
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable(value = "id") Long id) {
    	try {
    		if(cars.checkIfCarExists(id) == false) {
    			throw new ResourceNotFoundException();
    		}else {
    			cars.deleteCar(id);
    			return "Deletion succeed";
    		} 		
    	}catch(ResourceNotFoundException e) {
    		return "Couldn't find car with id " + id;
    	} 	
    }
    
    @PutMapping("/update/{id}")
    public String updateCar(@PathVariable(value = "id") Long id, @RequestBody Car car) {
    	try {
    		if(cars.checkIfCarExists(id) == false) {
    			throw new ResourceNotFoundException();
    		}else {
    			cars.updateCar(id, car);
    			return "Updating succeed";
    		} 		
    	}catch(ResourceNotFoundException e) {
    		return "Couldn't find car with id " + id;
    	}	
    }
}
