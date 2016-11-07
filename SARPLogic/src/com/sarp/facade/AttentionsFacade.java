package com.sarp.facade;

import com.sarp.facade.client.RestClient;
import com.sarp.utils.UtilService;

public class AttentionsFacade {
	
	public static final String SERVER = UtilService.getStringProperty("SERVER_BACK_END");
	public static final String URL_ABRIR_PUESTO = SERVER + UtilService.getStringProperty("URL_ABRIR_PUESTO");
	public static final String URL_CERRAR_PUESTO = SERVER + UtilService.getStringProperty("URL_CERRAR_PUESTO");
	public static final String URL_LLAMAR_NUMERO = SERVER + UtilService.getStringProperty("URL_LLAMAR_NUMERO");
	public static final String URL_LISTAR_NUMEROS = SERVER + UtilService.getStringProperty("URL_LISTAR_NUMEROS");
	public static final String URL_LISTAR_NUMEROS_PAUSADOS = SERVER + UtilService.getStringProperty("URL_LISTAR_NUMEROS_PAUSADOS");
	public static final String URL_LISTAR_NUMEROS_ATRASADOS = SERVER + UtilService.getStringProperty("URL_LISTAR_NUMEROS_ATRASADOS");
	public static final String URL_COMENZAR_ATENCION =SERVER + UtilService.getStringProperty("URL_COMENZAR_ATENCION");
	public static final String URL_ATRASAR_NUMERO =SERVER + UtilService.getStringProperty("URL_ATRASAR_NUMERO");
	public static final String URL_PAUSAR_NUMERO =SERVER + UtilService.getStringProperty("URL_PAUSAR_NUMERO");
	public static final String URL_FINALIZAR_NUMERO = SERVER + UtilService.getStringProperty("URL_FINALIZAR_NUMERO");
	public static final String URL_LLAMAR_NUMERO_PAUSADO =SERVER + UtilService.getStringProperty("URL_LLAMAR_NUMERO_PAUSADO");
	public static final String URL_LLAMAR_NUMERO_ATRASADO =SERVER + UtilService.getStringProperty("URL_LLAMAR_NUMERO_ATRASADO");
	public static final String URL_LLAMAR_NUMERO_DEMANDA =SERVER + UtilService.getStringProperty("URL_LLAMAR_NUMERO_DEMANDA");
	public static final String URL_RELLAMAR_NUMERO =SERVER + UtilService.getStringProperty("URL_RELLAMAR_NUMERO");
	public static final String URL_DESVIAR_NUMERO = SERVER + UtilService.getStringProperty("URL_DESVIAR_NUMERO");
	public static final String URL_CANT_NUM_EN_ESPERA= SERVER + UtilService.getStringProperty("URL_CANT_NUM_EN_ESPERA");
	//public static final String URL_LISTAR_TRAMITE_SECTOR=
	
	
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

	public String llamarNumeroPausado(String internalId,String maquina, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LLAMAR_NUMERO_PAUSADO, internalId, maquina, userRol);
	}

	public String llamarNumeroAtrasado(String internalId, String maquina, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LLAMAR_NUMERO_ATRASADO, internalId, maquina, userRol);
	}

	public String llamarNumeroDemanda(String internalId, String maquina, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LLAMAR_NUMERO_DEMANDA, internalId, maquina, userRol);
	}

	public String reLlamarNumero(String maquina, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut2(URL_RELLAMAR_NUMERO, maquina, userRol);
	}

	public String desviarFinalizarAtencion(String json, String sector_desvio, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut2(URL_DESVIAR_NUMERO, json, sector_desvio, userRol);
	}

	public String obtenerNumEnEspera(String idPuesto, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_CANT_NUM_EN_ESPERA.concat(idPuesto), userRol);
	}
	


}
