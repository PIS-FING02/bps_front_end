package com.sarp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sarp.jsons.JSONSector;
import com.sarp.jsons.JSONTramite;

@ManagedBean(name = "shared", eager = true)
@SessionScoped
public class SharedBean {
	
	private static SharedBean instance = null;
	public SharedBean() {}
	
	public static SharedBean getInstance() {
		instance = instance != null ? instance : new  SharedBean();
		return instance;
	}

	private static String icon = "check";
	private static String notice = "hidden";
	private static String notice_title = "";
	private static String notice_message = "";
	private static String user = "";
	private HashMap<String, Boolean> rolesMap = new HashMap<String, Boolean>();
	private List<JSONSector> sectoresListBusqueda = new ArrayList<JSONSector>();
	private List<JSONSector> sectoresList;
	private List<JSONTramite> tramitesListBusqueda = new ArrayList<JSONTramite>();
	private List<JSONTramite> tramitesList;
	
	
	public HashMap<String, Boolean> getRolesMap() {
		return this.rolesMap;
	}

	public void setRol(String rol, Boolean val) {
    	this.rolesMap.put(rol, val);        
	}
	
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		SharedBean.icon = icon;
	}
	
	public void updateNotice(String status, String msgPositive, String msgNegative) {
		if (status.equals("OK")){
			setNotice_title("Esto es un mensaje de Confirmación.");
			setNotice_message(msgPositive);
			setNotice("positive");
			setIcon("check");
		} else {
			setNotice_title("Han ocurrido error/es que impiden continuar.");
			setNotice_message(msgNegative);
			setNotice("negative");
			setIcon("error");
		}
	}
	
	public void updateNoticeInfo(String msgInfo) {
		setNotice_title("Este es un mensaje de Informacion.");
		setNotice_message(msgInfo);
		setNotice("info");
		setIcon("info");
	}

	public String redirect(String url){
		clean();
		return "/pages/" + url + ".xhtml?faces-redirect=true";
	}

	public void clean(){
		SharedBean.notice = "";
		SharedBean.notice = "hidden";
		SharedBean.notice_message = "";
		SharedBean.notice_title = "";
	}

	public String redirectWithParam(String url, String param){
		SharedBean.notice = "";
		SharedBean.notice = "hidden";
		SharedBean.notice_message = "";
		SharedBean.notice_title = "";
		return "/pages/" + url + ".xhtml?" + param + "&faces-redirect=true";
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		SharedBean.user = user;
	}

	public List<JSONSector> getSectoresListBusqueda() {
		return this.sectoresListBusqueda;
	}

	public void setSectoresListBusqueda(List<JSONSector> sectoresListBusqueda) {
		this.sectoresListBusqueda = sectoresListBusqueda;
	}

	public List<JSONSector> getSectoresList() {
		return this.sectoresList;
	}

	public void setSectoresList(List<JSONSector> sectoresList) {
		this.sectoresList = sectoresList;
	}

	public List<JSONTramite> getTramitesListBusqueda() {
		return tramitesListBusqueda;
	}

	public void setTramitesListBusqueda(List<JSONTramite> tramitedListBusqueda) {
		this.tramitesListBusqueda = tramitedListBusqueda;
	}

	public List<JSONTramite> getTramitesList() {
		return tramitesList;
	}

	public void setTramitesList(List<JSONTramite> tramitesList) {
		this.tramitesList = tramitesList;
	}
}