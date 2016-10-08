package com.sarp.facade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class PuestoFacade {

	public String alta() throws Exception {
		StringBuilder resultado=new StringBuilder();
		try {
		
			URL url2 = new URL("http://52.52.100.160:8080/SARPService/adminService/puesto2");
			HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
			conn2.setDoOutput(true);
			conn2.setRequestMethod("POST");
			conn2.setRequestProperty("Content-Type", "application/json");

			String input = "{\n"
					+ "\"nombreMaquina\":\"MaquinaFront2222\",\n"
					+ "\"usuarioId\":\"idFromFrontend23232\",\n"
					+ "\"numeroPuesto\":69,\n"
					+ "\"estado\":\"CERRADO\"\n"
					+ "}";
			
			OutputStream os = conn2.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			System.out.println(conn2.getResponseMessage());

			BufferedReader br2 = new BufferedReader(new InputStreamReader(
					(conn2.getInputStream())));
			
			String output2;
			System.out.println("Output from Server .... \n");
			while ((output2 = br2.readLine()) != null) {
				resultado.append(output2);
			}

			conn2.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		return resultado.toString();
	}

	

	public String puestos() throws Exception {
		String resultado="";
		try {
			URL url = new URL("http://52.52.100.160:8080/SARPService/adminService/puestos");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-rol","ResponsableSector");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				return output;
			}

			conn.disconnect();
			

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return resultado;

	}

}
