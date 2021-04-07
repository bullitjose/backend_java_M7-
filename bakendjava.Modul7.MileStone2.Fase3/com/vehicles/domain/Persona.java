package com.vehicles.domain;

import java.util.Calendar;

public abstract class Persona {

	protected int id;

	protected String nom;
	protected String cognoms;
	protected Calendar dataNaixement;

	private int COUNTERMEMBERS = 1;

	protected Persona(String nom, String cognoms,
			Calendar dataNaixement2) throws Exception {
		if (nom.equals(""))
			throw new Exception();
		if (cognoms.equals(""))
			throw new Exception();
		if (dataNaixement2.equals(null))
			throw new Exception();

		this.nom = nom;
		this.cognoms = cognoms;
		this.dataNaixement = dataNaixement2;
		id = generarCodi();

	}

	/**
	 * 
	 * @return int, codi creat per la persona
	 */
	public int generarCodi() {
		return COUNTERMEMBERS++;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public Calendar getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(Calendar dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

	public int getCOUNTERMEMBERS() {
		return COUNTERMEMBERS;
	}

	public void setCOUNTERMEMBERS(int counterMembers) {
		COUNTERMEMBERS = counterMembers;
	}

}
