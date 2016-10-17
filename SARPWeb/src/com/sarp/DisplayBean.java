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

	//Atributo para mensaje de errores
	public String error = "hidden";
	public String error_message = "";
	
	
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

	public void alta() throws Exception{
		JSONDisplay jdisplay = new JSONDisplay(this.id);
		System.out.println(jdisplay.toString());
		String status= c.altaDisplay(jdisplay.toString(), "Administrador");
		if (status.equals("OK")){
			this.error_message="El display " + this.id + " se creo correctamente";
		}else{
			this.error_message = "Ocurrio un error al crear el display " + this.id;
		}
		this.error = "show";
	}
	
	public void baja() {
		JSONDisplay jdisplay = new JSONDisplay(this.id);
		String status = c.bajaDisplay(jdisplay.toString(), "Administrador");
		if (status.equals("OK")){
			this.error_message="El display " + this.id + " se dio de baja correctamente";
		}else{
			this.error_message = "Ocurrio un error al eliminar el display " + this.id;
		}
		this.error = "show";
		
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
	
	public String hideError(){
		this.error="hidden";
		return "/pages/admin.xhtml";
	}
}
