package com.sarp;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.security.SecurityContextAssociation;


@ManagedBean(name = "loginBean", eager = true)
@ApplicationScoped
public class LoginBean {

	private String username;
	private String password;
	private String message;
	private String role;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
    public String Login() {
		try { 
	        message="";
	        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	        request.login(username, password);
	        if(request.isUserInRole("ADMIN")){
	        	role = "Administración";
	        	return "/pages/menu.xhtml?faces-redirect=true";
	        }
	        else if(request.isUserInRole("RESPSEC")){
	        	role= "Configurar Sector";
	            return "/pages/menu.xhtml?faces-redirect=true";
	        }
	        else if(request.isUserInRole("CONSULTOR")){
	        	role ="Consultas";
	            return "/pages/menu.xhtml?faces-redirect=true";
	        }
	        else if(request.isUserInRole("OPERADOR")){
	        	role = "Atención";
	        	return "/pages/menu.xhtml?faces-redirect=true";
	        }
	        else if(request.isUserInRole("OPERADORSR")){
	        	role = "Atención Senior";
	            return "/pages/menu.xhtml?faces-redirect=true";
	        }
	        else if(request.isUserInRole("RECEPCION")){
	        	role = "Recepción";
	            return "/pages/menu.xhtml?faces-redirect=true";
	        }
	        else {
	            message= "Either Login or Password is wrong";
	        }
	    } catch(Exception e) {
	        message= "Datos incorrectos!";
	    }
	    return null;
	}
    
    public String Logout(){
    	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	HttpSession session = request.getSession(false);
        SecurityContextAssociation.clearSecurityContext();
        session= request.getSession(false);
        if(session != null) {
        	session.invalidate();
        	System.out.println("Se cerro la sesion correctamente");
	
        }
        return "/pages/login.xhtml";
    }

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}