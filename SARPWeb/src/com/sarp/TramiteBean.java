package com.sarp;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;

@ManagedBean(name = "tramite", eager = true)
@ViewScoped
public class TramiteBean {

	private String codigo;
	private String nombre;
	private	ControladorREST c = new ControladorREST();
	private List<JSONTramite> tramites;
	
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
	
	public void alta() throws Exception{
		c.altaTramite(null,null);
	}
	
	public void baja(){
		c.bajaTramite(null,null);
	}

	public void mod(){
		c.modTramite(null,null);
	}

	public String listar() throws Exception{
		return c.listarTramite("ResponsableSector");
	}

}
