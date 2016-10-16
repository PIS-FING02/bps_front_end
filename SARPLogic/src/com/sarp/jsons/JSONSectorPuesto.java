package com.sarp.jsons;

public class JSONSectorPuesto {
	
	String sectorId;
	String nombreMaquina;
	
	
	public JSONSectorPuesto(String sectorId, String nombreMaquina) {
		super();
		this.sectorId = sectorId;
		this.nombreMaquina = nombreMaquina;
	}
	public String getSectorId() {
		return sectorId;
	}
	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}
	public String getNombreMaquina() {
		return nombreMaquina;
	}
	public void setNombreMaquina(String nombreMaquina) {
		this.nombreMaquina = nombreMaquina;
	}
	
	@Override
    public String toString() {

	 	String sectorId = this.sectorId != null? this.sectorId : "null";
		String tramiteId = this.nombreMaquina!= null? this.nombreMaquina : "null"; 

	 
        return "{\n"
        		+ "\"sectorId\":\""+sectorId+"\",\n"
        		+ "\"nombreMaquina\":\""+tramiteId+"\"\n"
        		+ "}";
    }
	
	

}
