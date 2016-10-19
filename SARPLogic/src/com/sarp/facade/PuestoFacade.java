package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class PuestoFacade {

	public static final String URL_REST_FULL = "http://52.52.100.160:8080/SARPService/adminService/puesto";
	public static final String URL_GET_ALL = "http://52.52.100.160:8080/SARPService/adminService/listarPuestos";
	public static final String URL_ASIG_TRAMITE = "http://52.52.100.160:8080/SARPService/adminService/asignarTramitePuesto";
	public static final String URL_TRAMITES_ASIGNABLES = "http://52.52.100.160:8080/SARPService/adminService/listarTramitesPosibles?nombreMaquina=";
	
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

	public String puestosAll(String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_GET_ALL, userRol);
	}

	public String asignarTramite(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_ASIG_TRAMITE, input, userRol);
	}	

	public String listarTramitesAsignables(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_TRAMITES_ASIGNABLES + input, userRol);
	}	
}
