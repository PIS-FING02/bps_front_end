package com.sarp.facade;

import com.sarp.facade.client.RestClient;
import com.sarp.utils.UtilService;

public class DisplayFacade {

	public static final String SERVER = UtilService.getStringProperty("SERVER_BACK_END");
	public static final String URL_REST_DISPLAY_FULL =  UtilService.getStringProperty("URL_REST_DISPLAY_FULL");
	public static final String URL_GET_DISPLAY_ALL =  UtilService.getStringProperty("URL_GET_DISPLAY_ALL");
	public static final String URL_DISPLAYS_SECTOR =  UtilService.getStringProperty("URL_DISPLAYS_SECTOR");
	
	public String alta(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPost(URL_REST_DISPLAY_FULL, input, userRol);
	}

	public String baja(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doDelete(URL_REST_DISPLAY_FULL, input, userRol);
	}
	
	public String mod(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doPut(URL_REST_DISPLAY_FULL, input, userRol);
	}	
	
	public String displaysAll(String userRol)  {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_GET_DISPLAY_ALL, userRol);
	}

	public String displaysSector(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_DISPLAYS_SECTOR + "?sectorId=" + input, userRol);
	}

	public String displaysParaSector(String input, String userRol, String user) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGetList(URL_GET_DISPLAY_ALL + "?sectorId=" + input, userRol, user);
	}
}	
