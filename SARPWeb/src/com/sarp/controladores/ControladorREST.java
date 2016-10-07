package com.sarp.controladores;

import java.io.IOException;

import com.sarp.facade.FuncionarioFacade;
import com.sarp.facade.PuestoFacade;
import com.sarp.facade.TramiteFacade;


public class ControladorREST {

	FuncionarioFacade fs;
	PuestoFacade puestoFacade;
	TramiteFacade tramiteFacade;
	
	public ControladorREST(){
		this.fs = new FuncionarioFacade();
		this.puestoFacade = new PuestoFacade();
		this.tramiteFacade = new TramiteFacade();
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

	public String altaTramite() {
		return this.tramiteFacade.alta();
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
