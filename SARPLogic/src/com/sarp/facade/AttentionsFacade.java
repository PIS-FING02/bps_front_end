package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class AttentionsFacade {

	public static final String URL_ABRIR_PUESTO = "http://52.52.100.160:8080/SARPService/attentionsService/abrirPuesto";
	public static final String URL_CERRAR_PUESTO = "http://52.52.100.160:8080/SARPService/attentionsService/cerrarPuesto";
	public static final String URL_LLAMAR_NUMERO = "http://52.52.100.160:8080/SARPService/attentionsService/fakeNumber";
	
	public String abrir(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_ABRIR_PUESTO, input, userRol);
		
	}

	public String cerrar(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_CERRAR_PUESTO, input, userRol);
	}

	public String llamarNumero(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LLAMAR_NUMERO, userRol);
	}
}
