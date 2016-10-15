package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class AttentionsFacade {

	public static final String URL_ABRIR_PUESTO = "http://52.52.100.160:8080/SARPService/attentionsService/abrirPuesto";
	public static final String URL_CERRAR_PUESTO = "http://52.52.100.160:8080/SARPService/attentionsService/cerrarPuesto";
	
	public String abrir(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_ABRIR_PUESTO, input, userRol);
		
	}

	public String cerrar(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_CERRAR_PUESTO, input, userRol);
	}


}
