package com.sarp.jsons;

public class JSONDisplay {
	
	String displayId;
	String lastUpdated;
	//List<JSONSector> sectores;
	
	public JSONDisplay(){}
	
	public JSONDisplay(String displayId, String lastUpdated){
		this.displayId = displayId;
		this.lastUpdated = lastUpdated;
	}
	
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getDisplayId() {
		return displayId;
	}
	/*public List<JSONSector> getSectores() {
		return sectores;
	}
	public void setSectores(List<JSONSector> sectores) {
		this.sectores = sectores;
	}*/
	public void setDisplayId(String displayId) {
		this.displayId = displayId;
	}
	
	 @Override
	    public String toString() {
		 String displayId = this.displayId != null? this.displayId.toString() : "null";
	     String lastUpdated = this.lastUpdated != null ? this.lastUpdated : "null";
		 return "{\n"
	        		+ "\"displayId\":" + displayId  + ",\n"
	        		+ "\"lastUpdated\":\"" + lastUpdated + "\"\n"
	     			+ "}";
	    }
}
