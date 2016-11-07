package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class NumeroFacade {

	public static final String URL_SACAR_NUMERO = "http://52.52.100.160:8080/SARPService/numberService/solicitarNumero";
	public static final String URL_GET_METRICAS_NUMEROS = "http://52.52.100.160:8080/SARPService/numberService/listarMetricasNumero";
	public static final String URL_GET_METRICAS_NUMERO = "http://52.52.100.160:8080/SARPService/numberService/listarMetricasDeNumero";
	public static final String URL_GET_METRICAS_NUMEROS_ESTADO = "http://52.52.100.160:8080/SARPService/numberService/listarMetricasEstadoNumero";
	
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
