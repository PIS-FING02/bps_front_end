package com.sarp.facade;

import com.sarp.facade.client.RestClient;
import com.sarp.utils.UtilService;

public class TramiteFacade {

	public static final String SERVER = UtilService.getStringProperty("SERVER_BACK_END");

	public static final String URL_REST_FULL = SERVER + UtilService.getStringProperty("URL_REST_FULL");
	public static final String URL_GET_ALL = SERVER + UtilService.getStringProperty("URL_GET_ALL");
	public static final String URL_GET_ALL_SECTOR = SERVER + UtilService.getStringProperty("URL_GET_ALL_SECTOR");
	public static final String URL_GET_FROM_SECTOR = SERVER + UtilService.getStringProperty("URL_GET_FROM_SECTOR");
	public static final String URL_GET_FROM_RECEPCION = SERVER + UtilService.getStringProperty("URL_GET_FROM_RECEPCION");
	public static final String URL_GET_FROM_PUESTO = SERVER + UtilService.getStringProperty("URL_GET_FROM_PUESTO");
	
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
	

	public String tramitesParaSector(String input, String userRol, String user) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_ALL_SECTOR + "?sectorId="+input , userRol, user);
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