package com.sarp;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONDatosComp;
import com.sarp.jsons.JSONNumero;
import javax.annotation.PostConstruct;

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
	private static final JSONModeler modeler = new JSONModeler();
	
	public void sacarNumero() throws Exception {
		JSONDatosComp jdatos = new JSONDatosComp(this.doc, this.tipoDoc, this.nombreCompleto);
		JSONNumero jnumero = new JSONNumero();
		jnumero.setHora(this.hora);
		jnumero.setIdSector(this.idSector);
		jnumero.setIdTramite(Integer.parseInt(this.idTramite));
		jnumero.setPrioridad(2);
		jnumero.setDatosComplementarios(jdatos);
		System.out.println(jnumero);
		this.c.sacarNumero(jnumero.toStringSacar(), "RESPSEC");
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
	
	public List<JSONNumero> listarNumerosPausados(){
		Map<String, String> params =FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		String idSector = params.get("idSector");
		if(idSector != null){
			return modeler.toJSONNumeros(c.listarNumerosPausadosSector(idSector, "RESPSEC"));
		}else{
			return null;
		}
	}
	
	public List<JSONNumero> listarNumerosAtrasados(){
		Map<String, String> params =FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		String idSector = params.get("idSector");
		if(idSector != null){
			return modeler.toJSONNumeros(c.listarNumerosAtrasadosSector(idSector, "RESPSEC"));
		}else{
			return null;
		}	
	}

	@PostConstruct
	public List<JSONNumero> listarNumerosEnEspera(){
		Map<String, String> params =FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		String idSector = params.get("idSector");
		if(idSector != null){
			return modeler.toJSONNumeros(c.listarNumerosEnEsperaSector(idSector, "RESPSEC"));	
		}else{
			return null;
		}
	}
}
