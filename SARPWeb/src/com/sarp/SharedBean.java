package com.sarp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "shared", eager = true)
@SessionScoped
public class SharedBean {
	
	private static SharedBean instance = null;
	public SharedBean() {}
	
	public static SharedBean getInstance() {
		instance = instance != null ? instance : new  SharedBean();
		return instance;
	}
	
	private static String notice = "hidden";
	private static String notice_title = "";
	private static String notice_message = "";
	
	public String getNotice_message() {
		return notice_message;
	}

	public void setNotice_message(String notice_message) {
		SharedBean.notice_message = notice_message;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		SharedBean.notice_title = notice_title;
	}
	
	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		SharedBean.notice = notice;
	}
	
	public String redirect(String url){
		SharedBean.notice = "hidden";
		SharedBean.notice_message = "";
		SharedBean.notice_title = "";
		return "/pages/" + url + ".xhtml?faces-redirect=true";
	}
}