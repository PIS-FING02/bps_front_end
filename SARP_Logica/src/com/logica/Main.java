package com.logica;

import java.io.IOException;

import com.controladores.ControladorREST;

public class Main {

	public static void main(String[] args) throws IOException {
		ControladorREST c = new ControladorREST();
		String resultado = c.Consumir();
		System.out.println(resultado);
		c.Agregar("prueba");
		
	
		
	}

}
