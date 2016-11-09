package com.sarp.jsons;

public class JSONMetricasNumeroEstado {

	Integer internalId;
    String estado;
    String timeSpent;
    String lastUpdated;
    String dateCreated;
	
	public JSONMetricasNumeroEstado(){}

	public JSONMetricasNumeroEstado(Integer internalId, String estado, String timeSpent, String lastUpdated, String dateCreated) {
		this.internalId = internalId;
		this.estado = estado;
		this.timeSpent = timeSpent;
		this.lastUpdated = lastUpdated;
		this.dateCreated = dateCreated;
	}
	
	public Integer getInternalId() {
		return internalId;
	}

	public void setInternalId(Integer internalId) {
		this.internalId = internalId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(String timeSpent) {
		this.timeSpent = timeSpent;
	}

	@Override
    public String toString() {
		String internalId = this.internalId!= null ? this.internalId.toString() : "null";
		String estado = this.estado!= null ? this.estado : "null";
		String timeSpent = this.timeSpent!= null ? this.timeSpent : "null";
	    String lastUpdated = this.lastUpdated!= null ? this.lastUpdated : "null";
	    String dateCreated = this.dateCreated!= null ? this.dateCreated : "null";
	    
        return "{\n"
        		+ "\"internalId\":\"" + internalId + "\",\n"
        		+ "\"estado\":\"" + estado + "\",\n"
        		+ "\"timeSpent\":\"" + timeSpent + "\",\n"
        		+ "\"lastUpdated\":\"" + lastUpdated + "\",\n"
        		+ "\"dateCreated\":\"" + dateCreated + "\",\n"
        		
        		+ "}";
    }
}
