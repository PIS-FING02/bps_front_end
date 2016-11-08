package com.sarp;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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

	@ManagedProperty("#{shared}")
	public SharedBean shared;
	
	
	
	public SharedBean getShared() {
		return shared;
	}

	public void setShared(SharedBean shared) {
		this.shared = shared;
	}

	public void sacarNumero() throws Exception{
		JSONDatosComp jdatos = new JSONDatosComp(this.doc, this.tipoDoc, this.nombreCompleto);
		JSONNumero jnumero = new JSONNumero();
		jnumero.setHora(this.hora);
		jnumero.setIdSector(this.idSector);
		jnumero.setIdTramite(this.idTramite);
		jnumero.setPrioridad(2);
		jnumero.setDatosComplementarios(jdatos);
		System.out.println(jnumero);
		String status = c.sacarNumero(jnumero.toStringSacar(), "RESPSEC");
		this.tipoDoc="";
		this.doc="";
		this.nombreCompleto="";
		shared.updateNotice("OK", "El numero " + status + " para el tramite con codigo " + this.idTramite + " en el sector con identificador " + this.idSector + " fue entregado con exito.");
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
		Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		String idSector = params.get("idSector");
		if(idSector != null){
			List<JSONNumero> list = modeler.toJSONNumeros(c.listarNumerosPausadosSector(idSector, "RESPSEC", shared.getUser()));	
			if (list == null || list.isEmpty())
				shared.updateNoticeInfo("No se encontraron n�meros atrasados para el sector con identificador " + idSector + " .");
			return list;
		}else{
			return null;
		}
	}
	
	public List<JSONNumero> listarNumerosAtrasados(){
		Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		String idSector = params.get("idSector");
		if(idSector != null){
			List<JSONNumero> list = modeler.toJSONNumeros(c.listarNumerosAtrasadosSector(idSector, "RESPSEC", shared.getUser()));	
			if (list == null || list.isEmpty())
				shared.updateNoticeInfo("No se encontraron n�meros atrasados para el sector con identificador " + idSector + " .");
			return list;
		}else{
			return null;
		}	
	}

	@PostConstruct
	public List<JSONNumero> listarNumerosEnEspera(){
		Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		String idSector = params.get("idSector");
		if(idSector != null){
			List<JSONNumero> list = modeler.toJSONNumeros(c.listarNumerosEnEsperaSector(idSector, "RESPSEC", shared.getUser()));	
			if (list == null || list.isEmpty())
				shared.updateNoticeInfo("No se encontraron n�meros atrasados para el sector con identificador " + idSector + " .");
			return list;
		}else{
			return null;
		}
	}
}
