package com.sarp.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TramiteFacade {
	

	private static final String USER_AGENT = null;

	public String alta() {
		String resultado="";
		try {

			URL url = new URL("http://52.52.100.160:8080/SARPService/adminService/tramite");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("user-role", "Administrador");

			String input = "{\"nombre\": \"elNombreDeEsteTramite\",\"codigo\": \"45\"}";

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
		return resultado;

	}
	
}