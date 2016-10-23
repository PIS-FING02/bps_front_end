package com.sarp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.security.SecurityContextAssociation;


@ManagedBean(name = "loginBean", eager = true)
@SessionScoped
public class LoginBean {

	private String username = "Bienvenido";
	private String password;
	private String message;
	private String roles = "";
	
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
	
	public String getRoles() {
		return this.roles;
	}
	
	public void addRol(String rol, HttpServletRequest request) {
        if(request.isUserInRole(rol))
        	roles += rol + " ";
	}
	
    public String Login() {
		try { 
	        message="";
	        roles = "";	        
	        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	        request.login(username, password);
	        addRol("ADMIN", request);
	        addRol("RESPSEC", request);
	        addRol("CONSULTOR", request);
	        addRol("OPERADOR", request);
	        addRol("OPERADORSR", request);
	        addRol("RECEPCION", request);
	        if (roles == "")
	            message= "Either Login or Password is wrong";
	        else if (roles.equals("ADMIN "))	
	        	return "/pages/admin.xhtml?faces-redirect=true";
        	else if (roles.equals("RESPSEC "))	
        		return "/pages/respSector.xhtml?faces-redirect=true";
        	else if (roles.equals("CONSULTOR "))	
        		return "/pages/consultor.xhtml?faces-redirect=true";
        	else if (roles.equals("OPERADOR "))	
        		return "/pages/operador.xhtml?faces-redirect=true";
        	else if (roles.equals("OPERADORSR "))	
        		return "/pages/operador.xhtml?faces-redirect=true";
        	else if (roles.equals("RECEPCION "))	
        		return "/pages/recepcion.xhtml?faces-redirect=true";
        	else 
        		return "/pages/menu.xhtml?faces-redirect=true";
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
        	setUsername("Bienvenido");
        	session.invalidate();
        	System.out.println("Se cerro la sesion correctamente");
	
        }
        return "/pages/login.xhtml?faces-redirect=true";
    }
}
