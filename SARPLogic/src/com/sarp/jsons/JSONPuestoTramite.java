package com.sarp.jsons;

public class JSONPuestoTramite {

	private String idPuesto;
	private String idTramite;
	
	public JSONPuestoTramite(String idTramite, String idPuesto){
		this.idPuesto = idPuesto;
		this.idTramite = idTramite;
	}
	
	public String getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(String idPuesto) {
		this.idPuesto = idPuesto;
	}
	public String getIdTramite() {
		return idTramite;
	}
	public void setIdTramite(String idTramite) {
		this.idTramite = idTramite;
	}
	
	@Override
    public String toString() {
		
	 	String idPuesto = this.idPuesto != null? this.idPuesto : "null";
		String idTramite = this.idTramite!= null? this.idTramite : "null"; 
	 
        return "{\n"
        		+ "\"tramiteId\":\""+idTramite+"\",\n"
        		+ "\"nombreMaquina\":\""+ idPuesto+"\"\n"
        		+ "}";
    	}
}
