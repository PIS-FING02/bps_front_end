package com.sarp.jsons;

public class JSONSectorDisplay {
	
	String sectorId;
	String displayId;
	
	public JSONSectorDisplay(String sectorId, String displayId) {
		this.sectorId = sectorId;
		this.displayId = displayId;
	}

	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public String getDisplayId() {
		return displayId;
	}

	public void setDisplayId(String displayId) {
		this.displayId = displayId;
	}

	@Override
    public String toString() {

	 	String sectorId = this.sectorId != null? this.sectorId : "null";
		String displayId = this.displayId!= null? this.displayId : "null"; 

	 
        return "{\n"
        		+ "\"sectorId\":\""+sectorId+"\",\n"
        		+ "\"displayId\":\""+displayId+"\"\n"
        		+ "}";
    }
	
}
