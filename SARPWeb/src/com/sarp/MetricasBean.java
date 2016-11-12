package com.sarp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONMetricasNumero;
import com.sarp.jsons.JSONMetricasNumeroEstado;
import com.sarp.jsons.JSONMetricasPuesto;
import com.sarp.jsons.JSONPuesto;

@ManagedBean(name = "metricas", eager = true)
@SessionScoped
public class MetricasBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombreMaquina;
    private String usuarioAtencion;
    private String estado;
    private String timeSpent;
    private String lastUpdated;
    private String dateCreated;
  
	private Integer internalId;
	
	private List<JSONMetricasPuesto> metricasPuestos;
	private List<JSONMetricasNumero> metricasNumeros = new ArrayList<JSONMetricasNumero>();;
	private JSONMetricasNumero metricasNumero;
	private List<JSONMetricasNumeroEstado> metricasNumerosEstado;

	private	ControladorREST c = new ControladorREST();
	private static final JSONModeler modeler = new JSONModeler();

	@ManagedProperty("#{sessionScope.shared}")
	public SharedBean shared;	

	public SharedBean getShared() {
		return shared;
	}
	public void setShared(SharedBean shared) {
		this.shared = shared;
	}
	public boolean nombreMaquinaVacio(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String paramNombreMaquina = params.get("nombreMaquina");
		return (paramNombreMaquina == null);
	}
	public String metricasPuestos() throws Exception{
		shared.clean();
		if (shared.getRolesMap().get("CONSULTOR")) {
			this.metricasPuestos = modeler.toJSONMetricasPuestos(c.listarMetricasPuestos("CONSULTOR", shared.getUser()));
			if (this.metricasPuestos.isEmpty())
				shared.updateNoticeInfo("No se encontraron métricas para estos puestos en el sistema.");
			return ("/pages/metricasPuesto.xhtml?faces-redirect=true");
		}else{
			return null;
		}
	}
	
	public List<JSONMetricasPuesto> obtenerMetricasPuesto() throws Exception{
		shared.clean();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String nombreMaquina = params.get("nombreMaquina");
		System.out.println("Nombre de maquina:" + nombreMaquina);
		if(!(nombreMaquina == null)){
			if (shared.getRolesMap().get("CONSULTOR")) {
				this.metricasPuestos = modeler.toJSONMetricasPuestos(c.listarMetricasPuesto(nombreMaquina,"CONSULTOR", shared.getUser()));
				if (this.metricasPuestos.isEmpty())
					shared.updateNoticeInfo("No se encontraron métricas para este puesto en el sistema.");
				return this.metricasPuestos;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public boolean numeroVacio(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String paramnumero = params.get("internalId");
		return (paramnumero == null);
	}
	
	public String metricasNumeros() throws Exception{
		shared.clean();
		if (shared.getRolesMap().get("CONSULTOR")) {
			this.metricasNumeros = modeler.toJSONMetricasNumeros(c.listarMetricasNumeros("CONSULTOR", shared.getUser()));
			if (this.metricasNumeros.isEmpty())
				shared.updateNoticeInfo("No se encontraron métricas para estos números en el sistema.");
			return ("/pages/metricasNumero.xhtml?faces-redirect=true");
		}else{
			return null;
		}
	}
	
	public String metricasNumerosEstado() throws Exception{
		shared.clean();
		if (shared.getRolesMap().get("CONSULTOR")) {
			this.metricasNumerosEstado = modeler.toJSONMetricasNumerosEstado(c.listarMetricasNumerosEstado("CONSULTOR", shared.getUser()));
			if (this.metricasNumerosEstado.isEmpty())
				shared.updateNoticeInfo("No se encontraron métricas para estos números en el sistema.");
			return ("/pages/metricasNumeroEstado.xhtml?faces-redirect=true");
		}else{
			return null;
		}
	}
	
	public List<JSONMetricasNumero> obtenerMetricasNumero() throws Exception{
		shared.clean();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String internalId = params.get("internalId");
		if(!(internalId == null)){
			if (shared.getRolesMap().get("CONSULTOR")) {
				this.metricasNumero = modeler.toJSONMetricasNumero(c.listarMetricasNumero(internalId,"CONSULTOR", shared.getUser()));
				this.metricasNumeros.clear();
				this.metricasNumeros.add(this.metricasNumero);
				this.internalId = this.metricasNumero.getInternalId();
				//this.metricasNumeros.add(modeler.toJSONMetricasNumero(c.listarMetricasNumero(internalId,"CONSULTOR", shared.getUser())));
				if (this.metricasNumero == null)
					shared.updateNoticeInfo("No se encontraron métricas para este número en el sistema.");
				return this.metricasNumeros;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public List<JSONMetricasNumeroEstado> obtenerMetricasNumeroEstado() throws Exception{
		shared.clean();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String internalId = params.get("internalId");
		if(!(internalId == null)){
			if (shared.getRolesMap().get("CONSULTOR")) {
				this.metricasNumerosEstado = modeler.toJSONMetricasNumerosEstado(c.listarMetricasNumeroEstado(internalId,"CONSULTOR", shared.getUser()));
				if (this.metricasNumerosEstado.isEmpty())
					shared.updateNoticeInfo("No se encontraron métricas para este número en el sistema.");
				return this.metricasNumerosEstado;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public List<JSONMetricasPuesto> getMetricasPuestos() { 
		return metricasPuestos;
	}

	public void setMetricasPuestos(List<JSONMetricasPuesto> metricasPuestos) {
		this.metricasPuestos = metricasPuestos;
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
	
	public Integer getInternalId() {
		return internalId;
	}
	
	public void setInternalId(Integer internalId) {
		this.internalId = internalId;
	}
	
	public JSONMetricasNumero getMetricasNumero() {
		return metricasNumero;
	}
	
	public void setMetricasNumero(JSONMetricasNumero metricasNumero) {
		this.metricasNumero = metricasNumero;
	}
	
	public List<JSONMetricasNumero> getMetricasNumeros() {
		return metricasNumeros;
	}
	
	public void setMetricasNumeros(List<JSONMetricasNumero> metricasNumeros) {
		this.metricasNumeros = metricasNumeros;
	}
	
	public List<JSONMetricasNumeroEstado> getMetricasNumerosEstado() {
		return metricasNumerosEstado;
	}
	
	public void setMetricasNumerosEstado(List<JSONMetricasNumeroEstado> metricasNumerosEstado) {
		this.metricasNumerosEstado = metricasNumerosEstado;
	}
}
