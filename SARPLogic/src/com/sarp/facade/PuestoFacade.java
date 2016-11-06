package com.sarp.facade;

import java.io.IOException;

import com.sarp.facade.client.RestClient;

public class PuestoFacade {

	public static final String URL_REST_FULL = "http://52.52.100.160:8080/SARPService/adminService/puesto";
	public static final String URL_GET_ALL = "http://52.52.100.160:8080/SARPService/adminService/listarPuestos";
	public static final String URL_GET_ALL_SECTOR = "http://52.52.100.160:8080/SARPService/adminService/listarPuestos";
	public static final String URL_ASIG_TRAMITE = "http://52.52.100.160:8080/SARPService/adminService/asignarTramitePuesto";
	public static final String URL_TRAMITES_ASIGNABLES = "http://52.52.100.160:8080/SARPService/adminService/listarTramitesPosibles?nombreMaquina=";
	public static final String URL_DESASIG_TRAMITE = "http://52.52.100.160:8080/SARPService/adminService/desasignarTramitePuesto";
	public static final String URL_PUESTOS_SECTOR = "http://52.52.100.160:8080/SARPService/adminService/listarPuestosSector";

	
	public String alta(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		String status = restClient.doPost(URL_REST_FULL, input, userRol);
		return status;	
	}

	public String baja(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_REST_FULL, input, userRol);
	}
	
	public String mod(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_REST_FULL, input, userRol);
	}	

	public String puestosAll(String userRol, String user) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_ALL, userRol, user);
	}

	public String asignarTramite(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_ASIG_TRAMITE, input, userRol);
	}	

	public String listarTramitesAsignables(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_TRAMITES_ASIGNABLES + input, userRol);
	}

	public String puestosSector(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_PUESTOS_SECTOR + "?sectorId=" + input, userRol);
	}
	
	public String puestosParaSector(String input, String userRol, String user) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_ALL_SECTOR + "?sectorId=" + input, userRol, user);
	}
	
	public String desasignarTramite(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_DESASIG_TRAMITE, input, userRol);
	}	

}
