package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class SectorFacade {
	
	public static final String URL_REST_FULL = "http://52.52.100.160:8080/SARPService/adminService/sector";
	public static final String URL_GET_ALL = "http://52.52.100.160:8080/SARPService/adminService/listarSectores";
	public static final String URL_REST_GAFU = "http://52.52.100.160:8080/SARPService/adminService/actualizarGAFU";
	public static final String URL_REST_ASIGNAR_TRAMITE = "http://52.52.100.160:8080/SARPService/adminService/asignarTramiteSector";
	public static final String URL_REST_DESASIGNAR_TRAMITE = "http://52.52.100.160:8080/SARPService/adminService/desasignarTramiteSector";
	public static final String URL_REST_ASIGNAR_PUESTO = "http://52.52.100.160:8080/SARPService/adminService/asignarPuestoSector";
	public static final String URL_REST_ASIGNAR_DISPLAY = "http://52.52.100.160:8080/SARPService/adminService/asignarSectorDisplay";
	public static final String URL_REST_DESASIGNAR_DISPLAY = "http://52.52.100.160:8080/SARPService/adminService/desasignarSectorDisplay";
	public static final String URL_LISTAR_NUMEROS_SECTOR = "http://52.52.100.160:8080/SARPService/numberService/listarNumerosSector?idSector=";
	public static final String URL_REST_DESASIGNAR_PUESTO = "http://52.52.100.160:8080/SARPService/adminService/desasignarPuestoSector";
	public static final String URL_LISTAR_NUMEROS_PAUSADOS_SECTOR = "http://52.52.100.160:8080/SARPService/numberService/listarNumerosPausados?idSector=";
	public static final String URL_LISTAR_NUMEROS_ATRASADOS_SECTOR = "http://52.52.100.160:8080/SARPService/numberService/listarNumerosAtrasados?idSector=";
	public static final String URL_LISTAR_NUMEROS_ESPERA_SECTOR = "http://52.52.100.160:8080/SARPService/numberService/listarNumerosEnEspera?idSector=";

	
	public String importarSectoresGafu(String userRol)  {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_REST_GAFU, "", userRol);
		
	}
	
	public String sectoresAll(String userRol)  {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_GET_ALL, userRol);
	}

	public String asignarTramiteSector(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_REST_ASIGNAR_TRAMITE, input, userRol);
	}
	
	public String desasignarTramiteSector(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_REST_DESASIGNAR_TRAMITE, input, userRol);
	}

	public String asignarPuestoSector(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_REST_ASIGNAR_PUESTO, input, userRol);
	}
	
	public String desasignarPuestoSector(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_REST_DESASIGNAR_PUESTO, input, userRol);
	}

	public String asignarDisplaySector(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_REST_ASIGNAR_DISPLAY, input, userRol);
	}
	
	public String desasignarDisplaySector(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_REST_DESASIGNAR_DISPLAY, input, userRol);
	}
	
	public String listarNumerosSector(String idSector, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LISTAR_NUMEROS_SECTOR.concat(idSector), userRol);
	}
	
	public String listarNumerosPausadosSector(String idSector, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LISTAR_NUMEROS_PAUSADOS_SECTOR.concat(idSector), userRol);
	}

	public String listarNumerosAtrasadosSector(String idSector, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LISTAR_NUMEROS_ATRASADOS_SECTOR.concat(idSector), userRol);
	}

	public String listarNumerosEnEsperaSector(String idSector, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_LISTAR_NUMEROS_ESPERA_SECTOR.concat(idSector), userRol);
	}
}
