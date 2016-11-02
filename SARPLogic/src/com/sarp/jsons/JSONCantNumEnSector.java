package com.sarp.jsons;

public class JSONCantNumEnSector {
	
	String codigo;
	String nombre;
	Integer cantNumEspera;

	
	public JSONCantNumEnSector(String codigo, String nombre, Integer cantNumEnEspera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantNumEspera = cantNumEnEspera;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getcantNumEspera() {
		return cantNumEspera;
	}


	public void setCantNumEnEspera(Integer cantNumEspera) {
		this.cantNumEspera = cantNumEspera;
	}


	@Override
	    public String toString() {
		 String codigo = this.codigo != null? this.codigo : "null";
		 String nombre = this.nombre != null? this.nombre : "null";
		 String cantNumEspera = this.cantNumEspera != null? this.cantNumEspera.toString() : "null";
		 return "{\n"
	        		+ "\"codigo\":\"" + codigo + "\"\n"
	        		+ "\"nombre\":\"" + nombre + "\"\n"
	        		+ "\"cantNumEspera\":\"" + cantNumEspera + "\"\n"
	     			+ "}";
	    }
}
