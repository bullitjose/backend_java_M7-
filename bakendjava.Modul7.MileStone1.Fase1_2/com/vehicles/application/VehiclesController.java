package com.vehicles.application;

import java.util.Scanner;

import com.vehicles.domain.Car;
import com.vehicles.domain.Vehicle;
import com.vehicles.domain.Wheel;
import com.vehicles.persistence.VehiclesRepository;


import java.util.ArrayList;
import java.util.List;

public class VehiclesController {
	private VehiclesRepository repository;

	public VehiclesController() {
		repository = new VehiclesRepository();
	}

	public void createVehicle(String vehicleMatricula, String vehicleMarca, String vehicleColor) throws Exception {
		Car car = new Car(vehicleMatricula, vehicleMarca, vehicleColor);
		repository.addVehicle(car);
		// Fase1.3) Afegir-li dues rodes traseres demanant a lï¿½usuari la marca i el
		// diametre.
		Scanner sc = new Scanner(System.in);

		System.out.println("Introdueix informacio rodes traseres del cotxe");
		System.out.println("	Roda dreta");
		System.out.print("		Introdueix marca roda: ");
		String marcaRoda = sc.nextLine();
		System.out.print("		Introdueix diametre de la roda: ");
		Double diametreRoda = getDoubleAmbRang(sc, 0.4, 4.0);
		

		Wheel rodaTraseraDreta = new Wheel(marcaRoda, diametreRoda);

		System.out.println("	Roda esquerra");
		System.out.print("		Introdueix marca roda: ");
		marcaRoda = sc.nextLine();
		System.out.print("		Introdueix diametre de la roda: ");
		
		diametreRoda = getDoubleAmbRang(sc, 0.4, 4.0);

		Wheel rodaTraseraEsquerra = new Wheel(marcaRoda, diametreRoda);

		List<Wheel> rodesTraseres = new ArrayList<Wheel>();
		rodesTraseres.add(rodaTraseraDreta);
		rodesTraseres.add(rodaTraseraEsquerra);

		// Fase1,4) Afegir-li dues rodes davanteres demanant a lï¿½usuari la marca i el
		// diametre.
		System.out.println("Introdueix informacio rodes davanteres del cotxe");
		System.out.println("	Roda dreta");
		System.out.print("		Introdueix marca: ");
		marcaRoda = sc.nextLine();
		System.out.print("		Introdueix diametre de la roda (0.4-4.0): ");
		diametreRoda = getDoubleAmbRang(sc, 0.4, 4.0);

		Wheel rodaDavantDreta = new Wheel(marcaRoda, diametreRoda);

		System.out.println("	Roda esquerra");
		System.out.print("		Introdueix marca roda: ");
		marcaRoda = sc.nextLine();
		System.out.print("		Introdueix diametre de la roda: ");
		diametreRoda = Double.valueOf(sc.nextLine());

		Wheel rodaDavantEsquerra = new Wheel(marcaRoda, diametreRoda);

		List<Wheel> rodesDavanteres = new ArrayList<Wheel>();

		rodesDavanteres.add(rodaDavantDreta);
		rodesDavanteres.add(rodaDavantEsquerra);

		car.addWheels(rodesDavanteres, rodesTraseres);

		sc.close();

	}

	/**
	 * Metode per introduir numero en rang correcte,
	 * 
	 * @param sc
	 * @param min, valor double minim del rang de valors
	 * @param max, valor double maxim del rang de valors
	 * @return i, valor double en format i rang valid
	 */

	public static double getDoubleAmbRang(Scanner sc, double min, double max) {
		double i = 0.0;
		boolean isValid = false;
		while (isValid == false) {
			// i = sc.nextDouble();
			i = Double.valueOf(sc.nextLine());
			if (i <= min) {
				System.out.print("----Error, valor ha de ser més gran que " + min+" .Torna a provar ");
			} else if (i >= max) {
				System.out.print("----Error, valor ha de ser menor que " + max+" .Torna a provar ");

			} else {
				isValid = true;
			}

		}
		return i;
	}

	public String getAllVehicles() {
		// TODO Auto-generated method stub

		StringBuilder repositoryToString = new StringBuilder();

		for (Vehicle vehicle : repository.getAllMembers()) {

			repositoryToString.append("Marca: " + vehicle.getBrand() + " ,color: " + vehicle.getColor()
					+ " ,matricula: " + vehicle.getPlate());

		}

		String singleString = repositoryToString.toString();
		return singleString;
	}
}
