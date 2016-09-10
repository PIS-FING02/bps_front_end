package com;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

//import com.controladores.ControladorREST;

@ManagedBean(name = "formulario", eager = true)
@RequestScoped
public class Formulario {
	
	private String login ;
	private String nombre ;
	private String apellido;
	private String email;
	private String contrasena;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void submit(){
		System.out.println("\nLogin: "+this.login +"\nNombre: "+this.nombre + "\nApellido: "+this.apellido+
				"\nEmail: "+this.email+"\nContraseña: "+this.contrasena);
		//ControladorREST c = new ControladorREST();
		System.out.println("Ejecutando controlador...");
		//c.Consumir();
	}
	
}
