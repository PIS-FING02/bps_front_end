package com.sarp.facade;

import com.sarp.facade.client.RestClient;
import com.sarp.utils.UtilService;

public class NumeroFacade {

<<<<<<< 532882a1e5eba3e862bfc8d231edef46ce178ebc
	public static final String URL_SACAR_NUMERO = "http://52.52.100.160:8080/SARPService/numberService/solicitarNumero";
	public static final String URL_GET_METRICAS_NUMEROS = "http://52.52.100.160:8080/SARPService/numberService/listarMetricasNumero";
	public static final String URL_GET_METRICAS_NUMERO = "http://52.52.100.160:8080/SARPService/numberService/listarMetricasDeNumero";
	public static final String URL_GET_METRICAS_NUMEROS_ESTADO = "http://52.52.100.160:8080/SARPService/numberService/listarMetricasEstadoNumero";
=======
	public static final String SERVER = UtilService.getStringProperty("SERVER_BACK_END");
	public static final String URL_SACAR_NUMERO = SERVER + UtilService.getStringProperty("URL_SACAR_NUMERO");
>>>>>>> add local propertie
	
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
