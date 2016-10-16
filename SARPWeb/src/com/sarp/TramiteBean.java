package com.sarp;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONTramite;

@ManagedBean(name = "tramite", eager = true)
@ViewScoped
public class TramiteBean {

	private String codigo;
	private String nombre;
	private String id_sector;
	private	ControladorREST c = new ControladorREST();
	private List<JSONTramite> tramites;
	private static final JSONModeler modeler = new JSONModeler();

	public void alta() throws Exception{
		JSONTramite jtramite = new JSONTramite(null, this.nombre);
		c.altaTramite(jtramite.toString(), "Administrador");
	}
	
	public void baja() throws Exception{
		JSONTramite jtramite = new JSONTramite(Integer.parseInt(this.codigo), "nombre");
		c.bajaTramite(jtramite.toString(), "Administrador");
	}
	
	public void modificar(){
		JSONTramite jtramite = new JSONTramite(Integer.parseInt(this.codigo), this.nombre);
		c.modTramite(jtramite.toString(), "Administrador");
	}

	public List<JSONTramite> listar() throws Exception{
		return modeler.toJSONTramites(c.listarTramite("ResponsableSector"));
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
}
