package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class PuestoFacade {

	public static final String URL_POST = "http://52.52.100.160:8080/SARPService/adminService/puesto";
	public static final String URL_GET = "http://52.52.100.160:8080/SARPService/adminService/puestos";
	
	public String alta(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		input = "{\n"
				+ "\"nombreMaquina\":\"MaquinaFront2222\",\n"
				+ "\"usuarioId\":\"idFromFrontend23232\",\n"
				+ "\"numeroPuesto\":69,\n"
				+ "\"estado\":\"CERRADO\"\n"
				+ "}";
		return  restClient.doPost(URL_POST, input, userRol);
		
	}

	public String puestosAll(String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_GET, userRol);
	}

}
