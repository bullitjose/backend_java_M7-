package com.vehicles.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TitularVehicle extends ConductorVehicle {
	protected String asseguranca;
	protected String garatgePropi;
	// Els titulars tenen vehicles
	protected List<Vehicle> vehicles = new ArrayList<>();
/**
 * 
 * @param nom
 * @param cognoms
 * @param dataNaixement
 * @param llicenciaConduir
 * @param asseguranca
 * @param garatgePropi
 * @throws Exception
 */
	public TitularVehicle(String nom, String cognoms,
			Calendar dataNaixement, LlicenciaConduir llicenciaConduir,
			String asseguranca, String garatgePropi)
			throws Exception {
		super(nom, cognoms, dataNaixement, llicenciaConduir);
		
		if (asseguranca == null)
			throw new Exception();
		if (garatgePropi == null)
			throw new Exception();

		this.asseguranca = asseguranca;
		this.garatgePropi = garatgePropi;

	}

	public String getAsseguranca() {
		return asseguranca;
	}

	public void setAsseguranca(String asseguranca) {
		this.asseguranca = asseguranca;
	}

	public String getGaratgePropi() {
		return garatgePropi;
	}

	public void setGaratgePropi(String garatgePropi) {
		this.garatgePropi = garatgePropi;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
/**
 * 
 * @return string amb tots els vehicles de la llista i les seves dades
 */
	public String getAllVehicles() {

		StringBuilder llistaVehicles = new StringBuilder();
		llistaVehicles
				.append("\nNombre de vehicles: " + vehicles.size());

		for (Vehicle vehicle : vehicles) {
			if (vehicle instanceof Bike) {
				llistaVehicles.append("\n\tMoto");
			}
			if (vehicle instanceof Car) {
				llistaVehicles.append("\n\tCoche");
			}
			if (vehicle instanceof Bike) {
				llistaVehicles.append("\n\tCamio");
			}
			llistaVehicles.append("\n\tMarca: " + vehicle.getBrand()
					+ "\nMatricula: " + vehicle.getPlate()
					+ "\nColor");

		}

	
		return llistaVehicles.toString();
	}
	/**
	 * 
	 * @param vehicles
	 * @throws Exception
	 * 
	 * Metode per afegir un vehicle a la llista vehicles
	 */
	public void addVehicle(List<Vehicle> vehicles) throws Exception {
		if (vehicles.size() != 1)
			throw new Exception();

		 Vehicle vehicle= vehicles.get(0);

		this.vehicles.add(vehicle);
	}

}
