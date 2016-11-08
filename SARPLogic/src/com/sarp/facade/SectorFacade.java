package com.sarp.facade;

import java.io.IOException;

import com.sarp.facade.client.RestClient;
import com.sarp.utils.UtilService;

public class SectorFacade {
	
	public static final String SERVER = UtilService.getStringProperty("SERVER_BACK_END");

	public static final String URL_REST_SECTOR_FULL = UtilService.getStringProperty("URL_REST_SECTOR_FULL");
	public static final String URL_GET_SECTOR_ALL = UtilService.getStringProperty("URL_GET_SECTOR_ALL");
	public static final String URL_REST_GAFU =  UtilService.getStringProperty("URL_REST_GAFU");
	public static final String URL_REST_ASIGNAR_TRAMITE =  UtilService.getStringProperty("URL_REST_ASIGNAR_TRAMITE");
	public static final String URL_REST_DESASIGNAR_TRAMITE =  UtilService.getStringProperty("URL_REST_DESASIGNAR_TRAMITE");
	public static final String URL_REST_ASIGNAR_PUESTO =  UtilService.getStringProperty("URL_REST_ASIGNAR_PUESTO");
	public static final String URL_REST_ASIGNAR_DISPLAY =  UtilService.getStringProperty("URL_REST_ASIGNAR_DISPLAY");
	public static final String URL_REST_DESASIGNAR_DISPLAY =  UtilService.getStringProperty("URL_REST_DESASIGNAR_DISPLAY");
	public static final String URL_LISTAR_NUMEROS_SECTOR =  UtilService.getStringProperty("URL_LISTAR_NUMEROS_SECTOR");
	public static final String URL_REST_DESASIGNAR_PUESTO =  UtilService.getStringProperty("URL_REST_DESASIGNAR_PUESTO");
	public static final String URL_LISTAR_NUMEROS_PAUSADOS_SECTOR =  UtilService.getStringProperty("URL_LISTAR_NUMEROS_PAUSADOS_SECTOR");
	public static final String URL_LISTAR_NUMEROS_ATRASADOS_SECTOR =  UtilService.getStringProperty("URL_LISTAR_NUMEROS_ATRASADOS_SECTOR");
	public static final String URL_LISTAR_NUMEROS_ESPERA_SECTOR =  UtilService.getStringProperty("URL_LISTAR_NUMEROS_ESPERA_SECTOR");
	public static final String URL_LISTAR_SECTORES_DESVIO =  UtilService.getStringProperty("URL_LISTAR_SECTORES_DESVIO");
	
	public String importarSectoresGafu(String userRol)  {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_REST_GAFU, "", userRol);
		
	}
	
	public String sectoresAll(String userRol, String user)  {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_SECTOR_ALL, userRol, user);
	}

	public String asignarTramiteSector(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_REST_ASIGNAR_TRAMITE, input, userRol);
	}
	
	public String desasignarTramiteSector(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_REST_DESASIGNAR_TRAMITE, input, userRol);
	}

	public String asignarPuestoSector(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_REST_ASIGNAR_PUESTO, input, userRol);
	}
	
	public String desasignarPuestoSector(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_REST_DESASIGNAR_PUESTO, input, userRol);
	}

	public String asignarDisplaySector(String input, String userRol) throws Exception {
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
	
	public String listarNumerosPausadosSector(String idSector, String userRol, String user) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_LISTAR_NUMEROS_PAUSADOS_SECTOR.concat(idSector), userRol, user);
	}

	public String listarNumerosAtrasadosSector(String idSector, String userRol, String user) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_LISTAR_NUMEROS_ATRASADOS_SECTOR.concat(idSector), userRol, user);
	}

	public String listarNumerosEnEsperaSector(String idSector, String userRol, String user) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_LISTAR_NUMEROS_ESPERA_SECTOR.concat(idSector), userRol, user);
	}

	public String listarSectoresDesvio(String idSector, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut1(URL_LISTAR_SECTORES_DESVIO,idSector, userRol);
	}
}
