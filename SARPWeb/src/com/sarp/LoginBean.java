package com.sarp;

import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.security.SecurityContextAssociation;


@ManagedBean(name = "loginBean", eager = true)
@SessionScoped
public class LoginBean {

	private String username;
	private String usernameHeader = "Bienvenido";
	private String password;
	private String message;
	private String roles = "";
	private Boolean loggedIn = false;
	public SharedBean shared = SharedBean.getInstance();
	
	public String getUsernameHeader() {
		return usernameHeader;
	}

	public void setUsernameHeader(String usernameHeader) {
		this.usernameHeader = usernameHeader;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

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
        if(request.isUserInRole(rol)){
        	roles += rol + " ";
        	shared.setRol(rol, true);
        } else {
        	shared.setRol(rol, false);      	
        }
	}
	
    public String Login() {
		try { 
	        message="";
	        roles = "";	        
	        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	        request.login(username, password);
	        this.usernameHeader = this.username;
	        shared.setUser(this.username);
	        addRol("ADMIN", request);
	        addRol("RESPSEC", request);
	        addRol("CONSULTOR", request);
	        addRol("OPERADOR", request);
	        addRol("OPERADORSR", request);
	        addRol("RECEPCION", request);

	        if (roles == ""){
	            message= "Either Login or Password is wrong";
	        }else if (roles.equals("ADMIN ")){
	        	this.loggedIn = true;
	        	return "/pages/admin.xhtml?faces-redirect=true";
	        }else if (roles.equals("RESPSEC "))	{
	        	this.loggedIn = true;
        		return "/pages/respSector.xhtml?faces-redirect=true";
	        }else if (roles.equals("CONSULTOR ")){
	        	this.loggedIn = true;
        		return "/pages/consultor.xhtml?faces-redirect=true";
	        }else if (roles.equals("OPERADOR ")){
	        	this.loggedIn = true;
        		return "/pages/operador.xhtml?faces-redirect=true";
			}else if (roles.equals("OPERADORSR ")){
				this.loggedIn = true;
        		return "/pages/operador.xhtml?faces-redirect=true";
    		}else if (roles.equals("RECEPCION ")){
    			this.loggedIn = true;
        		return "/pages/recepcion.xhtml?faces-redirect=true";
    		}else{
    			this.loggedIn = true;
        		return "/pages/menu.xhtml?faces-redirect=true";
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
        	setUsernameHeader("Bienvenido");
        	session.invalidate();
        	System.out.println("Se cerro la sesion correctamente");        	
        }
        this.loggedIn = false;
        return "/pages/login.xhtml?faces-redirect=true";
    }
}
