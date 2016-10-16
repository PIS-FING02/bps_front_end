package com.sarp;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONDisplay;
import com.sarp.jsons.JSONTramite;

@ManagedBean(name = "display", eager = true)
@ViewScoped
public class DisplayBean {

	public String id;
	private	ControladorREST c = new ControladorREST();
	private List<JSONDisplay> displays;
	private static final JSONModeler modeler = new JSONModeler();

	public void alta() throws Exception{
		JSONDisplay jdisplay = new JSONDisplay(this.id);
		System.out.println(jdisplay.toString());
		c.altaDisplay(jdisplay.toString(), "Administrador");
	}
	
	public void baja() throws Exception{
		JSONDisplay jdisplay = new JSONDisplay(this.id);
		c.bajaDisplay(jdisplay.toString(), "Administrador");
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
