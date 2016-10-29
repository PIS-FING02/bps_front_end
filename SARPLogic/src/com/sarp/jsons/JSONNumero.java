package com.sarp.jsons;

//import java.util.List;


public class JSONNumero {

	Integer id;
	String externalId;
	String hora;
	String estado;
	Integer prioridad;
	JSONDatosComp datosComplementarios;
	String idTramite;
	String idSector;
	
	public JSONNumero(){}

	public JSONNumero(Integer id, String externalId, String hora, String estado, Integer prioridad, String idTramite,
			String idSector) {
		super();
		this.id = id;
		this.externalId = externalId;
		this.hora = hora;
		this.estado = estado;
		this.prioridad = prioridad;
		this.idTramite = idTramite;
		this.idSector = idSector;
	}

	public JSONDatosComp getDatosComplementarios() {
		return this.datosComplementarios;
	}
	
	public void setDatosComplementarios(JSONDatosComp jdatos){
		this.datosComplementarios = jdatos;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public String getIdTramite() {
		return idTramite;
	}

	public void setIdTramite(String idTramite) {
		this.idTramite = idTramite;
	}

	public String getIdSector() {
		return idSector;
	}

	public void setIdSector(String idSector) {
		this.idSector = idSector;
	}
	
	public String toStringSacar() {
		String hora = this.hora!= null ? this.hora : "null";
		String prioridad = this.prioridad!= null ? this.prioridad.toString() : "null";
		String idTramite = this.idTramite!= null ? this.idTramite.toString() : "null";
		String idSector = this.idSector!= null ? this.idSector : "null";
		String datosComplementarios = this.datosComplementarios != null ? this.datosComplementarios.toString() : "null";
	 	
        return "{\n"
     			+ "\"hora\":\"" + hora + "\",\n"
     	     	+ "\"prioridad\":\"" + prioridad + "\",\n"
    	    	+ "\"datosComplementarios\":" + datosComplementarios + ",\n"
     			+ "\"idTramite\":\"" + idTramite + "\",\n"
     			+ "\"idSector\":\"" + idSector + "\"\n"
        		+ "}";
    }

	@Override
    public String toString() {
	 	String id = this.id!= null ? this.id.toString() : "null";
		String externalId = this.externalId!= null ? this.externalId : "null";
		String hora = this.hora!= null ? this.hora : "null";
		String estado = this.estado!= null ? this.estado : "null";
		String prioridad = this.prioridad!= null ? this.prioridad.toString() : "null";
		String idTramite = this.idTramite!= null ? this.idTramite : "null";
		String idSector = this.idSector!= null ? this.idSector : "null";
		String datosComplementarios = this.datosComplementarios != null ? this.datosComplementarios.toString() : "null";
	 	
        return "{\n"
        		+ "\"id\":\"" + id +"\",\n"
        		+ "\"externalId\":\"" + externalId + "\",\n"
     			+ "\"hora\":\"" + hora + "\",\n"
    	     	+ "\"estado\":\"" + estado +"\",\n"
    	    	+ "\"datosComplementarios\":" + datosComplementarios + ",\n"
     			+ "\"prioridad\":\"" + prioridad + "\",\n"
     			+ "\"idTramite\":\"" + idTramite + "\",\n"
     			+ "\"idSector\":\"" + idSector + "\"\n"
        		+ "}";
    }
}
