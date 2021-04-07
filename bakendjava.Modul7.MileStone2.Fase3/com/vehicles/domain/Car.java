package com.vehicles.domain;

import java.util.List;

public class Car extends Vehicle {
	
	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
		tipus="cotxe";
	}
/**
 * 
 * @param frontWheels
 * @param backWheels
 * @throws Exception
 * 
 * Metode que afegeix les rodes al cotxe
 */
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}
/**
 * 
 * @param wheels
 * @throws Exception
 * 
 * Metode que afegeix dues rodes al cotxe
 */
	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel)) {
			System.out.println("Error!. Roda dreta diferent de l'esquerra");

		}

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
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
