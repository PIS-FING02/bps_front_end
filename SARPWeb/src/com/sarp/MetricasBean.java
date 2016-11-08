package com.sarp;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONMetricasNumero;
import com.sarp.jsons.JSONMetricasPuesto;

@ManagedBean(name = "metricas", eager = true)
@SessionScoped
public class MetricasBean {
	
	private String nombreMaquina;
    private String usuarioAtencion;
    private String estado;
    private String timeSpent;
    private String lastUpdated;
    private String dateCreated;
  
	private String externalId;
	
	private List<JSONMetricasPuesto> metricasPuestos;
	private List<JSONMetricasNumero> metricasNumeros;
	
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
	public boolean nombreMaquinaVacio(){
		/*Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String paramNombreMaquina = params.get("nombreMaquina");
		return (paramNombreMaquina.isEmpty());*/
		return false;
	}
	public String metricasPuestos() throws Exception{
		shared.clean();
		if (shared.getRolesMap().get("CONSULTOR")) {
			this.metricasPuestos = modeler.toJSONMetricasPuestos(c.listarMetricasPuestos("CONSULTOR", shared.getUser()));
			if (this.metricasPuestos.isEmpty())
				shared.updateNoticeInfo("No se encontraron m�tricas para estos puestos en el sistema.");
			return ("/pages/metricasPuesto.xhtml?faces-redirect=true");
		}else{
			return null;
		}
	}
	
	public List<JSONMetricasPuesto> obtenerMetricasPuesto() throws Exception{
		shared.clean();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String nombreMaquina = params.get("nombreMaquina");
		if(!nombreMaquina.isEmpty()){
			if (shared.getRolesMap().get("CONSULTOR")) {
				this.metricasPuestos = modeler.toJSONMetricasPuestos(c.listarMetricasPuesto(nombreMaquina,"CONSULTOR", shared.getUser()));
				if (this.metricasPuestos.isEmpty())
					shared.updateNoticeInfo("No se encontraron m�tricas para este puesto en el sistema.");
				return this.metricasPuestos;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public boolean numeroVacio(){
		/*Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String paramNombreMaquina = params.get("nombreMaquina");
		return (paramNombreMaquina.isEmpty());*/
		return false;
	}
	
	public String metricasNumeros() throws Exception{
		shared.clean();
		if (shared.getRolesMap().get("CONSULTOR")) {
			this.metricasNumeros = modeler.toJSONMetricasNumeros(c.listarMetricasNumeros("CONSULTOR", shared.getUser()));
			if (this.metricasNumeros.isEmpty())
				shared.updateNoticeInfo("No se encontraron m�tricas para estos n�meros en el sistema.");
			return ("/pages/metricasNumero.xhtml?faces-redirect=true");
		}else{
			return null;
		}
	}
	
	public String metricasNumerosEstado() throws Exception{
		shared.clean();
		if (shared.getRolesMap().get("CONSULTOR")) {
			this.metricasNumeros = modeler.toJSONMetricasNumeros(c.listarMetricasNumerosEstado("CONSULTOR", shared.getUser()));
			if (this.metricasNumeros.isEmpty())
				shared.updateNoticeInfo("No se encontraron m�tricas para estos n�meros en el sistema.");
			return ("/pages/metricasNumero.xhtml?faces-redirect=true");
		}else{
			return null;
		}
	}
	
	public List<JSONMetricasNumero> obtenerMetricasNumero() throws Exception{
		shared.clean();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String externalId = params.get("externalId");
		if(!externalId.isEmpty()){
			if (shared.getRolesMap().get("CONSULTOR")) {
				this.metricasNumeros = modeler.toJSONMetricasNumeros(c.listarMetricasNumero(externalId,"CONSULTOR", shared.getUser()));
				if (this.metricasNumeros.isEmpty())
					shared.updateNoticeInfo("No se encontraron m�tricas para este n�mero en el sistema.");
				return this.metricasNumeros;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public List<JSONMetricasNumero> obtenerMetricasNumeroEstado() throws Exception{
		shared.clean();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String externalId = params.get("externalId");
		if(!externalId.isEmpty()){
			if (shared.getRolesMap().get("CONSULTOR")) {
				this.metricasNumeros = modeler.toJSONMetricasNumeros(c.listarMetricasNumeroEstado(externalId,"CONSULTOR", shared.getUser()));
				if (this.metricasNumeros.isEmpty())
					shared.updateNoticeInfo("No se encontraron m�tricas para este n�mero en el sistema.");
				return this.metricasNumeros;
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
}
