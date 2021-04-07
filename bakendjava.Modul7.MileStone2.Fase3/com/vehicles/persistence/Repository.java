package com.vehicles.persistence;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.domain.Persona;
import com.vehicles.domain.Vehicle;

public class Repository {

	private static List<Persona> persones = new ArrayList<>();
	private static List<Vehicle> vehicles = new ArrayList<>();

	public Repository() {
	}
/**
 * 
 * @param vehicle
 * @throws Exception
 * 
 * Metode per afegir vehicle a la llista de vehicles que fa de repository
 */
	public void addVehicle(Vehicle vehicle) throws Exception {
		if (vehicle == null)
			throw new Exception();
		vehicles.add(vehicle);
	}
	/**
	 * 
	 * @param persona
	 * @throws Exception
	 * 
	 * Metode per afegir persona a la llista de persones que fa de repository
	 */
	public void addPersona(Persona persona) throws Exception {
		if (persona == null)
			throw new Exception();
		persones.add(persona);
	}

/**
 * 
 * @return List<Vehicle>, torna llista de tots els vehicles
 */
	public List<Vehicle> getAllVehicles() {
		return new ArrayList<>(vehicles);
	}
/**
 * 
 * @return List<Persona>, torna llista de totes les persones
 */
	public List<Persona> getAllPersones() {
		return new ArrayList<>(persones);
	}

	
}
