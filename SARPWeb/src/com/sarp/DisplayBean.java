package com.sarp;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONDisplay;


@ManagedBean(name = "display", eager = true)
@ViewScoped
public class DisplayBean {

	public String id;
	private	ControladorREST c = new ControladorREST();
	private List<JSONDisplay> displays;
	private static final JSONModeler modeler = new JSONModeler();
	public SharedBean shared = SharedBean.getInstance();

	public String alta() throws Exception{
		JSONDisplay jdisplay = new JSONDisplay(this.id);
		System.out.println(jdisplay.toString());
		String status= c.altaDisplay(jdisplay.toString(), "ADMIN");
		shared.updateNotice(status, "El display con identificador "+ this.id + " se creó correctamente.", 
				"Ocurrió un error al crear el display.");
		return "/pages/displays.xhtml?faces-redirect=true";
	}
	
	public String baja(String id) {
		JSONDisplay jdisplay = new JSONDisplay(id);
		String status = c.bajaDisplay(jdisplay.toString(), "ADMIN");
		shared.updateNotice(status, "El display con identificador " + id + " se eliminó correctamente.", 
				"Ocurrió un error al eliminar el display.");
		return "/pages/displays.xhtml?faces-redirect=true";
	}

	public List<JSONDisplay> listar() throws Exception {
		List<JSONDisplay> list =  modeler.toJSONDisplays(c.listarDisplays("ADMIN"));
		if (list.isEmpty())
			shared.updateNoticeInfo("No se encontraron displays en el sistema.");
		return list;
	}
	
	public List<JSONDisplay> listarParaSector(String sectorId) throws Exception {
		shared.clean();
		if (shared.getRolesMap().get("RESPSEC")) {
			List<JSONDisplay> list = modeler.toJSONDisplays(c.listarDisplaysParaSector(sectorId, "RESPSEC", shared.getUser()));
			if (list.isEmpty())
				shared.updateNoticeInfo("No se encontraron displays disponibles.");
			return list;
		} else {
			return null;
		}
	}

	public List<JSONDisplay> listarDisplaysDeSector(String sectorId) throws Exception {
		shared.clean();
		if (sectorId == "")
			return null;
		else {
			List<JSONDisplay> list = modeler.toJSONDisplays(c.listarDisplaysSector(sectorId, "RESPSEC"));
			if (list.isEmpty())
				shared.updateNoticeInfo("El sector con identificador " + sectorId + " no tiene ningun display asignado.");
			return list;
		}
	}
	
	public void setDisplays(List<JSONDisplay> displays) {
		this.displays = displays;
	}

	public List<JSONDisplay> getDisplays(){
		return this.displays;
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String string) {
		this.id = string;
	}
}
