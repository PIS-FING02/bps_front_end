package com;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


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
                return "/pages/page1.xhtml";
            else if(request.isUserInRole("USER"))
                return "/pages/page2.xhtml";
            else {
                message= "Either Login or Password is wrong";
                return "/loginError.xhtml";
            }

        } catch(Exception e) {
            message= "Either Login or Password is wrong";
        }
        return null;
    }
	
	
}
