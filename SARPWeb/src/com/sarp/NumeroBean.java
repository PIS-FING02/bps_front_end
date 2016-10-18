package com.sarp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsons.JSONDatosComp;
import com.sarp.jsons.JSONNumero;

@ManagedBean(name = "numero", eager = true)
@ViewScoped
public class NumeroBean {

	private String idTramite;
	private String idSector;
	private String prioridad;
	private String nombreCompleto;
	private String doc;
	private String tipoDoc;
	private String hora;

	private	ControladorREST c = new ControladorREST();
	
	public void sacarNumero() throws Exception {
		JSONDatosComp jdatos = new JSONDatosComp(this.doc, this.tipoDoc, this.nombreCompleto);
		JSONNumero jnumero = new JSONNumero();
		jnumero.setHora(this.hora);
		jnumero.setIdSector(this.idSector);
		jnumero.setIdTramite(Integer.parseInt(this.idTramite));
		jnumero.setPrioridad(2);
		jnumero.setDatosComplementarios(jdatos);
		System.out.println(jnumero);
		this.c.sacarNumero(jnumero.toStringSacar(), "ResponsableSector");
	}	

	public String getPrioridad() {
		return prioridad;
	}
	
	public void setPrioridad(String prioridad) {
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

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
