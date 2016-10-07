package com.sarp.controladores;

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

	public String altaPuesto() {
		try {
			return this.puestoFacade.alta();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
	}

	public String listarTramite() throws Exception {
		return this.tramiteFacade.listar();
	}

	public String altaTramite() throws Exception {
		return this.tramiteFacade.alta();
	}

	public String bajaTramite() {
		return this.tramiteFacade.baja();
	}

	public String modTramite() {
		return this.tramiteFacade.mod();
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
