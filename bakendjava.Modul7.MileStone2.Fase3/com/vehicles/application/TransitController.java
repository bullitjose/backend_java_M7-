package com.vehicles.application;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.vehicles.domain.Bike;
import com.vehicles.domain.Camio;
import com.vehicles.domain.ConductorVehicle;
import com.vehicles.domain.LlicenciaConduir;
import com.vehicles.domain.Persona;
import com.vehicles.domain.TitularVehicle;
import com.vehicles.domain.Vehicle;
import com.vehicles.domain.Wheel;
import com.vehicles.persistence.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TransitController {
	private Repository repository;
	// patro que permet entrar nombre double
	private static final String PATRODIAMETRERODA = "(\\d+(?:\\.\\d+)?)";

	public TransitController() {
		repository = new Repository();
	}
/**
 * 
 * @param nom
 * @param cognoms
 * @param dataNaixement
 * @param llicenciaConduir
 * @param assegurança
 * @param garatgePropi
 * @throws Exception
 * 
 * Metode que crear titular vehicle i lafegeix al repository
 */
	public void createTitularVehicle(String nom, String cognoms,
			Calendar dataNaixement, LlicenciaConduir llicenciaConduir,
			String assegurança, String garatgePropi)
			throws Exception {

		TitularVehicle titularVehicle = new TitularVehicle(nom,
				cognoms, dataNaixement, llicenciaConduir, assegurança,
				garatgePropi);
		repository.addPersona(titularVehicle);

	}
/**
 * 
 * @param nom
 * @param cognoms
 * @param dataNaixement
 * @param llicenciaConduir
 * @throws Exception
 * 
 * Metode que crear conductor vehicle i lafegeix al repository
 */
	public void createConductorVehicle(String nom, String cognoms,
			Calendar dataNaixement, LlicenciaConduir llicenciaConduir)
			throws Exception {

		ConductorVehicle conductorVehicle = new ConductorVehicle(nom,
				cognoms, dataNaixement, llicenciaConduir);
		repository.addPersona(conductorVehicle);
	}
/**
 * 
 * @param vehicleMatricula
 * @param vehicleMarca
 * @param vehicleColor
 * @throws Exception
 * 
 * Metode per crear moto i lafegeix al repository
 */
	public void createMoto(String vehicleMatricula,
			String vehicleMarca, String vehicleColor)
			throws Exception {
		Bike moto = new Bike(vehicleMatricula, vehicleMarca,
				vehicleColor);
		repository.addVehicle(moto);

		Scanner sc = new Scanner(System.in);

		System.out.println(
				"Introdueix informacio roda trasera de la moto");

		Wheel rodaTrasera = inputRoda(sc);

		List<Wheel> rodesTraseres = new ArrayList<>();
		rodesTraseres.add(rodaTrasera);

		System.out.println(
				"Introdueix informacio roda davantera de la moto");
		Wheel rodaDavant = inputRoda(sc);

		List<Wheel> rodesDavanteres = new ArrayList<>();

		rodesDavanteres.add(rodaDavant);

		moto.addWheels(rodesDavanteres, rodesTraseres);

	}
/**
 * 
 * @param vehicleMatricula
 * @param vehicleMarca
 * @param vehicleColor
 * @throws Exception
 * 
 * Metode que crea cotxe i lafegeix al repository
 */
	public void createCoche(String vehicleMatricula,
			String vehicleMarca, String vehicleColor)
			throws Exception {
		Camio car = new Camio(vehicleMatricula, vehicleMarca,
				vehicleColor);
		repository.addVehicle(car);
		// Afegir-li dues rodes traseres demanant a lï¿½usuari la marca i el
		// diametre.
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Introdueix informacio rodes traseres del cotxe");
		System.out.println("\tRoda dreta");
		Wheel rodaTraseraDreta = inputRoda(sc);

		System.out.println("\tRoda esquerra");
		Wheel rodaTraseraEsquerra = inputRoda(sc);

		List<Wheel> rodesTraseres = new ArrayList<>();
		rodesTraseres.add(rodaTraseraDreta);
		rodesTraseres.add(rodaTraseraEsquerra);

		// Afegir-li dues rodes davanteres demanant a lusuari la marca i el
		// diametre.
		System.out.println(
				"Introdueix informacio rodes davanteres del cotxe");
		System.out.println("\tRoda dreta");
		Wheel rodaDavantDreta = inputRoda(sc);

		System.out.println("\tRoda esquerra");
		Wheel rodaDavantEsquerra = inputRoda(sc);

		List<Wheel> rodesDavanteres = new ArrayList<>();

		rodesDavanteres.add(rodaDavantDreta);
		rodesDavanteres.add(rodaDavantEsquerra);

		car.addWheels(rodesDavanteres, rodesTraseres);

	}
/**
 * 
 * @param vehicleMatricula
 * @param vehicleMarca
 * @param vehicleColor
 * @throws Exception
 * 
 * Metode que crea camio i lafegeix al repository
 */
	public void createCamio(String vehicleMatricula,
			String vehicleMarca, String vehicleColor)
			throws Exception {
		Camio camio = new Camio(vehicleMatricula, vehicleMarca,
				vehicleColor);
		repository.addVehicle(camio);
		// Afegir-li dues rodes traseres demanant a lusuari la marca i el
		// diametre.
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"Introdueix informacio rodes traseres del cotxe");
		System.out.println("\tRoda dreta");
		Wheel rodaTraseraDreta = inputRoda(sc);

		System.out.println("\tRoda esquerra");
		Wheel rodaTraseraEsquerra = inputRoda(sc);

		List<Wheel> rodesTraseres = new ArrayList<>();
		rodesTraseres.add(rodaTraseraDreta);
		rodesTraseres.add(rodaTraseraEsquerra);

		// Afegir-li dues rodes davanteres demanant a lusuari la marca i el
		// diametre.
		System.out.println(
				"Introdueix informacio rodes davanteres del cotxe");
		System.out.println("\tRoda dreta");
		Wheel rodaDavantDreta = inputRoda(sc);

		System.out.println("\tRoda esquerra");
		Wheel rodaDavantEsquerra = inputRoda(sc);

		List<Wheel> rodesDavanteres = new ArrayList<>();

		rodesDavanteres.add(rodaDavantDreta);
		rodesDavanteres.add(rodaDavantEsquerra);

		camio.addWheels(rodesDavanteres, rodesTraseres);

	}
/**
 * 
 * @return string, amb tos els vehicles
 * 
 * Metode que torna els vehicles que hi ha al repostori
 */
	public String getAllVehicles() {

		StringBuilder repositoryToString = new StringBuilder();

		for (Vehicle vehicle : repository.getAllVehicles()) {

			repositoryToString.append("\n\nTipus: "
					+ vehicle.getTipus() + "\n\tMarca: "
					+ vehicle.getBrand() + "\n\tColor: "
					+ vehicle.getColor() + "\n\tMatricula: "
					+ vehicle.getPlate() + "\n\tNombre de rodes:"
					+ vehicle.getWheels().size()
					+ vehicle.getAllWheels());

		}

		return repositoryToString.toString();
	}
/**
 * 
 * @return string, amb tots les persones,titulars i conductors, del 
 * repositori
 * 
 * Metode que torna totes les persones del repostiri
 */
	public String getTotesPersones() {
		// Format de sortida de les dates
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		StringBuilder repositoryToString = new StringBuilder();

		for (Persona persona : repository.getAllPersones()) {
			repositoryToString.append("\nNom: " + persona.getNom()
					+ " \nCognoms: " + persona.getCognoms() + "\nId: "
					+ persona.getId() + " \nData naixement: "
					+ sdf.format(
							persona.getDataNaixement().getTime()));

			if (persona instanceof TitularVehicle) {
				TitularVehicle titularVehicle = (TitularVehicle) persona;
				repositoryToString
						.append("\nEs un titular de Vehicle."
								+ "\n\tNom complet: "
								+ titularVehicle.getLlicenciaConduir()
										.getNomComplet()
								+ "\n\tTipus de llicencia: "
								+ titularVehicle.getLlicenciaConduir()
										.getTipusLlicencia()
								+ "\n\tData de caducitat: "
								+ sdf.format(titularVehicle
										.getLlicenciaConduir()
										.getDataCaducitat().getTime())
								+ "\n\tAsseguranca:"
								+ titularVehicle.getAsseguranca()
								+ "\n\tGaratge Propi:"
								+ titularVehicle.getGaratgePropi());
			} else if (persona instanceof ConductorVehicle) {
				ConductorVehicle conductorVehicle = (ConductorVehicle) persona;
				repositoryToString.append("\nEs un conductor de."
						+ "\n\tTipus de llicencia: "
						+ conductorVehicle.getLlicenciaConduir()
								.getTipusLlicencia()
						+ "\n\tData de caducitat: "
						+ sdf.format(conductorVehicle
								.getLlicenciaConduir()
								.getDataCaducitat().getTime()));
			}

		}

		return repositoryToString.toString();
	}
/**
 * 
 * @param sc
 * @return Wheel, roda amb informacio de marca i diametre
 * 
 * Metode per introduri les dates duna roda
 */
	private Wheel inputRoda(Scanner sc) {
		System.out.print("\n\t\tIntrodueix marca roda: ");
		String marcaRoda = sc.nextLine();

		double diametreRoda = validarDiametreRoda(sc);
		Wheel rodaTrasera = new Wheel(marcaRoda, diametreRoda);
		return rodaTrasera;
	}
/**
 * 
 * @param sc
 * @return double, diametre validat
 * 
 * Torna diametre dins del rang demanat
 */
	private static double validarDiametreRoda(Scanner sc) {
		double i = 0.0;
		while (true) {
			// Introduir matricula
			System.out.println(
					"\t\tIntrodueix diametre roda del vehicle(entre 0.4 i 4): ");
			String vehicleDiametreRoda = sc.nextLine();
			// Controlar entrada de la matricula que sigui correcta
			if (Pattern.matches(PATRODIAMETRERODA,
					vehicleDiametreRoda)) {
				i = Double.valueOf(vehicleDiametreRoda);
				if (0.4 <= i && i <= 4) {
					break;
				}

			} else {
				System.out.println(
						"\tError!. Entrada no valida. Torna a provar");
			}

		}
		return i;
	}

}
