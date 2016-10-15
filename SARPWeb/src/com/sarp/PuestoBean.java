package com.sarp;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONPuesto;
import com.sarp.jsons.JSONTramite;

@ManagedBean(name = "puesto", eager = true)
@ViewScoped
public class PuestoBean {
	
	private String maquina;
	private String usuarioId;
	private Integer numero;
	private String estado;
	
	//atributos de tramite
	private String codigo;
	private String nombre;
	
	private	ControladorREST c = new ControladorREST();
	private static final JSONModeler modeler = new JSONModeler();

	public void alta() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, "0", this.numero, this.estado);
		c.altaPuesto(jpuesto.toString(), "ResponsableSector");
	}
	
	public void baja() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, "id", 0, "CERRADO");
		c.bajaPuesto(jpuesto.toString(), "ResponsableSector");
	}
	
	public void modificar(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, this.numero, this.estado);
		c.modPuesto(jpuesto.toString(), "ResponsableSector");
	}

	public List<JSONPuesto> listar() throws Exception{
		return modeler.toJSONPuestos(c.listarPuestos("ResponsableSector"));
	}

	public void asignarTramite(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, this.numero, this.estado);
		JSONTramite jtramite = new JSONTramite(Integer.parseInt(this.codigo), this.nombre);
		c.asignarTramite(jpuesto.toString() + jtramite.toString(), "ResponsableSector"); //TERMINAR
	}
	
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
}
