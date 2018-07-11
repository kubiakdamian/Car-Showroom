package pl.training.cars.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import pl.training.cars.model.Car;

@Data
@Component
public class Cars {
	private static List<Car> cars;
	
	public Cars() {
		cars = new ArrayList<>();
		
		cars.add(new Car("Civic", "Honda", 178, 8.9));
		cars.add(new Car("e46", "BMW", 205, 7.8));
		cars.add(new Car("a4", "Audi", 125, 9.4));
		cars.add(new Car("Yaris", "Toyota", 90, 12.4));
		cars.add(new Car("Impreza", "Subaru", 320, 6.5));
	}

	public List<Car> getCars() {
		return cars;
	}
	
	public Car findById(Long id) {
		for(Car car : cars) {
    		if(car.getId() == id) {
    			return car;
    		}
    	}
		
		return null;
	}
	
	public void addCar(Car car) {
		cars.add(car);
	}
	
	public void deleteCar(Long id) {
		for(Car car : cars) {
    		if(car.getId() == id) {
    			int index = cars.indexOf(car);
    			cars.remove(index);
    		}
    	}
	}
	
	public void updateCar(Long id, Car newCar) {
		for(Car car : cars) {
    		if(car.getId() == id) {
    			car.setModel(newCar.getModel());
    			car.setBrand(newCar.getBrand());
    			car.setHorsePower(newCar.getHorsePower());
    			car.setAccelerationToHundred(newCar.getAccelerationToHundred());
    		}
    	}
	}
	
	public boolean checkIfCarExists(Long id) {
		for(Car car : cars) {
    		if(car.getId() == id) {
    			return true;
    		}
    	}	
		return false;
	}
	
	public boolean checkIfDatabaseIsEmpty() {
		if(cars.isEmpty()) {
			return true;
		}
		
		return false;
	}
}
