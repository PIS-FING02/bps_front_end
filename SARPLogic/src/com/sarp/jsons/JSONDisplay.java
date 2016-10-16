package com.sarp.jsons;

public class JSONDisplay {
	
	String displayId;
	//List<JSONSector> sectores;
	
	public JSONDisplay(){}
	
	public JSONDisplay(String displayId){
		this.displayId = displayId;
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
		 return "{\n"
	        		+ "\"idDisplay\":\"" + displayId + "\"\n"
	     			+ "}";
	    }
}
