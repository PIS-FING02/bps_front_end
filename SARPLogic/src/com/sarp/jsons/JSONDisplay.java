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
		 String displayId = this.displayId != null? this.displayId.toString() : "null";
	     String rutaArchivo = this.rutaArchivo != null ? this.rutaArchivo : "null";
		 return "{\n"
	        		+ "\"displayId\":" + displayId  + ",\n"
	        		+ "\"rutaArchivo\":\"" + rutaArchivo + "\"\n"
	     			+ "}";
	    }
}
