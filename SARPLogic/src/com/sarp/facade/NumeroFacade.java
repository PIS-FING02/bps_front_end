package com.sarp.facade;

import com.sarp.facade.client.RestClient;
import com.sarp.utils.UtilService;

public class NumeroFacade {

	public static final String SERVER = UtilService.getStringProperty("SERVER_BACK_END");
	
	public static final String URL_SACAR_NUMERO = UtilService.getStringProperty("URL_SACAR_NUMERO");
	public static final String URL_GET_METRICAS_NUMEROS = UtilService.getStringProperty("URL_GET_METRICAS_NUMEROS");
	public static final String URL_GET_METRICAS_NUMERO = UtilService.getStringProperty("URL_GET_METRICAS_NUMERO");
	public static final String URL_GET_METRICAS_NUMEROS_ESTADO = UtilService.getStringProperty("URL_GET_METRICAS_NUMEROS_ESTADO");

	
	public String sacar(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_SACAR_NUMERO, input, userRol);	
	}
	
	public String listarMetricasNumeros(String userRol,String user){
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_METRICAS_NUMEROS, userRol, user);
	}

	public String listarMetricasNumero(String input, String userRol,String user){
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_METRICAS_NUMERO + "?internallId=" + input, userRol, user);
	}

	public String listarMetricasNumerosEstado(String userRol,String user){
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_METRICAS_NUMEROS_ESTADO, userRol, user);
	}

	public String listarMetricasNumeroEstado(String input, String userRol,String user){
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_METRICAS_NUMEROS_ESTADO + "?internalId=" + input, userRol, user);
	}
}
