package com.sarp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;

@ManagedBean(name = "sector", eager = true)
@ViewScoped
public class SectorBean {

	private String id;
	private String nombre;
	private String ruta;
	
	// atributos puesto
	private String maquina;
	private String usuarioId;
	private Integer numero;
	private String estado;
	private	ControladorREST c = new ControladorREST();
	
	public void asignarPuesto(){
//		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, this.numero, this.estado);
//		JSONSector jsector = new JSONSector(Integer.parseInt(this.id), this.nombre, this.ruta);
//		c.asignarTramite(jpuesto.toString() + jtramite.toString(), "ResponsableSector"); //TERMINAR
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public void importarSecotesGAFU() throws Exception{
		this.c.importarSectoreGafu("Administrador");
	}

}
