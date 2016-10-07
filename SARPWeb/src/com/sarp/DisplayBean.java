package com.sarp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sarp.controladores.ControladorREST;

@ManagedBean(name = "display", eager = true)
@RequestScoped
public class DisplayBean {

	public Integer displayId;
	public String rutaArchivo;
	
	public Integer getDisplayId() {
		return displayId;
	}

	public void setDisplayId(Integer displayId) {
		this.displayId = displayId;
	}
	
	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	
	public  void alta() throws Exception{
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println(rutaArchivo);

		ControladorREST c = new ControladorREST();
		c.altaDisplay();
	}
	
	public  void modificar() throws Exception{
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println(displayId);
		System.out.println(rutaArchivo);
		
		ControladorREST c = new ControladorREST();
		c.modificarDisplay();
	}
	
	public  void baja() throws Exception{
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println(displayId);
		
		ControladorREST c = new ControladorREST();
		c.bajaDisplay();
	}


}
