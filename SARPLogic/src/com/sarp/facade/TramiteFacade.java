package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class TramiteFacade {

	public static final String URL_REST_FULL = "http://52.52.100.160:8080/SARPService/adminService/tramite";
	public static final String URL_GET_ALL = "http://52.52.100.160:8080/SARPService/adminService/listarTramites";
	public static final String URL_GET_FROM_SECTOR = "http://52.52.100.160:8080/SARPService/adminService/listarTramitesSector?sectorId=";
	public static final String URL_GET_FROM_RECEPCION = "http://52.52.100.160:8080/SARPService/attentionsService/tramitesRecepcion";
	public static final String URL_GET_FROM_PUESTO = "http://52.52.100.160:8080/SARPService/adminService/listarTramitesPuesto?nombreMaquina=";
	
	public String alta(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_REST_FULL, input, userRol);
	}

	public String baja(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_REST_FULL, input, userRol);
	}
	
	public String mod(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_REST_FULL, input, userRol);
	}	

	public String tramitesAll(String userRol, String user) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_ALL, userRol, user);
	}

	public String tramitesSector(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_GET_FROM_SECTOR + input, userRol);
	}

	public String tramitesRecepcion(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_GET_FROM_RECEPCION, userRol, input);
	}

	public String tramitesPuesto(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_GET_FROM_PUESTO + input, userRol, input);
	}
}