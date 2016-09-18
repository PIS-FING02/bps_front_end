package com.sarp.controladores;

import java.io.IOException;

import com.sarp.facade.FuncionarioFacade;


public class ControladorREST {
	
	FuncionarioFacade fs;
	
	public ControladorREST(){
		this.fs = new FuncionarioFacade();
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
