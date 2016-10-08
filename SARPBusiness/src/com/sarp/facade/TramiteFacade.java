package com.sarp.facade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.sarp.facade.client.RestClient;

public class TramiteFacade {

	public static final String URL_REST_FULL = "http://52.52.100.160:8080/SARPService/adminService/tramite";
	public static final String URL_GET_ALL = "http://52.52.100.160:8080/SARPService/adminService/listarTramites";
	
	public String alta(String input, String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		input = "{\n"
				+ "\"codigo\":\"45\",\n"
				+ "\"nombre\":\"elNombreDeEsteTramite\",\n"
				+ "}";
		return  restClient.doPost(URL_REST_FULL, input, userRol);
		
	}

	public String baja(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		input = "{\n"
				+ "\"codigo\":\"45\",\n"
				+ "\"nombre\":\"elNombreDeEsteTramite\",\n"
				+ "}";
		return  restClient.doDelete(URL_REST_FULL, input, userRol);
	}
	
	public String mod(String input, String userRol) {
		RestClient restClient = RestClient.getInstance();
		input = "{\n"
				+ "\"codigo\":\"45\",\n"
				+ "\"nombre\":\"elNombreDeEsteTramite\",\n"
				+ "}";
		return  restClient.doPUT(URL_REST_FULL, input, userRol);
	}	
	
	public String tramitesAll(String userRol) throws Exception {
		RestClient restClient = RestClient.getInstance();
		return  restClient.doGet(URL_GET_ALL, userRol);
	}
}