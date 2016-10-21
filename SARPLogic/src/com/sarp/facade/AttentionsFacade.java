package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class AttentionsFacade {

	public static final String URL_ABRIR_PUESTO = "http://52.52.100.160:8080/SARPService/attentionsService/abrirPuesto";
	public static final String URL_CERRAR_PUESTO = "http://52.52.100.160:8080/SARPService/attentionsService/cerrarPuesto";
	public static final String URL_LLAMAR_NUMERO = "http://52.52.100.160:8080/SARPService/attentionsService/llamarNumero";
	public static final String URL_LISTAR_NUMEROS = "http://52.52.100.160:8080/SARPService/numberService/listarNumerosEnEspera?idPuesto=";
	public static final String URL_LISTAR_NUMEROS_PAUSADOS = "http://52.52.100.160:8080/SARPService/numberService/listarNumerosPausados?idPuesto=";
	public static final String URL_LISTAR_NUMEROS_ATRASADOS = "http://52.52.100.160:8080/SARPService/numberService/listarNumerosAtrasados?idPuesto=";
	public static final String URL_COMENZAR_ATENCION ="http://52.52.100.160:8080/SARPService/attentionsService/comenzarAtencion";
	public static final String URL_ATRASAR_NUMERO ="http://52.52.100.160:8080/SARPService/attentionsService/atrasarNumero";
	public static final String URL_PAUSAR_NUMERO ="http://52.52.100.160:8080/SARPService/attentionsService/pausarNumero";
	public static final String URL_FINALIZAR_NUMERO = "http://52.52.100.160:8080/SARPService/attentionsService/finalizarAtencion";
	public static final String URL_LLAMAR_NUMERO_PAUSADO ="http://52.52.100.160:8080/SARPService/attentionsService/llamarPausado";
	public static final String URL_LLAMAR_NUMERO_ATRASADO ="http://52.52.100.160:8080/SARPService/attentionsService/llamarAtrasado";
	
	public String abrir(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_ABRIR_PUESTO, input, userRol);	
	}

	public String cerrar(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_CERRAR_PUESTO, input, userRol);
	}

	public String llamarNumero(String hparam, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LLAMAR_NUMERO, userRol, hparam);
	}

	public String listarNumeros(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LISTAR_NUMEROS.concat(input), userRol);
	}

	public String listarNumerosPausados(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LISTAR_NUMEROS_PAUSADOS.concat(input), userRol);
	}

	public String listarNumerosAtrasados(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LISTAR_NUMEROS_ATRASADOS.concat(input), userRol);
	}

	public String comenzarAtencion(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_COMENZAR_ATENCION, input, userRol);
	}

	public String atrasarNumero(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_ATRASAR_NUMERO, input, userRol);
	}
	
	public String pausarNumero(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_PAUSAR_NUMERO, input, userRol);
	}

	public String finalizarAtencion(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_FINALIZAR_NUMERO, input, userRol);
	}

	public String llamarNumeroPausado(String numero,String puesto, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LLAMAR_NUMERO_PAUSADO, numero, puesto, userRol);
	}

	public String llamarNumeroAtrasado(String externalId, String puesto, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LLAMAR_NUMERO_ATRASADO, externalId, puesto, userRol);
	}


}
