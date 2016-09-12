package com.controladores;

import java.io.IOException;

import com.logica.FuncionariosService;

public class ControladorREST {
	
	FuncionariosService fs;
	
	public ControladorREST(){
		this.fs = new FuncionariosService();
	}
	
	public String Consumir(){
		return this.fs.ConsumirServicio();
	}
	
	public void Agregar(String sector) throws IOException{
		this.fs.AgregarSector(sector);
	}

	public void Agregar(String tramite, String sector) {
		this.fs.AgregarTramite(tramite,sector);
	}


	public String ConsumirTramites() {
		return this.fs.ConsumirTramite();
	}
}
