package pl.training.cars.model;

import lombok.Data;

@Data
public class Car {
	private String model;
	private String brand;
	private int horsePower;
	private double accelerationToHundred;
	
	public Car(String model, String brand, int horsePower, double accelerationToHundred) {
		this.model = model;
		this.brand = brand;
		this.horsePower = horsePower;
		this.accelerationToHundred = accelerationToHundred;
	}
}
