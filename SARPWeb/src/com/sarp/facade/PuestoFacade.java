package com.sarp.facade;
import java.net.MalformedURLException;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;


public class PuestoFacade {

	public String alta() throws Exception {
		String resultado="";
		try {
		
			ClientRequest request = new ClientRequest("http://52.52.100.160:8080/SARPService/adminService/puesto");
			
			request.pathParameter("user-rol","ResponsableSector");
			
			request.accept("application/json");
			
			String input = "{\"nombreMaquina\": \"maquina\",\"usuarioId\": \"45\",\"estado\": \"CERRADO\",\"numeroPuesto\": \"7\"}";
			request.body("application/json", input);

			ClientResponse<String> response = request.post(String.class);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
			}

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
