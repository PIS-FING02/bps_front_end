package com.controladores;

import com.logica.FuncionariosService;

public class ControladorREST {
	
	FuncionariosService fs;
	
	public ControladorREST(){
		this.fs = new FuncionariosService();
	}
	
	public void Consumir(){
		this.fs.ConsumirServicio();
	}
	
}
