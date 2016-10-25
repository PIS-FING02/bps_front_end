package com.sarp.jsons;

//import java.util.List;


public class JSONTramite {

	String codigo;
	String nombre;

	//List<JSONPuesto> puestos;
	//List<JSONSector> sectores;
	
	public JSONTramite(){}
	
	public JSONTramite(String cod, String nom){
		this.codigo = cod;
		this.nombre = nom;
	}

	/*public List<JSONPuesto> getPuestos() {
		return puestos;
	}

	public void setPuestos(List<JSONPuesto> puestos) {
		this.puestos = puestos;
	}

	public List<JSONSector> getSectores() {
		return sectores;
	}

	public void setSectores(List<JSONSector> sectores) {
		this.sectores = sectores;
	}*/
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
	
	 @Override
	    public String toString() {
		 	String codigo = this.codigo!= null ? this.codigo : "null";
		 	String nombre = this.nombre!= null ? this.nombre : "null";
		 	
	        return "{\n"
	        		+ "\"codigo\":\"" + codigo + "\",\n"
	        		+ "\"nombre\":\"" + nombre + "\"\n"
	     			+ "}";
	    }
}
