package com.sarp.facade;

import com.sarp.facade.client.RestClient;

public class SectorFacade {
	
	public static final String URL_REST_FULL = "http://52.52.100.160:8080/SARPService/adminService/sector";
	public static final String URL_GET_ALL = "http://52.52.100.160:8080/SARPService/adminService/listarSectores";
	public static final String URL_REST_GAFU = "http://52.52.100.160:8080/SARPService/adminService/actualizarGAFU";

	public String importarSectoresGafu(String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_REST_GAFU, userRol);
		
	}
}
