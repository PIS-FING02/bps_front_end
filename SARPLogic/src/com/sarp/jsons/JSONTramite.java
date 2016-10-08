package com.sarp.jsons;

//import java.util.List;


public class JSONTramite {

	Integer codigo;
	String nombre;

	//List<JSONPuesto> puestos;
	//List<JSONSector> sectores;
	
	public JSONTramite(){}
	
	public JSONTramite(Integer cod, String nom){
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
	public Integer getCodigo() {
		return codigo;

	}

	public void setCodigo(Integer codigo) {
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
	        return "{\n"
	        		+ "\"codigo\":" + this.codigo + ",\n"
	        		+ "\"nombre\":\"" + this.nombre + "\"\n"
	     			+ "}";
	    }
}
