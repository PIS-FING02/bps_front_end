package com.sarp.controllers;

import com.sarp.facade.PuestoFacade;
import com.sarp.facade.SectorFacade;
import com.sarp.facade.TramiteFacade;
import com.sarp.jsons.JSONNumero;
import com.sarp.facade.AttentionsFacade;
import com.sarp.facade.DisplayFacade;

public class ControladorREST {

	PuestoFacade puestoFacade;
	TramiteFacade tramiteFacade;
	DisplayFacade displayFacade;
	SectorFacade sectorFacade;
	AttentionsFacade attentionsFacade;
	
	public ControladorREST(){
		this.puestoFacade = new PuestoFacade();
		this.tramiteFacade = new TramiteFacade();
		this.displayFacade = new DisplayFacade();
		this.sectorFacade = new SectorFacade();
		this.attentionsFacade = new AttentionsFacade();
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

	public String asignarTramite(String input, String userRol) {
		return this.puestoFacade.asignarTramite(input, userRol);
	}
	
	//TRAMITES
	public String listarTramite(String userRol) throws Exception {
		return this.tramiteFacade.tramitesAll(userRol);
	}

	public String listarTramiteSector(String input, String userRol) throws Exception {
		return this.tramiteFacade.tramitesSector(input, userRol);
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
	
	//SECTORES
	
		public String importarSectoreGafu(String userRol) throws Exception {
			return this.sectorFacade.importarSectoresGafu(userRol);
		}
		
		public String listarSectores(String userRol) throws Exception {
			return this.sectorFacade.sectoresAll(userRol);
		}


	//ATENCION

	public String abrirPuesto(String input, String userRol){
		return this.attentionsFacade.abrir(input, userRol);
	}
	
	public String cerrarPuesto(String input, String userRol){
		return this.attentionsFacade.cerrar(input, userRol);
	}
	
	public String asignarTramiteSector(String input, String userRol) throws Exception {
		return this.sectorFacade.asignarTramiteSector(input, userRol);
	}
	
	public String asignarPuestoSector(String input, String userRol) throws Exception {
		return this.sectorFacade.asignarPuestoSector(input, userRol);
	}


	public String asignarDisplayoSector(String input, String userRol) {
		return this.sectorFacade.asignarDisplaySector(input,userRol);
		
	}

	public String llamarNumero(String input, String userRol){
		return this.attentionsFacade.llamarNumero(input, userRol);
	}
}
