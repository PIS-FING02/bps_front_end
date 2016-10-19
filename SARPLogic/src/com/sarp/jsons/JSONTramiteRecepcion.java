package com.sarp.jsons;

public class JSONTramiteRecepcion {

	private String tramiteId;
	private String tramiteNombre;
	private String sectorId;
	private String sectorNombre;
	
	public JSONTramiteRecepcion(){}
	
	public JSONTramiteRecepcion(String tramiteId, String tramiteNombre, String sectorId, String sectorNombre){
		this.setTramiteId(tramiteId);
		this.setTramiteNombre(tramiteNombre);
		this.setSectorId(sectorId);
		this.setSectorNombre(sectorNombre);
	}

	public String getSectorNombre() {
		return sectorNombre;
	}

	public void setSectorNombre(String sectorNombre) {
		this.sectorNombre = sectorNombre;
	}

	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public String getTramiteNombre() {
		return tramiteNombre;
	}

	public void setTramiteNombre(String tramiteNombre) {
		this.tramiteNombre = tramiteNombre;
	}

	public String getTramiteId() {
		return tramiteId;
	}

	public void setTramiteId(String tramiteId) {
		this.tramiteId = tramiteId;
	}


	
	 @Override
	    public String toString() {
		 	String tramiteId = this.tramiteId!= null ? this.tramiteId : "null";
		 	String tramiteNombre = this.tramiteNombre!= null ? this.tramiteNombre : "null";
		 	String sectorId = this.sectorId!= null ? this.sectorId : "null";
		 	String sectorNombre = this.sectorNombre!= null ? this.sectorNombre : "null";
		 	
	        return "{\n"
	        		+ "\"tramiteId\":" + tramiteId + ",\n"
	    	        + "\"tramiteNombre\":" + tramiteNombre + ",\n"
	    	    	+ "\"sectorId\":" + sectorId + ",\n"
	        		+ "\"sectorNombre\":\"" + sectorNombre + "\"\n"
	     			+ "}";
	    }
	
}
