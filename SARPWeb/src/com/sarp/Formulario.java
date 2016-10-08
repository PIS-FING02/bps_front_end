package com.sarp;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sarp.controllers.ControladorREST;



//import com.controladores.ControladorREST;

@ManagedBean(name = "formulario", eager = true)
@RequestScoped
public class Formulario {
	
	private String tramite ;
	private String nombre ;
	private String numero;
	private String resultado;
	private String sector;
	private String resultado2;



	public String getTramite() {
		return tramite;
	}

	public void setTramite(String tramite) {
		this.tramite = tramite;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}
	
	public  void submit(){
//		ControladorREST c = new ControladorREST();
		System.out.println("------------------------------------------------");
//		try {
//			c.agregar(sector);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		this.sector="";


	}
	
	public  void listar(){
		System.out.println("\nTramite: "+this.tramite +"\nNombre: "+this.nombre + "\nNumero: "+this.numero);
		ControladorREST c = new ControladorREST();
		System.out.println("Ejecutando controlador...");
		this.resultado= c.consumir();

	}
	
	public  void submitTramites(){
		ControladorREST c = new ControladorREST();
		System.out.println("Ejecutando controlador...");
		c.agregar(tramite,sector);
		this.sector="";


	}
	
	public  void listarTramites(){
		System.out.println("\nTramite: "+this.tramite +"\nNombre: "+this.nombre + "\nNumero: "+this.numero);
		ControladorREST c = new ControladorREST();
		System.out.println("Ejecutando controlador...");
		this.resultado2= c.consumirTramites();

	}


	public String getResultado2() {
		return resultado2;
	}


	public void setResultado2(String resultado2) {
		this.resultado2 = resultado2;
	}



	
}
