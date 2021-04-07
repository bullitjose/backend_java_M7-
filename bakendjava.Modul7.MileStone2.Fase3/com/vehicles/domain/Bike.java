package com.vehicles.domain;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
		tipus="moto";
	}
/**
 * 
 * @param frontWheels
 * @param backWheels
 * @throws Exception
 * 
 * Metode que afegeix dues rodes
 */
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addOneWheel(frontWheels);
		addOneWheel(backWheels);
	}
/**
 * 
 * @param wheels
 * @throws Exception
 * 
 * Metode que afegeix una roda
 */
	public void addOneWheel(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 1)
			throw new Exception();

		Wheel wheel = wheels.get(0);

		this.wheels.add(wheel);
	}

	@Override
	public String getTipus() {
		return tipus;
	}
@Override
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
}
