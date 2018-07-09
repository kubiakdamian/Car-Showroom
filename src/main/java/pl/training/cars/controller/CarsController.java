package pl.training.cars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    
    @GetMapping("/byId/{id}")
    public Car getCarById(@PathVariable(value = "id") Long id){
    	 return cars.findById(id);
    }
    
    @PostMapping("/add")
    public String addCar(@RequestBody Car car){
        cars.addCar(car);
        
        return "New car added with id: " + car.getId();
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable(value = "id") Long id) {
    	cars.deleteCar(id);
    	return "Deletion succeed";
    }
}
