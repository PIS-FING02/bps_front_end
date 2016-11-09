package com.sarp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONTramite;
import com.sarp.jsons.JSONTramiteRecepcion;

@ManagedBean(name = "tramite", eager = true)
@ViewScoped
public class TramiteBean implements Serializable{


	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String id_sector;
	private	ControladorREST c = new ControladorREST();
	private List<JSONTramite> tramites;
	private static final JSONModeler modeler = new JSONModeler();
	private boolean entre = false;
	private String searchString;

	@ManagedProperty("#{sessionScope.login}")
	public LoginBean login;
	
	@ManagedProperty("#{sessionScope.shared}")
	public SharedBean shared;
	
	@ManagedProperty("#{sessionScope.puesto}")
	public PuestoBean puesto;
	
	
	
	
	
	public PuestoBean getPuesto() {
		return puesto;
	}

	public void setPuesto(PuestoBean puesto) {
		this.puesto = puesto;
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public SharedBean getShared() {
		return shared;
	}

	public void setShared(SharedBean shared) {
		this.shared = shared;
	}

	public String alta() throws Exception{
		JSONTramite jtramite = new JSONTramite(this.codigo, this.nombre);
		String status = c.altaTramite(jtramite.toString(), "ADMIN");
		Pattern pat = Pattern.compile("(.*)ERROR(.*)");
		Matcher statusAlta = pat.matcher(status);
	
		if(!statusAlta.find())
			shared.updateNotice(status, "El tr�mite con c�digo " + this.codigo + " y nombre "+ this.nombre + " se cre� correctamente.");
		else
			shared.updateNoticeInfo("El tr�mite con c�digo " + this.codigo + " y nombre "+ this.nombre + " ya existe.");
			
		return "/pages/tramites.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String baja(String codigo) {
		JSONTramite jtramite = new JSONTramite(codigo, "nombre");
		String status = c.bajaTramite(jtramite.toString(), "ADMIN");
		shared.updateNotice(status, "El tr�mite con c�digo " + codigo + " se elimin� correctamente.");
		return "/pages/tramites.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String modificar(){
		JSONTramite jtramite = new JSONTramite(this.codigo, this.nombre);
		String status = c.modTramite(jtramite.toString(), "ADMIN");
		shared.updateNotice(status, "El tr�mite con nombre "+ this.nombre + " se modific� correctamente.");
		return "/pages/tramites.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String goToTramite(String codigo, String nombre) {
		return "/pages/forms.xhtml?tipoForm=modTramite&codigo=" + codigo + "&nombre=" + nombre + "faces-redirect=true";
	}

	public List<JSONTramite> listar() throws Exception{
		if (shared.getRolesMap().get("ADMIN")) {	
			shared.setTramitesList(modeler.toJSONTramites(c.listarTramite("ADMIN", shared.getUser())));
		} else {
			shared.setTramitesList(modeler.toJSONTramites(c.listarTramite("RESPSEC", shared.getUser())));
		}
		List<JSONTramite> oooo =  shared.getTramitesList();
		return oooo;
	}
	

	public String listarTramitesBusqueda(String page){
		List<JSONTramite> tramitesListBusqueda = new ArrayList<JSONTramite>();
		Iterator<JSONTramite> iter = shared.getTramitesList().iterator();
		while(iter.hasNext()){
			JSONTramite tramiteIter = iter.next();
           	if((tramiteIter.getNombre().toLowerCase().contains(this.searchString.toLowerCase()))||
           			(tramiteIter.getCodigo().toLowerCase().contains(this.searchString.toLowerCase()))){
           		tramitesListBusqueda.add(tramiteIter);
           	}
	    }
		shared.setTramitesListBusqueda(tramitesListBusqueda);
		return ("/pages/" + page +  ".xhtml?busqueda=true&faces-redirect=true");
	}
	
	public List<JSONTramite> listarResultadoBusqueda(){
		return shared.getTramitesListBusqueda();
	}

	public List<JSONTramite> listarParaSector(String input) throws Exception {
		shared.clean();
		if (shared.getRolesMap().get("RESPSEC")) 
			return modeler.toJSONTramites(c.listarTramiteParaSector(input, "RESPSEC", shared.getUser()));		
		else 
			return null;
	}
	
	public List<JSONTramite> listarDeSector(String idSector) throws Exception {
		shared.clean();
		if (idSector == "")
			return null;
		else {
			List<JSONTramite> list = modeler.toJSONTramites(c.listarTramitesSector(idSector, "RESPSEC"));
			if (list.isEmpty())
				shared.updateNoticeInfo("El sector con identificador " + idSector + " no tiene tr�mites asignados.");
			return list;
		}
	}

	public List<JSONTramite> listarDePuesto(String idPuesto) throws Exception {
		shared.clean();
		if (idPuesto == "")
			return null;
		else {
			List<JSONTramite> list = modeler.toJSONTramites(c.listarTramitesPuesto(idPuesto, "RESPSEC"));
			if (list.isEmpty())
				shared.updateNoticeInfo("El puesto con nombre de m�quina " + idPuesto + " no tiene tr�mites asignados.");
			return list;
		}
	}

	public List<JSONTramiteRecepcion> listarParaRecepcion() throws Exception {
		if (shared.getRolesMap().get("RECEPCION")) {
			List<JSONTramiteRecepcion> list = modeler.toJSONTramitesRecepcion(c.listarTramitesRecepcion(this.puesto.getMaquina(), "RECEPCION"));
			if (list.isEmpty())
				shared.updateNoticeInfo("Tu puesto, " + puesto + ", no tiene tr�mites habilitados para hacer entrega de n�meros");
			return list;
		} else {
			shared.updateNoticeInfo("No tienes permisos suficientes.");
			return null;
		}
	}

	public void setTramites(List<JSONTramite> tramites) {
		this.tramites = tramites;
	}

	public List<JSONTramite> getTramites(){
		return this.tramites;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId_sector() {
		return id_sector;
	}

	public void setId_sector(String id_sector) {
		this.id_sector = id_sector;
	}
	
	public boolean isEntre() {
		return entre;
	}

	public void setEntre(boolean entre) {
		this.entre = entre;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
}
