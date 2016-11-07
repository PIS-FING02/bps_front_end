package com.sarp.jsons;

public class JSONMetricasNumero {

	String externalId;
	
	public JSONMetricasNumero(){}

	public JSONMetricasNumero(String externalId) {
		this.externalId = externalId;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	@Override
    public String toString() {
		String externalId = this.externalId!= null ? this.externalId : "null";
	 	
        return "{\n"
        		+ "\"externalId\":\"" + externalId + "\",\n"
        		+ "}";
    }
}
