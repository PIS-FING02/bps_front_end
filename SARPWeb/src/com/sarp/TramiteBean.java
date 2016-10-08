package com.sarp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sarp.controllers.ControladorREST;

@ManagedBean(name = "tramite", eager = true)
@RequestScoped
public class TramiteBean {

	public String codigo;
	public String nombre;
	public	ControladorREST c = new ControladorREST();
	
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
		return c.listarTramite(null);
	}

}
