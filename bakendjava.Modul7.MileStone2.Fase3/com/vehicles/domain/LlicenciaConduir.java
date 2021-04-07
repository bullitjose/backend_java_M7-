package com.vehicles.domain;

import java.util.Calendar;

public class LlicenciaConduir {
	private int id;
	private int COUNTERMEMBERS = 1;
	private String tipusLlicencia;
	private String nomComplet;
	private Calendar dataCaducitat;

	public LlicenciaConduir(String tipusLlicencia, String nomComplet,
			Calendar dataCaducitat) {

		this.tipusLlicencia = tipusLlicencia;
		this.nomComplet = nomComplet;
		this.dataCaducitat = dataCaducitat;

		id = generarCodi();
	}
/**
 * 
 * @return int, codi generat per la Llicencia conduir
 */
	public int generarCodi() {
		return COUNTERMEMBERS++;

	}

	public int getId() {
		return id;
	}

	public String getTipusLlicencia() {
		return tipusLlicencia;
	}

	public void setTipusLlicencia(String tipusLlicencia) {
		this.tipusLlicencia = tipusLlicencia;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public Calendar getDataCaducitat() {
		return dataCaducitat;
	}

	public void setDataCaducitat(Calendar dataCaducitat) {
		this.dataCaducitat = dataCaducitat;
	}

}
