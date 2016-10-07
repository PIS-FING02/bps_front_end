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

public class TramiteFacade {

	public String alta() {
		String resultado="";
		try {
			
			URL url = new URL("http://52.52.100.160:8080/SARPService/adminService/tramite");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("user-role", "Administrador");

			String input = "{'codigo': '45', 'nombre': 'elNombreDeEsteTramite'}";

					
			conn.setUseCaches(false);
	        conn.setDoInput(true);
	        conn.setDoOutput(true);
	        conn.connect();



	        //Send request
	        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(input);
	        wr.flush();
	        wr.close();

System.out.println(conn.getResponseCode());
System.out.println(conn.getResponseMessage());

	      //Get Response	
//	        OutputStreamWriter ow = new OutputStreamWriter(conn.getOutputStream());
//	        BufferedWriter out = new BufferedWriter(ow);
//	        	out.write(input);
//	        	out.close();
	      return resultado;

	    } catch (Exception e) {

	      e.printStackTrace();
	      return null;

	    }
			
//	        OutputStream os = conn.getOutputStream();
//	        os.write(input.getBytes());
//	        os.flush();
//			
//			if (conn.getResponseCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
//			}
//
//			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
//
//			String output;
//			System.out.println("Output from Server .... \n");
//			while ((output = br.readLine()) != null) {
//				System.out.println(output);
//				resultado=resultado+output;
//			}
//
//			conn.disconnect();
//			return resultado;
//
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return resultado;
	}

	public String baja() {
		String resultado="";
		try {
			
			URL url = new URL("http://52.52.100.160:8080/SARPService/adminService/tramite");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("user-role", "Administrador");

			String input = "{'nombre': 'elNombreDeEsteTramite','codigo': '45'}";

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
	
	public String mod() {
		String resultado="";
		try {
			
			URL url = new URL("http://52.52.100.160:8080/SARPService/adminService/tramite");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("user-role", "Administrador");

			String input = "{'nombre': 'elNombreDeEsteTramite','codigo': '45'}";

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
	
	public String listar() {
		String resultado="";
		try {
			
			URL url = new URL("52.52.100.160:8080/SARPService/adminService/listarTramites");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("user-role", "Administrador");

			int responseCode = conn.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());
			return response.toString();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultado;
	}	
}