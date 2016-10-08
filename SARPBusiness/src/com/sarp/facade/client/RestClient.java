package com.sarp.facade.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClient {

	private static RestClient instance;
	private RestClient(){}
	
	public static RestClient getInstance(){
		instance = instance != null ? instance : new  RestClient();
		return instance;
	}
	
	public String doPost(String URL, String input, String userRol){
		StringBuilder resultado=new StringBuilder();
		try {
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("user-rol",userRol);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
		
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			
			String output;
			System.out.println("RestClient POST con " + URL+ "input = "+ input );
			while ((output = br.readLine()) != null) {
				resultado.append(output);
			}
			conn.disconnect();
	
		  } catch (MalformedURLException e) {
			resultado.append("RequestMalFormada");
			e.printStackTrace();
	
		  } catch (IOException e) {
			resultado.append("Error");
			e.printStackTrace();
		  }
		return resultado.toString();	
	}
	
	public String doGet(String URL, String userRol){
		StringBuilder resultado = new StringBuilder();
		try{
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-rol","ResponsableSector");
			
			if (conn.getResponseCode() != 200) {
				resultado.append("Error");
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
	
			String output;
			System.out.println("RestClient GET con " + URL );
			while ((output = br.readLine()) != null) {
				resultado.append(output);
			}
	
			conn.disconnect();
			
	
		} catch (MalformedURLException e) {
	
			e.printStackTrace();
	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
		return resultado.toString();

	}

	public String doDelete(String urlRestFull, String input, String userRol) {
		// TODO Auto-generated method stub
		return null;
	}

	public String doPUT(String urlRestFull, String input, String userRol) {
		// TODO Auto-generated method stub
		return null;
	}
}
