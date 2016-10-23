package com.sarp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
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

	public SharedBean notice = SharedBean.getInstance();
	
	public String alta() throws Exception{
		JSONTramite jtramite = new JSONTramite(null, this.nombre);
		String status = c.altaTramite(jtramite.toString(), "Administrador");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El tramite con nombre "+ this.nombre + " se creo correctamente.");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al crear el tramite.");
			notice.setNotice("negative");
		}
		return "/pages/tramites.xhtml?faces-redirect=true";
	}
	
	public String baja(String codigo) {
		JSONTramite jtramite = new JSONTramite(Integer.parseInt(codigo), "nombre");
		String status = c.bajaTramite(jtramite.toString(), "Administrador");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El tramite con codigo " + codigo + " se elimino correctamente.");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al eliminar el tramite.");
			notice.setNotice("negative");
		}
		return "/pages/tramites.xhtml?faces-redirect=true";
	}
	
	public String modificar(){
		JSONTramite jtramite = new JSONTramite(Integer.parseInt(this.codigo), this.nombre);
		String status = c.modTramite(jtramite.toString(), "Administrador");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El tramite con nombre "+ this.nombre + " se modifico correctamente.");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al modificar el tramite.");
			notice.setNotice("negative");
		}
		return "/pages/tramites.xhtml?faces-redirect=true";
	}
	
	public String goToTramite(String codigo, String nombre) {
		return "/pages/forms.xhtml?tipoForm=modTramite&codigo=" + codigo + "&nombre=" + nombre + "faces-redirect=true";
	}

	public List<JSONTramite> listar() throws Exception{
		return modeler.toJSONTramites(c.listarTramite("ResponsableSector"));
	}
	
	public List<String> listar1() throws Exception{
		List<String> resultado = new ArrayList<String>();
		resultado.add("Exito");
		resultado.add("Error");
		resultado.add("Desviado");
		resultado.add("Putita");
		return resultado;
	}
	
	public List<JSONTramite> listarDeSector(String idSector) throws Exception{
		return modeler.toJSONTramites(c.listarTramitesSector(idSector,"ResponsableSector"));
	}

	public List<JSONTramiteRecepcion> listarDePuesto(String puesto) throws Exception {
		return modeler.toJSONTramitesRecepcion(c.listarTramitesPuesto(puesto, "Recepcion"));
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
}
