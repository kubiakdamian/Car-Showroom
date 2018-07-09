package pl.training.cars.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

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
	
	public void addCar(Car car) {
		cars.add(car);
	}
}
