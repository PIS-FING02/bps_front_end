package com.sarp;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONDisplay;


@ManagedBean(name = "display")
@ViewScoped
public class DisplayBean implements Serializable{


	private static final long serialVersionUID = 1L;
	public String id;
	private	ControladorREST c = new ControladorREST();
	private List<JSONDisplay> displays;
	private static final JSONModeler modeler = new JSONModeler();
	@ManagedProperty("#{sessionScope.shared}")
	public SharedBean shared;
	

	public SharedBean getShared() {
		return shared;
	}

	public void setShared(SharedBean shared) {
		this.shared = shared;
	}

	public String alta() throws Exception{
		JSONDisplay jdisplay = new JSONDisplay(this.id);
		System.out.println(jdisplay.toString());
		String status= c.altaDisplay(jdisplay.toString(), "ADMIN");
		shared.updateNotice(status, "El display con identificador "+ this.id + " se cre� correctamente.");
		return "/pages/displays.xhtml?faces-redirect=true";
	}
	
	public String baja(String id) {
		JSONDisplay jdisplay = new JSONDisplay(id);
		String status = c.bajaDisplay(jdisplay.toString(), "ADMIN");
		shared.updateNotice(status, "El display con identificador " + id + " se elimin� correctamente.");
		return "/pages/displays.xhtml?faces-redirect=true";
	}

	public List<JSONDisplay> listar() throws Exception {
		String response = c.listarDisplays("ADMIN");
		List<JSONDisplay> list;
		if (response.startsWith("ERROR")) {
			list = null;
			shared.updateNotice(response, "");
		} else {
			list =  modeler.toJSONDisplays(response);
			if (list.isEmpty())
				shared.updateNoticeInfo("No se encontraron displays en el sistema.");
		}
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
				shared.updateNoticeInfo("El sector con identificador " + sectorId + " no tiene ning�n display asignado.");
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
