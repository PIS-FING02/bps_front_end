package com.sarp;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONDisplay;

@ManagedBean(name = "display", eager = true)
@SessionScoped
public class DisplayBean {

	public String id;
	private	ControladorREST c = new ControladorREST();
	private List<JSONDisplay> displays;
	private static final JSONModeler modeler = new JSONModeler();

	//Atributo para mensaje de errores
	public String notice = "hidden";
	public String notice_title = "";
	public String notice_message = "";
	
	public String getNotice_message() {
		return notice_message;
	}

	public void setNotice_message(String notice_message) {
		this.notice_message = notice_message;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	
	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}
	
	public String hideError(){
		this.notice="hidden";
		return "/pages/admin.xhtml";
	}

	public String alta() throws Exception{
		JSONDisplay jdisplay = new JSONDisplay(this.id);
		System.out.println(jdisplay.toString());
		String status= c.altaDisplay(jdisplay.toString(), "Administrador");
		if (status.equals("OK")){
			this.notice_title = "Esto es un mensaje de Confirmación.";
			this.notice_message = "El display con identificador "+ this.id + " se creo correctamente.";
			this.notice = "positive";
		} else {
			this.notice_title = "Han ocurrido error/es que impiden continuar.";
			this.notice_message = "Ocurrio un error al crear el display.";
			this.notice = "negative";
		}
		this.id = "";
		return "/pages/displays.xhtml?faces-redirect=true";
	}
	
	public String baja(String id) {
		JSONDisplay jdisplay = new JSONDisplay(id);
		String status = c.bajaDisplay(jdisplay.toString(), "Administrador");
		if (status.equals("OK")){
			this.notice_title = "Esto es un mensaje de Confirmación.";
			this.notice_message = "El display con identificador " + id + " se elimino correctamente.";
			this.notice = "positive";
		} else {
			this.notice_title = "Han ocurrido error/es que impiden continuar.";
			this.notice_message = "Ocurrio un error al eliminar el tramite.";
			this.notice = "negative";
		}
		this.id = "";
		return "/pages/displays.xhtml?faces-redirect=true";
	}

	public List<JSONDisplay> listar() throws Exception{
		return modeler.toJSONDisplays(c.listarDisplays("Administrador"));
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
