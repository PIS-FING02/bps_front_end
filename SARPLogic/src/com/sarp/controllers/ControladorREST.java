package com.sarp.controllers;

import java.io.IOException;

import com.sarp.facade.FuncionarioFacade;
import com.sarp.facade.PuestoFacade;
import com.sarp.facade.TramiteFacade;
import com.sarp.facade.DisplayFacade;

public class ControladorREST {

	FuncionarioFacade fs;
	PuestoFacade puestoFacade;
	TramiteFacade tramiteFacade;
	DisplayFacade displayFacade;
	
	public ControladorREST(){
		this.fs = new FuncionarioFacade();
		this.puestoFacade = new PuestoFacade();
		this.tramiteFacade = new TramiteFacade();
		this.displayFacade = new DisplayFacade();
	}

	public String altaPuesto(Object input, String userRol) {
		try {
			return this.puestoFacade.alta(input.toString(),  userRol);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
	}

	public String listarTramite(String userRol) throws Exception {
		return this.tramiteFacade.tramitesAll(userRol);
	}

	public String altaTramite(Object input, String userRol) throws Exception {
		return this.tramiteFacade.alta(input.toString(),  userRol);
}

	public String bajaTramite(Object input, String userRol) {
		return this.tramiteFacade.baja(input.toString(), userRol);
	}

	public String modTramite(Object input, String userRol) {
		return this.tramiteFacade.mod(input.toString(), userRol);
}
	
	public String altaDisplay() throws Exception {
		return this.displayFacade.alta();
	}
	
	public String modificarDisplay() throws Exception {
		return this.displayFacade.mod();
	}
	
	public String bajaDisplay() throws Exception {
		return this.displayFacade.baja();
	}
	
	public String consumir(){
		return this.fs.consumirServicio();
	}
	
	public void agregar(String sector) throws IOException{
		this.fs.agregarSector(sector);
	}

	public void agregar(String tramite, String sector) {
		this.fs.agregarTramite(tramite,sector);
	}

	public String consumirTramites() {
		return this.fs.consumirTramite();
	}
}
