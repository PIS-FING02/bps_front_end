package com.sarp.jsons;

public class JSONDisplay {
	
	Integer displayId;
	String rutaArchivo;
	//List<JSONSector> sectores;
	
	public JSONDisplay(){}
	
	public JSONDisplay(Integer displayId, String rutaArchivo){
		this.displayId = displayId;
		this.rutaArchivo = rutaArchivo;
	}
	
	public String getRutaArchivo() {
		return rutaArchivo;
	}
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	public Integer getDisplayId() {
		return displayId;
	}
	/*public List<JSONSector> getSectores() {
		return sectores;
	}
	public void setSectores(List<JSONSector> sectores) {
		this.sectores = sectores;
	}*/
	public void setDisplayId(Integer displayId) {
		this.displayId = displayId;
	}
	
	 @Override
	    public String toString() {
	        return "{\n"
	        		+ "\"displayId\":" + this.displayId + ",\n"
	        		+ "\"rutaArchivo\":\"" + this.rutaArchivo + "\"\n"
	     			+ "}";
	    }
}
