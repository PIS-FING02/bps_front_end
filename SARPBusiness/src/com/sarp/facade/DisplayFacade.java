package com.sarp.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DisplayFacade {
	

	private static final String USER_AGENT = null;

	public String alta() {
		
		try {
			//POST
			//ingresa ruta, 
			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://52.52.100.160:8080/SARPService/adminService/display");

			String input = "{\"rutaArchivo\":\"ruta\"}";

			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
			ClientResponse response = webResource.user-rol("Administrador").post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }

		/*String resultado="";
		try {

			URL url = new URL("http://52.52.100.160:8080/SARPService/adminService/display");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("user-role", "Administrador");

			String input = "{\"rutaArchivo\": \"rutaArchivo\"}";

	        OutputStream os = conn.getOutputStream();
	        os.write(input.getBytes());
	        os.flush();
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				resultado=resultado+output;
				
			}

			conn.disconnect();
			return resultado;

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}	
		return resultado;*/
		return null;
	}
	
	public String modificar(){
		//PUT
		//http://52.52.100.160:8080/SARPService/adminService/display
		//selecciona id (GET http://52.52.100.160:8080/SARPService/adminService/displays) y modifica ruta
		return null;
	}
	
	public String baja(){
		//delete
		//http://52.52.100.160:8080/SARPService/adminService/display
		//selecciona id: GET http://52.52.100.160:8080/SARPService/adminService/displays
		return null;
	}
}