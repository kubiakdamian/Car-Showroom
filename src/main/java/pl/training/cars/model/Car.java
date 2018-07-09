package pl.training.cars.model;

import java.util.concurrent.atomic.AtomicLong;

import lombok.Data;

@Data
public class Car {
	static final AtomicLong NEXT_ID = new AtomicLong(1);
    final long id = NEXT_ID.getAndIncrement();
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
	
	public Car() {}
}
