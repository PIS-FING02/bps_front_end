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

	//TRAMITES
	public String listarTramite(String userRol) throws Exception {
		return this.tramiteFacade.tramitesAll(userRol);
	}

	public String altaTramite(String input, String userRol) throws Exception {
		return this.tramiteFacade.alta(input,  userRol);
}

	public String bajaTramite(String input, String userRol) {
		return this.tramiteFacade.baja(input, userRol);
	}

	public String modTramite(String input, String userRol) {
		return this.tramiteFacade.mod(input, userRol);
	}
	
	//DISPLAYS
	public String altaDisplay(String input, String userRol) throws Exception {
		return this.displayFacade.alta(input, userRol);
	}
	
	public String bajaDisplay(String input, String userRol) throws Exception {
		return this.displayFacade.baja(input, userRol);
	}
	
	public String modificarDisplay(String input, String userRol) throws Exception {
		return this.displayFacade.mod(input, userRol);
	}	

	public String listarDisplays(String userRol) throws Exception {
		return this.displayFacade.displaysAll(userRol);
	}
}
