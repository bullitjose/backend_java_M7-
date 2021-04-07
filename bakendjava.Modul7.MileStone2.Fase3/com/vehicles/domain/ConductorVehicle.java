package com.vehicles.domain;

import java.util.Calendar;


public class ConductorVehicle extends Persona {
	protected LlicenciaConduir llicenciaConduir;

	public ConductorVehicle(String nom, String cognoms, Calendar dataNaixement,
			LlicenciaConduir llicenciaConduir) throws Exception {
		super(nom, cognoms, dataNaixement);
		
		if (llicenciaConduir == null)
			throw new Exception();
		this.llicenciaConduir = llicenciaConduir;
	}

	public LlicenciaConduir getLlicenciaConduir() {
		return llicenciaConduir;
	}

	public void setLlicenciaConduir(LlicenciaConduir llicenciaConduir) {
		this.llicenciaConduir = llicenciaConduir;
	}

}
