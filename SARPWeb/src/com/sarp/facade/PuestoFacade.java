package com.sarp.facade;
import java.net.MalformedURLException;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


public class PuestoFacade {

	public String alta() throws Exception {
		String resultado="";
		try {
		
			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://52.52.100.160:8080/SARPService/adminService/puesto");

			String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";

			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = (String) response.getEntity(String.class);
			System.out.println(output);



			return resultado;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return resultado;

	}

	public String puestos() throws Exception {
		String resultado="";
		try {
			ClientRequest request = new ClientRequest("http://52.52.100.160:8080/SARPService/adminService/puestos");
			
			request.pathParameter("user-rol","ResponsableSector");
			request.pathParameter("id-sector", "1");
			request.accept("application/json");
			
			ClientResponse<String> response = request.get(String.class);
	        
	        System.out.println(response.getEntity());
			   return resultado;

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return resultado;

	}

}
