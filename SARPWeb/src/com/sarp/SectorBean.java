package com.sarp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONNumero;
import com.sarp.jsons.JSONSector;
import com.sarp.jsons.JSONSectorDisplay;
import com.sarp.jsons.JSONSectorPuesto;
import com.sarp.jsons.JSONSectorTramite;

@ManagedBean(name = "sector", eager = true)
@ViewScoped
public class SectorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private String ruta;
	
	//Atributo Tramite
	private String codigo;
	
	//Artributo Puesto
	private String nombreMaquina;
	
	//Atributo Display
	private String displayId;
	
	//Atributo Busqueda
	private String searchString;

	private	ControladorREST c = new ControladorREST();
	private static final JSONModeler modeler = new JSONModeler();
	
	@ManagedProperty("#{sessionScope.shared}")
	public SharedBean shared;
	
	

	public SharedBean getShared() {
		return shared;
	}

	public void setShared(SharedBean shared) {
		this.shared = shared;
	}

	public List<JSONSector> listar() throws Exception {
		if (shared.getRolesMap().get("ADMIN")) {
			List<JSONSector> list = modeler.toJSONSectores(c.listarSectores("ADMIN", shared.getUser()));
			shared.setSectoresList(list);
			if (list.isEmpty())
				shared.updateNoticeInfo("No se enontraron sectores en el sistema.");
			return shared.getSectoresList();

		} else if (shared.getRolesMap().get("RESPSEC")) {
				List<JSONSector> list = modeler.toJSONSectores(c.listarSectores("RESPSEC", shared.getUser()));	
			shared.setSectoresList(list);
			if (list.isEmpty())
				shared.updateNoticeInfo("No tienes sectores asignados.");
			return shared.getSectoresList();
		} else if (shared.getRolesMap().get("CONSULTOR")) {
			List<JSONSector> list = modeler.toJSONSectores(c.listarSectores("CONSULTOR", shared.getUser()));	
			shared.setSectoresList(list);
			if (list.isEmpty())
				shared.updateNoticeInfo("No tienes sectores asignados.");
			return shared.getSectoresList();
		} else {
			shared.updateNoticeInfo("No tienes permisos suficientes.");
			return null;
		}
	}

	public List<JSONSector> listarDeUsuario() throws Exception {
		if (shared.getRolesMap().get("RESPSEC")) {
			List<JSONSector> list = modeler.toJSONSectores(c.listarSectores("RESPSEC", shared.getUser()));	
			shared.setSectoresList(list);
			if (list.isEmpty())
				shared.updateNoticeInfo("No tienes sectores asignados.");
			return shared.getSectoresList();
		} else if (shared.getRolesMap().get("CONSULTOR")) {
			List<JSONSector> list = modeler.toJSONSectores(c.listarSectores("CONSULTOR", shared.getUser()));	
			shared.setSectoresList(list);
			if (list.isEmpty())
				shared.updateNoticeInfo("No tienes sectores asignados.");
			return shared.getSectoresList();
		} else {
			shared.updateNoticeInfo("No tienes permisos suficientes.");
			return null;
		}
	}
	
	public String listarSectoresBusqueda(String page){
		List<JSONSector> sectoresListBusqueda = new ArrayList<JSONSector>();
		Iterator<JSONSector> iter = shared.getSectoresList().iterator();
		while(iter.hasNext()){
			JSONSector sectorIter = iter.next();
           	if((sectorIter.getNombre().toLowerCase().contains(this.searchString.toLowerCase()))||
           	sectorIter.getRuta().toLowerCase().contains(this.searchString.toLowerCase())||
           	sectorIter.getSectorId().toLowerCase().contains(this.searchString.toLowerCase())){
           		sectoresListBusqueda.add(sectorIter);
           	}
	    }
		shared.setSectoresListBusqueda(sectoresListBusqueda);
		return ("/pages/" + page +  ".xhtml?busqueda=true&faces-redirect=true");
	}
	
	public List<JSONSector> listarResultadoBusqueda(){
		return shared.getSectoresListBusqueda();
	}
	
	public String importarSecotesGAFU(){
		String status = this.c.importarSectoreGafu("ADMIN");
		shared.updateNotice(status, "Los sectores se actualizaron correctamente.");
		return "/pages/admin.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String asignarTramiteSector() throws Exception {
		JSONSectorTramite jsectortramite = new JSONSectorTramite(this.codigo, this.id);
		String status = this.c.asignarTramiteSector(jsectortramite.toString(), "RESPSEC");
		shared.updateNotice(status, "El trámite con código "+ this.codigo + " se asignó correctamente al sector con código " + this.id + ".");
		return "/pages/sectores.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String asignarDisplaySector() throws Exception {
		JSONSectorDisplay jsectordisplay = new JSONSectorDisplay(this.id, this.displayId);
		String status = this.c.asignarDisplayoSector( jsectordisplay.toString(), "ADMIN");
		shared.updateNotice(status, "El display con identificador "+ this.displayId + " se asignó correctamente al sector con código " + this.id + ".");
		return "/pages/sectores.xhtml?busqueda=false&faces-redirect=true";
	}

	public String asignarPuestoSector() throws Exception {
		JSONSectorPuesto jsectorpuesto = new JSONSectorPuesto(this.id, this.nombreMaquina);
		String status = this.c.asignarPuestoSector(jsectorpuesto.toString(), "RESPSEC");
		shared.updateNotice(status, "El puesto con nombre de máquina "+ this.nombreMaquina + " se asignó correctamente al sector con código " + this.id + ".");
		return "/pages/sectores.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String desasignarTramiteSector() {
		JSONSectorTramite jsectortramite = new JSONSectorTramite(this.codigo, this.id);
		String status = this.c.desasignarTramiteSector( jsectortramite.toString(), "RESPSEC");
		shared.updateNotice(status, "El trámite con código "+ this.codigo + " se desasignó correctamente del sector con código " + this.id + ".");
		return "/pages/sectores.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String desasignarDisplaySector() {
		JSONSectorDisplay jsectordisplay = new JSONSectorDisplay(this.id, this.displayId);
		String status = this.c.desasignarDisplayoSector( jsectordisplay.toString(), "ADMIN");
		shared.updateNotice(status, "El display con identificador "+ this.displayId + " se desasignó correctamente del sector con código " + this.id + ".");
		return "/pages/sectores.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String desasignarPuestoSector() {
		JSONSectorPuesto jsectorpuesto = new JSONSectorPuesto(this.id,this.nombreMaquina);
		String status =this.c.desasignarPuestoSector( jsectorpuesto.toString(), "RESPSEC");
		shared.updateNotice(status, "El puesto con nombre de máquina "+ this.nombreMaquina + " se desasignó correctamente al sector con código " + this.id + ".");
		return "/pages/sectores.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public List<JSONNumero> listarNumerosSector() {
		shared.clean();
		Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		String idSector = params.get("id");
		if (idSector != null) {
			List<JSONNumero> list = modeler.toJSONNumeros(c.listarNumerosSector(idSector, "ADMIN"));
			if (list == null || list.isEmpty()) 
				shared.updateNoticeInfo("No se encontraron números en el sistema para el sector con identificador " + idSector + " .");
			return list;
		} else
			return null;
	}

	public List<JSONSector> listarSectoresDesvio() throws Exception{
		if (shared.getRolesMap().get("OPERADOR"))
			return modeler.toJSONSectores(c.listarSectoresDesvio(this.id, "OPERADOR"));
		else
			return modeler.toJSONSectores(c.listarSectoresDesvio(this.id, "OPERADOR"));	
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

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
}
