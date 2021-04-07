package com.vehicles.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
	protected String tipus;
	
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<>();

	protected Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
		tipus="vehicle";
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Wheel> getWheels() {
		return wheels;
	}

	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}
/**
 * 
 * @return String, string amb totes le rodes i les seves dades
 */
	public String getAllWheels() {
		

		StringBuilder llistaRodes = new StringBuilder();
				
		for (Wheel wheel : wheels) {

			llistaRodes.append("\n\t\tMarca: " + wheel.getBrand()
					+ "\n\t\tDiametre: " + wheel.getDiameter());

		}

		return llistaRodes.toString();
	}

	
	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

}
