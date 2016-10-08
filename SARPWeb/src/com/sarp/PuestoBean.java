package com.sarp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sarp.controllers.ControladorREST;

@ManagedBean(name = "puesto", eager = true)
@RequestScoped
public class PuestoBean {
	
	public String maquina;
	public String usuarioId;
	public Integer numero;
	public String estado;

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public  void alta(){
		System.out.println("------------------------------------------------");
		System.out.println(maquina);
		System.out.println(estado);

		ControladorREST c = new ControladorREST();
		c.altaPuesto(null, null);
		
	}

}
