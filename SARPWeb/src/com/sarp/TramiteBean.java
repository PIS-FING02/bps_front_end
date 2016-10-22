package com.sarp;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
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
	
	//Atributo para mensaje de errores
	public String error = "hidden";
	public String error_message = "";

	public void alta() throws Exception{
		JSONTramite jtramite = new JSONTramite(null, this.nombre);
		String status = c.altaTramite(jtramite.toString(), "Administrador");
		if (status.equals("OK")){
			this.error_message="El tramite " + this.nombre + "se creo correctamente.";
		}else{
			this.error_message = "Ocurrio un error al crear el tramite";
		}
		this.error = "show";
	}
	
	public void baja(String codigo) throws Exception{
		JSONTramite jtramite = new JSONTramite(Integer.parseInt(codigo), "nombre");
		String status = c.bajaTramite(jtramite.toString(), "Administrador");
		if (status.equals("OK")){
			this.error_message="El tramite " + this.nombre + "se elimino correctamente.";
		}else{
			this.error_message = "Ocurrio un error al eliminar el tramite";
		}
		this.error = "show";
	}
	
	public void modificar(){
		JSONTramite jtramite = new JSONTramite(Integer.parseInt(this.codigo), this.nombre);
		String status = c.modTramite(jtramite.toString(), "Administrador");
		if (status.equals("OK")){
			this.error_message="El tramite " + this.nombre + "se modifico correctamente.";
		}else{
			this.error_message = "Ocurrio un error al modificar el tramite";
		}
		this.error = "show";
	}
	
	public String goToTramite(String codigo, String nombre) {
		return "/pages/forms.xhtml?tipoForm=modTramite&codigo=" + codigo + "&nombre=" + nombre + "faces-redirect=true";
	}

	public List<JSONTramite> listar() throws Exception{
		return modeler.toJSONTramites(c.listarTramite("ResponsableSector"));
	}

	public List<JSONTramiteRecepcion> listarDePuesto(String puesto) throws Exception {
		List<JSONTramiteRecepcion> hhhh = modeler.toJSONTramitesRecepcion(c.listarTramitesPuesto(puesto, "Recepcion"));
		System.out.println(hhhh);
		return hhhh;
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	
	public String hideError(){
		this.error="hidden";
		return "/pages/admin.xhtml";
	}
	
}
