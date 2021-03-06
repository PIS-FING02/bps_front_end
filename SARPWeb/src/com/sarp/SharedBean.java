package com.sarp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.sarp.jsons.JSONSector;
import com.sarp.jsons.JSONTramite;

@ManagedBean(name = "shared")
@SessionScoped
public class SharedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public SharedBean() {
	}

	private String icon = "check";
	private String notice = "hidden";
	private String notice_title = "";
	private String notice_message = "";
	private String user = "";
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
		this.notice_message = notice_message;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}


	public void updateNotice(String status, String msgPositive) {
		if (status.equals("OK")) {
			setNotice_title("Esto es un mensaje de confirmación.");
			setNotice_message(msgPositive);
			setNotice("positive");
			setIcon("check");
		} else {
			setNotice_title("Han ocurrido error/es que impiden continuar.");
			setNotice_message(status.substring(7));
			setNotice("negative");
			setIcon("error");
		}
	}

	public void updateNoticeInfo(String msgInfo) {
		setNotice_title("Este es un mensaje de información.");
		setNotice_message(msgInfo);
		setNotice("info");
		setIcon("info");
	}

	public String redirect(String url) {
		clean();
		return "/pages/" + url + ".xhtml?faces-redirect=true";
	}

	public void clean() {
		this.notice = "";
		this.notice = "hidden";
		this.notice_message = "";
		this.notice_title = "";
	}

	public String redirectWithParam(String url, String params) {
		this.notice = "";
		this.notice = "hidden";
		this.notice_message = "";
		this.notice_title = "";
		return "/pages/" + url + ".xhtml?" + params + "&faces-redirect=true";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public void logout() {
		this.icon = "check";
		this.notice = "hidden";
		this.notice_title = "";
		this.notice_message = "";
		this.user = "";
		this.rolesMap.clear();

	}
}