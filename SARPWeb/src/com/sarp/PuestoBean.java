package com.sarp;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONPuesto;
import com.sarp.jsons.JSONTramite;

@ManagedBean(name = "puesto", eager = true)
@RequestScoped
public class PuestoBean {
	
	public String maquina;
	public String usuarioId;
	public Integer numero;
	public String estado;
	private	ControladorREST c = new ControladorREST();
	private List<JSONPuesto> puestos;
	private static final JSONModeler modeler = new JSONModeler();

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
	
	public void alta() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, "0", 0, this.estado);
		c.altaPuesto(jpuesto.toString(), "ResponsableSector");
	}
	
	public void baja() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, "id", 0, "CERRADO");
		c.bajaPuesto(jpuesto.toString(), "ResponsableSector");
	}
	
	public void modificar(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, 0, this.estado);
		c.modPuesto(jpuesto.toString(), "ResponsableSector");
	}

	public List<JSONPuesto> listar() throws Exception{
		return modeler.toJSONPuestos(c.listarPuestos("ResponsableSector"));
	}

}
