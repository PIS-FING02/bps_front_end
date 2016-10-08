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


	//PUESTOS
	public String listarPuestos(String userRol) throws Exception {
		return this.puestoFacade.puestosAll(userRol);
	}

	public String altaPuesto(String input, String userRol) throws Exception {
		return this.puestoFacade.alta(input,  userRol);
}

	public String bajaPuesto(String input, String userRol) {
		return this.puestoFacade.baja(input, userRol);
	}

	public String modPuesto(String input, String userRol) {
		return this.puestoFacade.mod(input, userRol);
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
