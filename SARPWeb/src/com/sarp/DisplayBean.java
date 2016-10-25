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
	public SharedBean notice = SharedBean.getInstance();

	public String alta() throws Exception{
		JSONDisplay jdisplay = new JSONDisplay(this.id);
		System.out.println(jdisplay.toString());
		String status= c.altaDisplay(jdisplay.toString(), "Administrador");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El display con identificador "+ this.id + " se creo correctamente.");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al crear el display.");
			notice.setNotice("negative");
		}
		return "/pages/displays.xhtml?faces-redirect=true";
	}
	
	public String baja(String id) {
		JSONDisplay jdisplay = new JSONDisplay(id);
		String status = c.bajaDisplay(jdisplay.toString(), "Administrador");
		if (status.equals("OK")){
			notice.setNotice_title("Esto es un mensaje de Confirmación.");
			notice.setNotice_message("El display con identificador " + id + " se elimino correctamente.");
			notice.setNotice("positive");
		} else {
			notice.setNotice_title("Han ocurrido error/es que impiden continuar.");
			notice.setNotice_message("Ocurrio un error al eliminar el display.");
			notice.setNotice("negative");
		}
		return "/pages/displays.xhtml?faces-redirect=true";
	}

	public List<JSONDisplay> listar() throws Exception{
		return modeler.toJSONDisplays(c.listarDisplays("Administrador"));
	}

	public List<JSONDisplay> listarDisplaysDeSector(String sectorId) throws Exception{
		if (sectorId == "")
			return null;
		else
			return modeler.toJSONDisplays(c.listarDisplaysSector(sectorId, "ResponsableSector"));
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
