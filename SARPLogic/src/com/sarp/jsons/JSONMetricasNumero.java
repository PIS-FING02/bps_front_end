package com.sarp.jsons;

public class JSONMetricasNumero {

	Integer internalId;
    String externalId;
    String estado;
    String codigoTramite;
    String rutaSector;
    String usuarioAtencion;
    String lastUpdated;
    String dateCreated;
	
	public JSONMetricasNumero(){}

	public JSONMetricasNumero(Integer internalId, String externalId, String estado, String codigoTramite, String rutaSector, 
			String usuarioAtencion, String lastUpdated, String dateCreated) {
		this.internalId = internalId;
		this.externalId = externalId;
		this.estado = estado;
		this.codigoTramite = codigoTramite;
		this.rutaSector = rutaSector;
		this.usuarioAtencion = usuarioAtencion;
		this.lastUpdated = lastUpdated;
		this.dateCreated = dateCreated;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
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

	public String getCodigoTramite() {
		return codigoTramite;
	}

	public void setCodigoTramite(String codigoTramite) {
		this.codigoTramite = codigoTramite;
	}

	public String getRutaSector() {
		return rutaSector;
	}

	public void setRutaSector(String rutaSector) {
		this.rutaSector = rutaSector;
	}

	public String getUsuarioAtencion() {
		return usuarioAtencion;
	}

	public void setUsuarioAtencion(String usuarioAtencion) {
		this.usuarioAtencion = usuarioAtencion;
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
		String internalId = this.internalId!= null ? this.internalId.toString() : "null";
		String externalId = this.externalId!= null ? this.externalId : "null";
		String estado = this.estado!= null ? this.estado : "null";
		String codigoTramite = this.codigoTramite!= null ? this.codigoTramite : "null";
	    String rutaSector = this.rutaSector!= null ? this.rutaSector : "null";
	    String usuarioAtencion = this.usuarioAtencion!= null ? this.usuarioAtencion : "null";
	    String lastUpdated = this.lastUpdated!= null ? this.lastUpdated : "null";
	    String dateCreated = this.dateCreated!= null ? this.dateCreated : "null";
	    
        return "{\n"
        		+ "\"internalId\":\"" + internalId + "\",\n"
        		+ "\"externalId\":\"" + externalId + "\",\n"
        		+ "\"estado\":\"" + estado + "\",\n"
        		+ "\"codigoTramite\":\"" + codigoTramite + "\",\n"
        		+ "\"rutaSector\":\"" + rutaSector + "\",\n"
        		+ "\"usuarioAtencion\":\"" + usuarioAtencion + "\",\n"
        		+ "\"lastUpdated\":\"" + lastUpdated + "\",\n"
        		+ "\"dateCreated\":\"" + dateCreated + "\",\n"
        		
        		+ "}";
    }
}
