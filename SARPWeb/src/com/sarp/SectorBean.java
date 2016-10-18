package com.sarp;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONSector;
import com.sarp.jsons.JSONSectorDisplay;
import com.sarp.jsons.JSONSectorPuesto;
import com.sarp.jsons.JSONSectorTramite;

@ManagedBean(name = "sector", eager = true)
@ViewScoped
public class SectorBean {

	private String id;
	private String nombre;
	private String ruta;
	
	//Atributo para mensaje de errores
	public String error = "hidden";
	public String error_message = "";
	
	//Atributo Tramite
	private String codigo;
	
	//Artributo Puesto
	private String nombreMaquina;
	
	//Atributo Display
	private String displayId;

	private	ControladorREST c = new ControladorREST();
	private static final JSONModeler modeler = new JSONModeler();
	
	
	public String getDisplayId() {
		return displayId;
	}

	public void setDisplayId(String displayId) {
		this.displayId = displayId;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public String getNombreMaquina() {
		return nombreMaquina;
	}

	public void setNombreMaquina(String nombreMaquina) {
		this.nombreMaquina = nombreMaquina;
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

	public void importarSecotesGAFU(){
		String status = this.c.importarSectoreGafu("Administrador");
		if (status.equals("OK")){
			this.error_message="Los sectores se actualizaron correctamente";
		}else{
			this.error_message = "Ocurrio un error al actualizar los sectores";
		}
		this.error = "show";
	}
	
	public List<JSONSector> listar() throws Exception{
		List<JSONSector> prueba = modeler.toJSONSectores(c.listarSectores("Administrador"));
		return prueba;
	}

	public void asignarTramiteSector() {
		JSONSectorTramite jsectortramite = new JSONSectorTramite(this.codigo,this.id);
		String status = this.c.asignarTramiteSector( jsectortramite.toString(), "ResponsableSector");
		if (status.equals("OK")){
			this.error_message="El tramite con Codigo: " + this.codigo + " se asigno correctamente al Sector con codigo : " + this.id;
		}else{
			this.error_message = "Ocurrio un error al asignar el tramite con Codigo: " + this.codigo + "  al Sector con codigo: " + this.id;
		}
		this.error = "show";
		
	}
	
	public void asignarDisplaySector() {
		
		JSONSectorDisplay jsectordisplay = new JSONSectorDisplay(this.id,this.displayId);
		String status = this.c.asignarDisplayoSector( jsectordisplay.toString(), "Administrador");
		if (status.equals("OK")){
			this.error_message="El display " + this.displayId + " se asigno correctamente al sector con codigo " + this.id;
		}else{
			this.error_message = "Ocurrio un error al asignar el display" + this.displayId + "  al sector con codigo " + this.id;
		}
		this.error = "show";
	}

	public void asignarPuestoSector() {
		JSONSectorPuesto jsectorpuesto = new JSONSectorPuesto(this.id,this.nombreMaquina);
		String status =this.c.asignarPuestoSector( jsectorpuesto.toString(), "ResponsableSector");
		if (status.equals("OK")){
			this.error_message="El puesto " + this.nombreMaquina + " se asigno correctamente al sector con codigo " + this.id;
		}else{
			this.error_message = "Ocurrio un error al asignar el puesto " + this.nombreMaquina + "  al sector con codigo " + this.id;
		}
		this.error = "show";

	}
		
	public String hideError(){
		this.error="hidden";
		return "/pages/sectores.xhtml";
	}
}
