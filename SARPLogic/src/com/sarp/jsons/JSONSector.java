package com.sarp.jsons;

//import java.util.List;

public class JSONSector {

	String sectorId;
	String nombre;
	String ruta;

	public JSONSector(){}


	 public JSONSector(String sectorId, String nombre, String ruta) {
		super();
		this.sectorId = sectorId;
		this.nombre = nombre;
		this.ruta = ruta;
	}



	public String getSectorId() {
		return sectorId;
	}



	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getRuta() {
		return ruta;
	}



	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	

	
	@Override
	    public String toString() {

		 	String sectorId = this.sectorId != null? this.sectorId : "null";
			String nombre = this.nombre!= null? this.nombre : "null"; 
			String ruta = this.ruta!= null? this.ruta.toString() : "null"; 

		 
	        return "{\n"
	        		+ "\"sectorId\":\""+sectorId+"\",\n"
	        		+ "\"nombre\":\""+nombre+"\",\n"
	        		+ "\"ruta\":\""+ ruta+"\",\n"
	        		+ "}";
	    }
	
}

