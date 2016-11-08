package com.sarp.facade;

import com.sarp.facade.client.RestClient;
import com.sarp.utils.UtilService;

public class PuestoFacade {

	public static final String SERVER = UtilService.getStringProperty("SERVER_BACK_END");
	
	public static final String URL_GET_METRICAS_PUESTOS =  UtilService.getStringProperty("URL_GET_METRICAS_PUESTOS");
	public static final String URL_REST_PUESTO_FULL =  UtilService.getStringProperty("URL_REST_PUESTO_FULL");
	public static final String URL_GET_PUESTO_ALL =  UtilService.getStringProperty("URL_GET_PUESTO_ALL");
	public static final String URL_GET_ALL_PUESTO_SECTOR =  UtilService.getStringProperty("URL_GET_ALL_PUESTO_SECTOR");
	public static final String URL_ASIG_TRAMITE =  UtilService.getStringProperty("URL_ASIG_TRAMITE");
	public static final String URL_TRAMITES_ASIGNABLES =  UtilService.getStringProperty("URL_TRAMITES_ASIGNABLES");
	public static final String URL_DESASIG_TRAMITE =  UtilService.getStringProperty("URL_DESASIG_TRAMITE");
	public static final String URL_PUESTOS_SECTOR =  UtilService.getStringProperty("URL_PUESTOS_SECTOR");


	
	public String alta(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		String status = restClient.doPost(URL_REST_PUESTO_FULL, input, userRol);
		return status;	
	}

	public String baja(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_REST_PUESTO_FULL, input, userRol);
	}
	
	public String mod(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_REST_PUESTO_FULL, input, userRol);
	}	

	public String puestosAll(String userRol, String user) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_PUESTO_ALL, userRol, user);
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
		return  restClient.doGetList(URL_GET_ALL_PUESTO_SECTOR + "?sectorId=" + input, userRol, user);
	}
	
	public String desasignarTramite(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_DESASIG_TRAMITE, input, userRol);
	}	

	public String listarMetricasPuestos(String userRol,String user){
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_METRICAS_PUESTOS, userRol, user);
	}

	public String listarMetricasPuesto(String input, String userRol,String user){
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_METRICAS_PUESTOS + "?nombreMaquina=" + input, userRol, user);
	}
}
