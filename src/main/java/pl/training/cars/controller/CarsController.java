package pl.training.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import pl.training.cars.exceptions.ResourceNotFoundException;
import pl.training.cars.implementation.Cars;
import pl.training.cars.model.Car;

@RestController
@RequestMapping("/cars")
public class CarsController {

	@Autowired
    private Cars cars;

    @ApiResponses(value = {
	   @ApiResponse(code = 200,
	      message = "Cars returned"),
	   @ApiResponse(code = 404,
	      message = "Cars not found")})
    @GetMapping()
    public ResponseEntity<List<Car>> getAllCars(){
    	try {
    		if(cars.checkIfDatabaseIsEmpty()) {
        		throw new ResourceNotFoundException();
        	}
            return new ResponseEntity<List<Car>>(cars.getCars(), HttpStatus.OK);
    	}catch (ResourceNotFoundException e) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	
    }
    
    @ApiResponses(value = {
	   @ApiResponse(code = 200,
	      message = "Found Car by specified ID"),
	   @ApiResponse(code = 404,
	      message = "Car not found")})
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") Long id){
    	try {
    		if(!cars.checkIfCarExists(id)) {
    			throw new ResourceNotFoundException();
    		}else {
    			return new ResponseEntity<Car>(cars.findById(id), HttpStatus.OK);
    		} 		
    	}catch(ResourceNotFoundException e) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    
    @ApiResponses(value = {
	   @ApiResponse(code = 200,
	      message = "Car added successfully")})
    @PostMapping()
    public ResponseEntity<String> addCar(@RequestBody Car car){
        cars.addCar(car);
        
        return new ResponseEntity<String>("Added car with id " + car.getId(), HttpStatus.OK);
    }
    
    @ApiResponses(value = {
	   @ApiResponse(code = 200,
	      message = "Car deleted successfully"),
	   @ApiResponse(code = 404,
	      message = "Car not found")})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable(value = "id") Long id) {
    	try {
    		if(!cars.checkIfCarExists(id)) {
    			throw new ResourceNotFoundException();
    		}else {
    			cars.deleteCar(id);
    			return new ResponseEntity<String>("Success", HttpStatus.OK);
    		} 		
    	}catch(ResourceNotFoundException e) {
    		return new ResponseEntity<String>("Couldn't find car with id " + id, HttpStatus.NOT_FOUND);
    	} 	
    }
    
    @ApiResponses(value = {
	   @ApiResponse(code = 200,
	      message = "Car updated successfully"),
	   @ApiResponse(code = 404,
	      message = "Car not found")})
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCar(@PathVariable(value = "id") Long id, @RequestBody Car car) {
    	try {
    		if(!cars.checkIfCarExists(id)) {
    			throw new ResourceNotFoundException();
    		}else {
    			cars.updateCar(id, car);
    			return new ResponseEntity<String>("Success", HttpStatus.OK);
    		} 		
    	}catch(ResourceNotFoundException e) {
    		return new ResponseEntity<String>("Couldn't find car with id " + id, HttpStatus.NOT_FOUND);
    	}	
    }
}
