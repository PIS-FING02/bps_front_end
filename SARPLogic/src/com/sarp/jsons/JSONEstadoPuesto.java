package com.sarp.jsons;


public class JSONEstadoPuesto {
	
	JSONPuesto puesto;
	JSONNumero numero;
	
	
	public JSONEstadoPuesto(){};
	
	
	
	public JSONEstadoPuesto(JSONPuesto puesto, JSONNumero numero) {
		super();
		this.puesto = puesto;
		this.numero = numero;
	}

	public JSONPuesto getPuesto() {
		return puesto;
	}
	public void setPuesto(JSONPuesto puesto) {
		this.puesto = puesto;
	}
	public JSONNumero getNumero() {
		return numero;
	}
	public void setNumero(JSONNumero numero) {
		this.numero = numero;
	}
	
	
	
}