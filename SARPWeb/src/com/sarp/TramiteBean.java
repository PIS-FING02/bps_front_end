package com.sarp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONTramite;
import com.sarp.jsons.JSONTramiteRecepcion;

@ManagedBean(name = "tramite", eager = true)
@ViewScoped
public class TramiteBean {

	private String codigo;
	private String nombre;
	private String id_sector;
	private	ControladorREST c = new ControladorREST();
	private List<JSONTramite> tramites;
	private static final JSONModeler modeler = new JSONModeler();
	private boolean entre = false;
	private String searchString;

	@ManagedProperty("#{login}")
	public LoginBean login;
	public SharedBean shared = SharedBean.getInstance();
	
	public String alta() throws Exception{
		JSONTramite jtramite = new JSONTramite(this.codigo, this.nombre);
		String status = c.altaTramite(jtramite.toString(), "ADMIN");
		shared.updateNotice(status, "El trámite con código " + this.codigo + " y nombre "+ this.nombre + " se creó correctamente.");
		return "/pages/tramites.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String baja(String codigo) {
		JSONTramite jtramite = new JSONTramite(codigo, "nombre");
		String status = c.bajaTramite(jtramite.toString(), "ADMIN");
		shared.updateNotice(status, "El trámite con código " + codigo + " se eliminó correctamente.");
		return "/pages/tramites.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String modificar(){
		JSONTramite jtramite = new JSONTramite(this.codigo, this.nombre);
		String status = c.modTramite(jtramite.toString(), "ADMIN");
		shared.updateNotice(status, "El trámite con nombre "+ this.nombre + " se modificó correctamente.");
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
	
	public List<String> listar1() throws Exception{
		List<String> resultado = new ArrayList<String>();
		resultado.add("Exito");
		resultado.add("Error");
		resultado.add("Desviado");
		resultado.add("Otro");
		return resultado;
	}
	
	public List<JSONTramite> listarDeSector(String idSector) throws Exception {
		shared.clean();
		if (idSector == "")
			return null;
		else {
			List<JSONTramite> list = modeler.toJSONTramites(c.listarTramitesSector(idSector, "RESPSEC"));
			if (list.isEmpty())
				shared.updateNoticeInfo("El sector con identificador " + idSector + " no tiene trámites asignados.");
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
				shared.updateNoticeInfo("El puesto con nombre de máquina " + idPuesto + " no tiene trámites asignados.");
			return list;
		}
	}

	public List<JSONTramiteRecepcion> listarParaRecepcion(String puesto) throws Exception {
		if (shared.getRolesMap().get("RECEPCION")) {
			List<JSONTramiteRecepcion> list = modeler.toJSONTramitesRecepcion(c.listarTramitesRecepcion(puesto, "RECEPCION"));
			if (list.isEmpty())
				shared.updateNoticeInfo("Tu puesto, " + puesto + ", no tiene trámites habilitados para hacer entrega de números");
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
