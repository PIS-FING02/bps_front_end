package com.sarp;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONNumero;
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
	
	//Atributo Tramite
	private String codigo;
	
	//Artributo Puesto
	private String nombreMaquina;
	
	//Atributo Display
	private String displayId;

	private	ControladorREST c = new ControladorREST();
	private static final JSONModeler modeler = new JSONModeler();
	public SharedBean notice = SharedBean.getInstance();
	
	public List<JSONSector> listar() throws Exception{
		List<JSONSector> prueba = modeler.toJSONSectores(c.listarSectores("Administrador"));
		return prueba;
	}
	
	public String importarSecotesGAFU(){
		String status = this.c.importarSectoreGafu("Administrador");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("Los sectores se actualizaron correctamente");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al actualizar los sectores.");
			notice.setNotice("negative");
		}
		return "/pages/admin.xhtml?faces-redirect=true";
	}
	
	public String asignarTramiteSector() {
		JSONSectorTramite jsectortramite = new JSONSectorTramite(this.codigo, this.id);
		String status = this.c.asignarTramiteSector(jsectortramite.toString(), "ResponsableSector");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El tramite con codigo "+ this.codigo + " se asigno correctamente al sector con codigo " + this.id + ".");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al asignar el tramite con codigo "+ this.codigo + " al sector con codigo " + this.id + ".");
			notice.setNotice("negative");
		}
		return "/pages/sectores.xhtml?faces-redirect=true";
	}
	
	public String asignarDisplaySector() {
		JSONSectorDisplay jsectordisplay = new JSONSectorDisplay(this.id, this.displayId);
		String status = this.c.asignarDisplayoSector( jsectordisplay.toString(), "Administrador");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El display con identificador "+ this.displayId + " se asigno correctamente al sector con codigo " + this.id + ".");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al asignar el display con identificador "+ this.displayId + " al sector con codigo " + this.id + ".");
			notice.setNotice("negative");
		}
		return "/pages/sectores.xhtml?faces-redirect=true";
	}

	public String asignarPuestoSector() {
		JSONSectorPuesto jsectorpuesto = new JSONSectorPuesto(this.id,this.nombreMaquina);
		String status =this.c.asignarPuestoSector( jsectorpuesto.toString(), "ResponsableSector");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El puesto con nombre de maquina "+ this.nombreMaquina + " se asigno correctamente al sector con codigo " + this.id + ".");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al asignar el puesto con nombre de maquina "+ this.nombreMaquina + " al sector con codigo " + this.id + ".");
			notice.setNotice("negative");
		}
		return "/pages/sectores.xhtml?faces-redirect=true";
	}
	
	public String desasignarTramiteSector() {
		JSONSectorTramite jsectortramite = new JSONSectorTramite(this.codigo, this.id);
		String status = this.c.desasignarTramiteSector( jsectortramite.toString(), "ResponsableSector");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El tramite con codigo "+ this.codigo + " se desasigno correctamente al sector con codigo " + this.id + ".");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al desasignar el tramite con codigo "+ this.codigo + " al sector con codigo " + this.id + ".");
			notice.setNotice("negative");
		}
		return "/pages/sectores.xhtml?faces-redirect=true";
	}
	
	public String desasignarDisplaySector() {
		JSONSectorDisplay jsectordisplay = new JSONSectorDisplay(this.id, this.displayId);
		String status = this.c.desasignarDisplayoSector( jsectordisplay.toString(), "Administrador");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El display con identificador "+ this.displayId + " se desasigno correctamente al sector con codigo " + this.id + ".");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al desasignar el display con identificador "+ this.displayId + " al sector con codigo " + this.id + ".");
			notice.setNotice("negative");
		}
		return "/pages/sectores.xhtml?faces-redirect=true";
	}
	
	public String desasignarPuestoSector() {
		JSONSectorPuesto jsectorpuesto = new JSONSectorPuesto(this.id,this.nombreMaquina);
		String status =this.c.desasignarPuestoSector( jsectorpuesto.toString(), "ResponsableSector");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El puesto con nombre de maquina "+ this.nombreMaquina + " se desasigno correctamente al sector con codigo " + this.id + ".");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al desasignar el puesto con nombre de maquina "+ this.nombreMaquina + " al sector con codigo " + this.id + ".");
			notice.setNotice("negative");
		}
		return "/pages/sectores.xhtml?faces-redirect=true";
	}
	
	public List<JSONNumero> listarNumerosSector(){
		Map<String, String> params =FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		String idSector = params.get("id");
		return modeler.toJSONNumeros(c.listarNumerosSector(idSector, "Administrador"));
	}
	
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
}
