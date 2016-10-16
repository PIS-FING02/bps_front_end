package com.sarp.jsons;

public class JSONSectorTramite {
	
	String sectorId;
	String tramiteId;
	
	
	
	
	public JSONSectorTramite(String sectorId, String tramiteId) {
		super();
		this.sectorId = sectorId;
		this.tramiteId = tramiteId;
	}
	public String getSectorId() {
		return sectorId;
	}
	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}
	public String getTramiteId() {
		return tramiteId;
	}
	public void setTramiteId(String tramiteId) {
		this.tramiteId = tramiteId;
	}
	
	@Override
    public String toString() {

	 	String sectorId = this.sectorId != null? this.sectorId : "null";
		String tramiteId = this.tramiteId!= null? this.tramiteId : "null"; 

	 
        return "{\n"
        		+ "\"sectorId\":\""+sectorId+"\",\n"
        		+ "\"tramiteId\":\""+tramiteId+"\"\n"
        		+ "}";
    }

	
	

}
