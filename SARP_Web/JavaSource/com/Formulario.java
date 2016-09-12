package com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.controladores.ControladorREST;

//import com.controladores.ControladorREST;

@ManagedBean(name = "formulario", eager = true)
@RequestScoped
public class Formulario {
	
	private String tramite ;
	private String nombre ;
	private String numero;
	private String resultado;



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


	public  void submit(){
		System.out.println("\nTramite: "+this.tramite +"\nNombre: "+this.nombre + "\nNumero: "+this.numero);
		ControladorREST c = new ControladorREST();
		System.out.println("Ejecutando controlador...");
		this.resultado= c.Consumir();

	}


	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}
