package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class DisplayFacade {

	public static final String URL_REST_FULL = "http://52.52.100.160:8080/SARPService/adminService/display";
	public static final String URL_GET_ALL = "http://52.52.100.160:8080/SARPService/adminService/displays";
	
	public String alta(String input, String userRol) {
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
	
	public String displaysAll(String userRol)  {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_GET_ALL, userRol);
	}
}	