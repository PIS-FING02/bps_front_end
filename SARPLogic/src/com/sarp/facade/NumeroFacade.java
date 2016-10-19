package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class NumeroFacade {

	public static final String URL_SACAR_NUMERO = "http://52.52.100.160:8080/SARPService/numberService/solicitarNumero";
	
	public String sacar(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_SACAR_NUMERO, input, userRol);	
	}
}
