package com.sarp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sarp.controladores.ControladorREST;

@ManagedBean(name = "tramite", eager = true)
@RequestScoped
public class TramiteBean {

	public String codigo;
	public String nombre;
	
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
	
	public  void alta(){
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println(nombre);
		System.out.println(codigo);

		ControladorREST c = new ControladorREST();
		c.altaTramite();
	}
	

}
