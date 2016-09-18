package com;

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
            if(request.isUserInRole("ADMIN"))
                return "/pages/formulario.xhtml?faces-redirect=true";
            else if(request.isUserInRole("RESPSEC"))
                return "/pages/respSector.xhtml?faces-redirect=true";
            else if(request.isUserInRole("CONSULTOR"))
                return "/pages/consultor.xhtml?faces-redirect=true";
            else if(request.isUserInRole("OPERADOR"))
                return "/pages/operador.xhtml?faces-redirect=true";
            else if(request.isUserInRole("OPERADORSR"))
                return "/pages/operadorsr.xhtml?faces-redirect=true";
            else if(request.isUserInRole("RECEPCION"))
                return "/pages/recepcion.xhtml?faces-redirect=true";
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
}
