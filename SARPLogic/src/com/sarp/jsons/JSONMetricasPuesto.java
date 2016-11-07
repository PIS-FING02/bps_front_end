package com.sarp.jsons;

public class JSONMetricasPuesto {

	private String nombreMaquina;
    private String usuarioAtencion;
    private String estado;
    private String timeSpent;
    private String lastUpdated;
    private String dateCreated;

	public JSONMetricasPuesto(){}
	
	public JSONMetricasPuesto(String nombreMaquina, String usuarioAtencion, String estado, String timeSpent, String lastUpdated, String dateCreated) {
		this.nombreMaquina = nombreMaquina;
		this.usuarioAtencion = usuarioAtencion;
		this.estado = estado;
		this.timeSpent = timeSpent;
		this.lastUpdated = lastUpdated;
		this.dateCreated = dateCreated;
	}
	
	 public String getNombreMaquina() {
		return nombreMaquina;
	}

	public void setNombreMaquina(String nombreMaquina) {
		this.nombreMaquina = nombreMaquina;
	}
	
	public String getUsuarioAtencion() {
		return usuarioAtencion;
	}

	public void setUsuarioAtencion(String usuarioAtencion) {
		this.usuarioAtencion = usuarioAtencion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(String timeSpent) {
		this.timeSpent = timeSpent;
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

	@Override
    public String toString() {
	 	String nombreMaquina = this.nombreMaquina!= null ? this.nombreMaquina: "null";
	 	String usuarioAtencion = this.usuarioAtencion!= null ? this.usuarioAtencion: "null";
	 	String estado = this.estado!= null ? this.estado: "null";
	 	String timeSpent = this.timeSpent!= null ? this.timeSpent: "null";
	 	String lastUpdated = this.lastUpdated!= null ? this.lastUpdated: "null";
	 	String dateCreated = this.dateCreated!= null ? this.dateCreated: "null";
	 	
        return "{\n"
			+ "\"nombreMaquina\":\"" + nombreMaquina + "\",\n"
			+ "\"usuarioAtencion\":\"" + usuarioAtencion + "\",\n"
			+ "\"estado\":\"" + estado + "\",\n"
			+ "\"timeSpent\":\"" + timeSpent + "\",\n"
			+ "\"lastUpdated\":\"" + lastUpdated + "\",\n"
			+ "\"dateCreated\":\"" + dateCreated + "\",\n"
			+ "}";
    }
}
