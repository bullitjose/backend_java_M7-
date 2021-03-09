package com.vehicles.view;

import java.util.Scanner;

import com.vehicles.application.VehiclesController;
import com.vehicles.domain.Car;
import com.vehicles.domain.Vehicle;

import java.util.regex.*;

public class Main {
	private static VehiclesController controller = new VehiclesController();

	public static void main(String[] args) throws Exception {
		// FASE 1. 1 Demanar a lï¿½usuari la matrï¿½cula del cotxe, la marca i el seu
		// color.

		Scanner sc = new Scanner(System.in);
		String vehicleMatricula="";
		vehicleMatricula = validarMatricula(sc, vehicleMatricula);

		// Introduir marca
		System.out.println("Introdueix marca del cotxe: ");
		String vehicleMarca = sc.nextLine();
		// Introduir color
		System.out.println("Introdueix color del cotxe: ");
		String vehicleColor = sc.nextLine();

		// FASE 1. 2 Crear el cotxe amb les dades anteriors.
		// -------------------------

		controller.createVehicle(vehicleMatricula, vehicleMarca, vehicleColor);
		String allVehicles = controller.getAllVehicles();
		System.out.println("vehicles: " + " \n" + allVehicles + " \n");

	}

	/**
	 * @param sc
	 * @param vehicleMatricula
	 * @return
	 */
	private static String validarMatricula(Scanner sc, String vehicleMatricula) {
		while (true) {
			// Introduir matricula
			System.out.println("Introdueix matricula del cotxe(4 lletres, i entre 2 i 3 nº): ");
			vehicleMatricula = sc.nextLine();
			// Controlar entrada de la matricula que sigui correcta,4 numeros, i entre 2 i 3
			// lletres
			if (Pattern.matches("([a-zA-Z]{4})([0-9]{2,3})", vehicleMatricula)) {
				break;
			} else {
				System.out.println("Error!. Entrada no valida. Torna a provar");
			}

		}
		return vehicleMatricula;
	}
}