package com.sarp.facade;
import java.net.MalformedURLException;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;


public class PuestoFacade {

	private static final String DIGG_SEARCH_ENDPOINT = "http://52.52.100.160:8080/SARPService/adminService/puestos";
	public String alta() throws Exception {
		String resultado="";
		try {
			ClientRequest request = new ClientRequest(DIGG_SEARCH_ENDPOINT);
			
			request.pathParameter("user-rol","ResponsableSector");
			
			request.accept("application/json");
			
			ClientResponse<String> response = request.get(String.class);
	        
	        System.out.println(response.getEntity());
			   
			

		

			return resultado;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return resultado;

	}

	public String puestos() throws Exception {
		String resultado="";
		try {
			ClientRequest request = new ClientRequest(DIGG_SEARCH_ENDPOINT);
			
			request.pathParameter("user-rol","ResponsableSector");
			request.pathParameter("id-sector", "1");
			request.accept("application/json");
			
			ClientResponse<String> response = request.get(String.class);
	        
	        System.out.println(response.getEntity());
			   return resultado;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return resultado;

	}

}
