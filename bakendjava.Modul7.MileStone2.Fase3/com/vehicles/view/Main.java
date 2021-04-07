package com.vehicles.view;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vehicles.application.TransitController;
import com.vehicles.domain.LlicenciaConduir;

public class Main {

	private static final String CAMIO = "camio";
	private static final String MOTO = "moto";
	private static TransitController transitController = new TransitController();
	private static final String PATRONLLICENCIA = "[ABC]";
	private static final String COTXE = "cotxe";
	private static String opcioVehicle = "";
	private static int maxValidYr = 2150;
	private static int minValidYr = 1900;

	public static void main(String[] args) throws Exception {

		final String OPCIO_PATTERN = "[1-6]";
		final Pattern opcioPattern = Pattern.compile(OPCIO_PATTERN);

		Scanner sc = new Scanner(System.in);

		String choice = "6";
		while (choice.equalsIgnoreCase("6")) {

			// Introducir LlicenciaConduir
			System.out.println(
					"\tIntrodueix opcio\n\t\t1-Alta Titular vehicle"
							+ " \n\t\t2-Alta conductor vehicle"
							+ " \n\t\t3-Alta vehicle \n\t\t4-Mostrar titulars"
							+ " \n\t\t5-Mostrar vehicles \n\t\t6-Acabar");

			// LLegir string amb nextLine dona menys problemes
			String opcio = sc.nextLine();
			Matcher matcher = opcioPattern.matcher(opcio);
			if (matcher.matches()) {
				switch (opcio) {
				case "1":

					String tipusLlicencia = crearTitular(sc);
					crearVehicle(sc, tipusLlicencia);
					System.out.println(
							"\tVols que el titular sigui el conductor del cotxe(s/n)?");

					// while (true) {
					while (sc.hasNext()) {
						String resposta = sc.nextLine().trim()
								.toLowerCase();
						if (resposta.equalsIgnoreCase("s")) {
							break;
						} else if (resposta.equalsIgnoreCase("n")) {
							crearConductor(sc, tipusLlicencia);
							break;
						} else {
							System.out.println(
									"Torna a intentarho, respon s/n");
						}
					}

				case "2":

					crearConductor(sc);

					break;

				case "3":

					crearVehicle(sc);

					break;

				case "4":

					String allPersones = transitController
					.getTotesPersones();
					System.out.println(
							"Persones: " + allPersones + " \n");

					break;

				case "5":

					String allVehicles = transitController
					.getAllVehicles();
					System.out.println("Vehicles: " + " \n"
							+ allVehicles + " \n");

					break;

				case "6":
					sc.close();
					System.exit(0);

				default:
					// break;
					System.out.println(
							"Entrada no valida. Torna a provar");

				}

			}

		}

	}

	/**
	 * @param sc
	 * @throws Exception
	 * 
	 *                   Metode per crear un vehicle recull i valida dades i crida a
	 *                   TransitController de
	 *                   com.vehicles.application.TransitController per crear el
	 *                   vehicle
	 */
	private static void crearVehicle(Scanner sc) throws Exception {
		String vehicleMatricula = "";

		System.out.println(
				"Vols crear un cotxe, una moto o un camio?(cotxe/moto/camio/sortir): ");

		boolean opcio = false;

		// escullVehicle(sc, opcio);

		if ("sortir".equals(escullVehicle(sc, opcio))) {
			opcio = true;
		} else {
			// Introduir matricula

			vehicleMatricula = validarMatricula(sc, vehicleMatricula);

			// Introduir marca
			System.out.println("Introdueix marca del vehicle: ");
			String vehicleMarca = sc.nextLine();
			// Introduir color
			System.out.println("Introdueix color del vehicle: ");
			String vehicleColor = sc.nextLine();

			System.out.println(
					"imprimir opcioVehicle: " + opcioVehicle);
			if (COTXE.equals(opcioVehicle)) {
				transitController.createCoche(vehicleMatricula,
						vehicleMarca, vehicleColor);

			}

			if (MOTO.equals(opcioVehicle)) {
				System.out.println(MOTO);
				transitController.createMoto(vehicleMatricula,
						vehicleMarca, vehicleColor);
			}
			if (CAMIO.equals(opcioVehicle)) {
				System.out.println(CAMIO);
				transitController.createCamio(vehicleMatricula,
						vehicleMarca, vehicleColor);
			}
		}
	}

	/**
	 * @param sc
	 * @throws Exception
	 * 
	 *                   Metode per crear vehicles, li passem parametre
	 *                   tipusLlicencia per comparar si es compatible amb vehicle
	 *                   que es vol crear recull i valida dades i crida a
	 *                   TransitController de
	 *                   com.vehicles.application.TransitController per crear el
	 *                   vehicle
	 */
	private static void crearVehicle(Scanner sc,
			String tipusLlicencia) throws Exception {
		String vehicleMatricula = "";

		System.out.println(
				"Vols crear un cotxe, una moto o un camio?(cotxe/moto/camio/sortir): ");

		boolean opcio = false;

		if ("sortir"
				.equals(escullVehicle(sc, opcio, tipusLlicencia))) {
			opcio = true;
		} else {

			// Introduir matricula

			vehicleMatricula = validarMatricula(sc, vehicleMatricula);

			// Introduir marca
			System.out.println("Introdueix marca del vehicle: ");
			String vehicleMarca = sc.nextLine();
			// Introduir color
			System.out.println("Introdueix color del vehicle: ");
			String vehicleColor = sc.nextLine();

			// FASE 1. 2 Crear el cotxe amb les dades anteriors.
			// -------------------------

			System.out.println(
					"Imprimir opcioVehicle: " + opcioVehicle);
			if (COTXE.equals(opcioVehicle)) {
				transitController.createCoche(vehicleMatricula,
						vehicleMarca, vehicleColor);
				System.out.println(COTXE);
			}

			if (MOTO.equals(opcioVehicle)) {
				System.out.println(MOTO);
				transitController.createMoto(vehicleMatricula,
						vehicleMarca, vehicleColor);
			}
			if (CAMIO.equals(opcioVehicle)) {
				System.out.println(CAMIO);
				transitController.createCamio(vehicleMatricula,
						vehicleMarca, vehicleColor);
			}
		}
	}

	/**
	 * @param sc
	 * @throws Esception
	 * @return tipusLlicencia
	 * 
	 *         Metode per crear un titular de vehicle recull i valida dades i crida
	 *         a TransitController de com.vehicles.application.TransitController per
	 *         crear el titular
	 */
	private static String crearTitular(Scanner sc) throws Exception {

		String resposta;
		String tipusLlicencia = null;
		Calendar llicenciaDataCaducitat;
		final String LLICENCIA_PATTERN = PATRONLLICENCIA;
		final Pattern llicenciaPattern = Pattern
				.compile(LLICENCIA_PATTERN);
		System.out
		.println("Vols crear un titular de vehicle?(s/n): ");
		while (true) {
			resposta = sc.nextLine().trim().toLowerCase();
			if (resposta.equals("s")) {

				// Introduir Nom

				System.out.println("\tIntrodueix nom del Titular: ");
				String titularNom = sc.nextLine();

				// Introduir Cognom
				System.out
				.println("\tIntrodueix cognom del Titular: ");
				String titularCognom = sc.nextLine();

				// Introduir data naixement
				System.out.println(
						"\tIntrodueix data naixement del Titular: ");
				Calendar titularDataNaixement = dataCalendari(sc);

				while (true) {
					// Introducir LlicenciaConduir
					System.out.println(
							"\tIntrodueix llicencia de conduir:\n\t\tA-Llicencia de motos"
									+ " \n\t\tB-Llicencia de cotxes \n\t\tC-Llicencia de camions ");

					// LLegir string amb nextLine dona menys problemes
					tipusLlicencia = sc.nextLine();
					Matcher matcher = llicenciaPattern
							.matcher(tipusLlicencia);
					if (matcher.matches()) {

						break;
					} else {
						System.out.println(
								"Llicencia en format incorrece.Torna a provar");
					}

				}
				if ("A".equals(tipusLlicencia)) {
					tipusLlicencia = MOTO;
				}
				if ("B".equals(tipusLlicencia)) {
					tipusLlicencia = COTXE;
				}
				if ("C".equals(tipusLlicencia)) {
					tipusLlicencia = CAMIO;
				}
				// Introducir Nom de la llicencia, el mateix que el titular
				String llicenciaNomComplet = titularNom + " "
						+ titularCognom;

				while (true) {
					// Introduir data Caducitat de la llicencia
					System.out.println(
							"\tIntrodueix data caducitat de la llicencia");
					llicenciaDataCaducitat = dataCalendari(sc);
					// Calcular data actual
					Calendar today = Calendar.getInstance();
					// Comparing the time
					int val = today.compareTo(llicenciaDataCaducitat);
					if (val < 0) {
						break;
					} else {
						System.out.println(
								"Data llicencia caducada.Torna a provar");
					}
				}
				// Crear Objecte LlicenciaConduir
				LlicenciaConduir titularLlicencia = new LlicenciaConduir(
						tipusLlicencia, llicenciaNomComplet,
						llicenciaDataCaducitat);
				// Introduir Asseguranca
				System.out.println(
						"\tIntrodueix Asseguranca del Titular: ");
				String titularSeguro = sc.nextLine();
				// Introduir Asseguranca
				System.out.println("\tTens garatge propi:(s/n) ");
				String titularTeGaratge = sc.nextLine();

				// Crear Titular, passar parametres a TransitController
				transitController.createTitularVehicle(titularNom,
						titularCognom, titularDataNaixement,
						titularLlicencia, titularSeguro,
						titularTeGaratge);

				break;
			} else if (resposta.equals("n")) {
				break;
			} else {
				System.out.println("Torna a intertarho, respon s/n");
			}
		}
		return tipusLlicencia;
	}

	/**
	 * @param sc
	 * 
	 *           Metode per crear Conductor recull i valida dades i crida a
	 *           TransitController de com.vehicles.application.TransitController per
	 *           crear el conductor
	 */
	private static void crearConductor(Scanner sc) throws Exception {
		String resposta;
		String tipusLlicencia;
		Calendar llicenciaDataCaducitat;
		final String LLICENCIA_PATTERN = PATRONLLICENCIA;
		final Pattern llicenciaPattern = Pattern
				.compile(LLICENCIA_PATTERN);
		System.out.println(
				"Vols crear un conductor de vehicle?(s/n): ");

		while (sc.hasNext()) {
			resposta = sc.nextLine().trim().toLowerCase();
			if (resposta.equals("s")) {

				// Introduir Nom

				System.out
				.println("\tIntrodueix nom del conductor: ");
				String titularNom = sc.nextLine();

				// Introduir Cognom
				System.out.println(
						"\tIntrodueix cognom del conductor: ");
				String titularCognom = sc.nextLine();

				// Introduir data naixement
				System.out.println(
						"\tIntrodueix data naixement del conductor: ");
				Calendar titularDataNaixement = dataCalendari(sc);

				while (true) {
					// Introducir LlicenciaConduir
					System.out.println(
							"\tIntrodueix llicencia de conduir:\n\t\tA-Llicencia de motos"
									+ " \n\t\tB-Llicencia de cotxes \n\t\tC-Llicencia de camions ");

					// LLegir string amb nextLine dona menys problemes
					tipusLlicencia = sc.nextLine();
					Matcher matcher = llicenciaPattern
							.matcher(tipusLlicencia);
					if (matcher.matches()) {

						break;
					} else {
						System.out.println(
								"Llicencia en format incorrece.Torna a provar");
					}

				}
				if ("A".equals(tipusLlicencia)) {
					tipusLlicencia = MOTO;
				}
				if ("B".equals(tipusLlicencia)) {
					tipusLlicencia = COTXE;
				}
				if ("C".equals(tipusLlicencia)) {
					tipusLlicencia = CAMIO;
				}
				// Introducir Nom de la llicencia, el mateix que el titular
				String llicenciaNomComplet = titularNom + " "
						+ titularCognom;

				while (true) {
					// Introduir data Caducitat de la llicencia
					System.out.println(
							"\tIntrodueix data caducitat de la llicencia");
					llicenciaDataCaducitat = dataCalendari(sc);
					// Calcular data actual
					Calendar today = Calendar.getInstance();
					// Comparing the time
					int val = today.compareTo(llicenciaDataCaducitat);
					if (val < 0) {
						break;
					} else {
						System.out.println(
								"Data llicencia caducada.Torna a provar");
					}
				}
				// Crear Objecte LlicenciaConduir
				LlicenciaConduir titularLlicencia = new LlicenciaConduir(
						tipusLlicencia, llicenciaNomComplet,
						llicenciaDataCaducitat);

				// Crear Titular, passar parametres a PersonesController
				transitController.createConductorVehicle(titularNom,
						titularCognom, titularDataNaixement,
						titularLlicencia);

				break;
			} else if (resposta.equals("n")) {
				break;
			} else {
				System.out.println("Torna a intertarho, respon s/n");
			}
		}
	}

	/**
	 * @param sc
	 * @param tipusLlicenciaTitular
	 * 
	 *                              Metode per crearConductor de vehicle, se li
	 *                              passa per parametre tipusLlicenciaTitular per
	 *                              comparar si conductor pot portar el vehicle que
	 *                              li assignem recull i valida dades i crida a
	 *                              TransitController de
	 *                              com.vehicles.application.TransitController per
	 *                              crear el conductor
	 */
	private static void crearConductor(Scanner sc,
			String tipusLlicenciaTitular) throws Exception {
		String resposta;
		String tipusLlicencia;
		Calendar llicenciaDataCaducitat;
		final String LLICENCIA_PATTERN = PATRONLLICENCIA;
		final Pattern llicenciaPattern = Pattern
				.compile(LLICENCIA_PATTERN);
		System.out.println(
				"Vols crear un conductor de vehicle?(s/n): ");
		while (true) {
			resposta = sc.nextLine().trim().toLowerCase();
			if (resposta.equals("s")) {

				// Introduir Nom

				System.out
				.println("\tIntrodueix nom del conductor: ");
				String titularNom = sc.nextLine();

				// Introduir Cognom
				System.out.println(
						"\tIntrodueix cognom del conductor: ");
				String titularCognom = sc.nextLine();

				// Introduir data naixement
				System.out.println(
						"\tIntrodueix data naixement del conductor: ");
				Calendar titularDataNaixement = dataCalendari(sc);

				while (true) {
					// Introducir LlicenciaConduir
					System.out.println(
							"\tIntrodueix llicencia de conduir:\n\t\tA-Llicencia de motos"
									+ " \n\t\tB-Llicencia de cotxes \n\t\tC-Llicencia de camions");

					// LLegir string amb nextLine dona menys problemes
					tipusLlicencia = sc.nextLine();
					Matcher matcher = llicenciaPattern
							.matcher(tipusLlicencia);
					if (matcher.matches()) {
						if ("A".equals(tipusLlicencia)) {
							tipusLlicencia = MOTO;
						}
						if ("B".equals(tipusLlicencia)) {
							tipusLlicencia = COTXE;
						}
						if ("C".equals(tipusLlicencia)) {
							tipusLlicencia = CAMIO;
						}
						// comparar tipusLlicencia del conductor i tipusLlicenciaTitular del titular del
						// cotxe
						if (tipusLlicencia
								.equals(tipusLlicenciaTitular)) {

							break;
						} else {
							System.out.println(
									"Llicencia del titular del vehicle("
											+ tipusLlicenciaTitular
											+ ") i del conductor no coincideixen.Torna a provar");
						}

					} else {
						System.out.println(
								"Llicencia en format incorrece.Torna a provar");
					}

				}

				// Introducir Nom de la llicencia, el mateix que el titular
				String llicenciaNomComplet = titularNom + " "
						+ titularCognom;

				while (true) {
					// Introduir data Caducitat de la llicencia
					System.out.println(
							"\tIntrodueix data caducitat de la llicencia");
					llicenciaDataCaducitat = dataCalendari(sc);
					// Calcular data actual
					Calendar today = Calendar.getInstance();
					// Comparar dates
					int val = today.compareTo(llicenciaDataCaducitat);
					if (val < 0) {
						break;
					} else {
						System.out.println(
								"Data llicencia caducada.Torna a provar");
					}
				}
				// Crear Objecte LlicenciaConduir
				LlicenciaConduir titularLlicencia = new LlicenciaConduir(
						tipusLlicencia, llicenciaNomComplet,
						llicenciaDataCaducitat);

				// Crear Titular, passar parametres a PersonesController
				transitController.createConductorVehicle(titularNom,
						titularCognom, titularDataNaixement,
						titularLlicencia);

				break;
			} else if (resposta.equals("n")) {
				break;
			} else {
				System.out.println("Torna a intertarho, respon s/n");
			}
		}
	}

	/**
	 * @param sc
	 * @param opcio
	 * @param tipusLlicencia
	 * @return opcioVehicle
	 * 
	 *         Metode per escollir vehicle, es llenca des de metode crearTitular que
	 *         li passa el tipusLlicencia del titular per comparar
	 */
	private static String escullVehicle(Scanner sc, boolean opcio,
			String tipusLlicencia) {

		do {

			String resposta = sc.nextLine();

			if (COTXE.equals(resposta)) {
				if (COTXE.equals(tipusLlicencia)) {
					System.out.println(
							"\tHas escollit crear un cotxe i tens llicencia per conduir");
					opcioVehicle = COTXE;
					opcio = true;
				} else {
					System.out.println(
							"Error!. No tens llicencia per conduir cotxes, tens llicencia per "
									+ tipusLlicencia
									+ "\n Torna a provar(cotxe/moto/camio/sortir)");
				}

			} else if (MOTO.equals(resposta)) {
				if (MOTO.equals(tipusLlicencia)) {
					System.out.println(
							"\tHas escollit crear una moto i tens llicencia per conduirla");
					opcioVehicle = MOTO;
					opcio = true;
				} else {
					System.out.println(
							"Error!. No tens llicencia per conduri moto, tens llicencia per "
									+ tipusLlicencia
									+ "\n Torna a provar(cotxe/moto/camio/sortir)");
				}

			} else if (CAMIO.equals(resposta)) {
				if (CAMIO.equals(tipusLlicencia)) {
					System.out
					.println("\tHas escollit crear un camio");
					opcioVehicle = CAMIO;
					opcio = true;
				} else {
					System.out.println(
							"Error!. No tens llicencia per conduir un camio, tens llicencia per "
									+ tipusLlicencia
									+ "\n Torna a provar(cotxe/moto/camio/sortir)");
				}

			} else if ("sortir".equals(resposta)) {

				System.out.println("\tHas escollit sortir");
				opcioVehicle = "sortir";
				opcio = true;
			} else {
				System.out.println(
						"Error!. Entrada no valida.Torna a provar(cotxe/moto/camio/sortir)");

			}

		} while (!opcio);
		return opcioVehicle;

	}

	/**
	 * @param
	 * @param sc
	 * @param opcio
	 * @return opcioVehicle
	 * 
	 *         Metode amb menu per escollir vehicle
	 */
	private static String escullVehicle(Scanner sc, boolean opcio) {

		do {

			String resposta = sc.nextLine();

			if (COTXE.equals(resposta)) {
				System.out.println("\tHas escollit crear un cotxe");
				opcioVehicle = COTXE;
				opcio = true;

			} else if (MOTO.equals(resposta)) {
				System.out.println("\tHas escollit crear una moto");
				opcioVehicle = MOTO;
				opcio = true;

			} else if (CAMIO.equals(resposta)) {
				System.out.println("\tHas escollit crear un camio");
				opcioVehicle = CAMIO;
				opcio = true;

			} else if ("sortir".equals(resposta)) {
				System.out.println("\tHas escollit sortir");
				opcioVehicle = "sortir";
				opcio = true;

			} else {
				System.out.println(
						"Error!. Entrada no valida.Torna a provar(cotxe/moto/camio/sortir)");

			}

		} while (!opcio);
		return opcioVehicle;
	}

	/**
	 * @param sc
	 * @param vehicleMatricula
	 * @return vehicleMatricula
	 * 
	 *         Metode per validar Matricula introduida, ha destar formada per
	 *         4lletres i 2 o 3 nombres
	 */
	private static String validarMatricula(Scanner sc,
			String vehicleMatricula) {
		while (true) {
			// Introduir matricula
			System.out.println(
					"Introdueix matricula del cotxe(4 lletres, i entre 2 i 3 nº): ");
			vehicleMatricula = sc.nextLine();
			// Controlar entrada de la matricula que sigui correcta,4 numeros,
			// i entre 2 i 3 lletres
			if (Pattern.matches("([a-zA-Z]{4})([0-9]{2,3})",
					vehicleMatricula)) {
				break;
			} else {
				System.out.println(
						"Error!. Entrada no valida. Torna a provar");
			}

		}
		return vehicleMatricula;
	}

	/**
	 * 
	 * @param any
	 * @return treu si any es trapas
	 * 
	 *         Metode per validar any de traspas
	 */
	// Return true si any de traspas es valid
	static boolean esTraspas(int any) {
		// Return true si any es multiple de 4 i no de 100
		// o si any es multiple de 400
		return (((any % 4 == 0) && (any % 100 != 0))
				|| (any % 400 == 0));
	}

	/**
	 * 
	 * @param d
	 * @param m
	 * @param y
	 * @return true, si la data existeix
	 * 
	 *         Metode per validar data
	 */

	static boolean isValidDate(int d, int m, int y) {
		// False, si any , mes i dia no estan en rang correcte
		if (y > maxValidYr || y < minValidYr)
			return false;
		if (m < 1 || m > 12)
			return false;
		if (d < 1 || d > 31)
			return false;

		// Tractar febrer per any de traspas
		if (m == 2) {
			if (esTraspas(y))
				return (d <= 29);
			else
				return (d <= 28);
		}

		// Abril, juny, setembre i novembre
		// tenen 30 o menys dies
		if (m == 4 || m == 6 || m == 9 || m == 11)
			return (d <= 30);

		return true;
	}

	/**
	 * 
	 * @param sc
	 * @return calendar
	 * 
	 *         Entrada de dates del calendari
	 * 
	 */
	private static Calendar dataCalendari(Scanner sc) {

		// crear un calendar
		Calendar calendar = Calendar.getInstance();
		// definim el pattern per fer cerques
		final String ANY_PATTERN = "^((?:19|20)[0-9][0-9])$";
		final String MES_PATTERN = "^(0?[1-9]|1[012])$";
		final String DIA_PATTERN = "^(0?[1-9]|[12][0-9]|3[01])$";

		// crear els pattern amb Pattern.compile
		final Pattern anyPattern = Pattern.compile(ANY_PATTERN);
		final Pattern diaPattern = Pattern.compile(DIA_PATTERN);
		final Pattern mesPattern = Pattern.compile(MES_PATTERN);
		int any;
		int mes;
		int dia;

		while (true) {
			// Controlar entrada correcta de lany
			while (true) {
				System.out.println("\tIntrodueix any: ");
				// LLegir string amb nextLine dona menys problemes
				String anyString = sc.nextLine();

				Matcher matcher = anyPattern.matcher(anyString);
				if (matcher.matches()) {
					any = Integer.valueOf(anyString);
					break;
				} else {
					System.out.println(
							"Any en format incorrece.Torna a provar");
				}
			}

			// Controlar entrada del mes
			while (true) {

				System.out.println("\tIntrodueix mes: ");
				// LLegir string amb nextLine dona menys problemes
				String mesString = sc.nextLine();

				Matcher matcher = mesPattern.matcher(mesString);
				if (matcher.matches()) {
					mes = Integer.valueOf(mesString);
					break;
				} else {
					System.out.println(
							"Mes en format incorrece.Torna a provar");
				}
			}
			// Controlar entrada del dia
			while (true) {
				System.out.println("\tIntrodueix dia: ");
				// LLegir string amb nextLine
				String diaString = sc.nextLine();
				Matcher matcher = diaPattern.matcher(diaString);
				if (matcher.matches()) {
					dia = Integer.valueOf(diaString);
					break;
				} else {
					System.out.println(
							"Dia en format incorrece.Torna a provar");
				}
			}

			// Si es una data valida afegir data
			if (isValidDate(dia, mes, any)) {
				// set any, mes i dia
				calendar.set(any, mes, dia);
				break;
			} else {
				System.out.println("Data incorrecta.Torna a provar");
			}

		}
		return calendar;
	}
}
