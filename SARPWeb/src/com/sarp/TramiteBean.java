package com.sarp;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONTramite;
import com.sarp.jsons.JSONTramiteRecepcion;

@ManagedBean(name = "tramite", eager = true)
@SessionScoped
public class TramiteBean {

	private String codigo;
	private String nombre;
	private String id_sector;
	private	ControladorREST c = new ControladorREST();
	private List<JSONTramite> tramites;
	private static final JSONModeler modeler = new JSONModeler();
	
	//Atributo para mensaje de errores
	public String notice = "hidden";
	public String notice_title = "";
	public String notice_message = "";

	public String alta() throws Exception{
		JSONTramite jtramite = new JSONTramite(null, this.nombre);
		String status = c.altaTramite(jtramite.toString(), "Administrador");
		if (status.equals("OK")){
			this.notice_title = "Esto es un mensaje de Confirmación.";
			this.notice_message = "El tramite con nombre "+ this.nombre + " se creo correctamente.";
			this.notice = "positive";
		} else {
			this.notice_title = "Han ocurrido error/es que impiden continuar.";
			this.notice_message = "Ocurrio un error al crear el tramite.";
			this.notice = "negative";
		}
		this.nombre = "";
		return "/pages/tramites.xhtml?faces-redirect=true";
	}
	
	public String baja(String codigo) {
		JSONTramite jtramite = new JSONTramite(Integer.parseInt(codigo), "nombre");
		String status = c.bajaTramite(jtramite.toString(), "Administrador");
		if (status.equals("OK")){
			this.notice_title = "Esto es un mensaje de Confirmación.";
			this.notice_message = "El tramite se elimino correctamente.";
			this.notice = "positive";
		} else {
			this.notice_title = "Han ocurrido error/es que impiden continuar.";
			this.notice_message = "Ocurrio un error al eliminar el tramite.";
			this.notice = "negative";
		}
		this.nombre = "";
		return "/pages/tramites.xhtml?faces-redirect=true";
	}
	
	public String modificar(){
		JSONTramite jtramite = new JSONTramite(Integer.parseInt(this.codigo), this.nombre);
		String status = c.modTramite(jtramite.toString(), "Administrador");
		if (status.equals("OK")){
			this.notice_title = "Esto es un mensaje de Confirmación.";
			this.notice_message = "El tramite con nombre "+ this.nombre + " se modifico correctamente.";
			this.notice = "positive";
		} else {
			this.notice_title = "Han ocurrido error/es que impiden continuar.";
			this.notice_message = "Ocurrio un error al modificar el tramite.";
			this.notice = "negative";
		}
		this.nombre = "";
		this.codigo = "";
		return "/pages/tramites.xhtml?faces-redirect=true";
	}
	
	public String goToTramite(String codigo, String nombre) {
		return "/pages/forms.xhtml?tipoForm=modTramite&codigo=" + codigo + "&nombre=" + nombre + "faces-redirect=true";
	}

	public List<JSONTramite> listar() throws Exception{
		return modeler.toJSONTramites(c.listarTramite("ResponsableSector"));
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

	public String getNotice_message() {
		return notice_message;
	}

	public void setNotice_message(String notice_message) {
		this.notice_message = notice_message;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	
	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}
	
	public String hideError(){
		this.notice="hidden";
		return "/pages/admin.xhtml";
	}
	
}
