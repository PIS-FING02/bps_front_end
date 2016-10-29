package com.sarp.facade.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jboss.resteasy.spi.InternalServerErrorException;
import org.jboss.resteasy.spi.NotFoundException;
import org.jboss.resteasy.spi.UnauthorizedException;

public class RestClient {

	private static RestClient instance;
	private RestClient(){}
	
	public static RestClient getInstance(){
		instance = instance != null ? instance : new  RestClient();
		return instance;
	}
	
	public String doPost(String URL, String input, String userRol){
		StringBuilder resultado = new StringBuilder();
		try {
			System.out.println(input);
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("user-rol", userRol);

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
	
		}catch (MalformedURLException e) {
			resultado = new StringBuilder();
			resultado.append("resuest_error");
			e.printStackTrace();
	  } catch (IOException e) {
			resultado = new StringBuilder();  
			resultado.append("erorr_client");
			e.printStackTrace();
	  }catch (UnauthorizedException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_autothorized");
		  e.printStackTrace();
	  }catch (InternalServerErrorException e) {
		  resultado = new StringBuilder();
		  resultado.append("error_server");
		  e.printStackTrace();
	  }catch (NotFoundException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_found_error");
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
			conn.setRequestProperty("user-rol",userRol);
			
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
		}catch (MalformedURLException e) {
			resultado = new StringBuilder();
			resultado.append("resuest_error");
			e.printStackTrace();
	  } catch (IOException e) {
			resultado = new StringBuilder();  
			resultado.append("erorr_client");
			e.printStackTrace();
	  }catch (UnauthorizedException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_autothorized");
		  e.printStackTrace();
	  }catch (InternalServerErrorException e) {
		  resultado = new StringBuilder();
		  resultado.append("error_server");
		  e.printStackTrace();
	  }catch (NotFoundException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_found_error");
		  e.printStackTrace();
	  }
		return resultado.toString();
	}
	
	public String doGetList(String URL, String userRol, String user){
		StringBuilder resultado = new StringBuilder();
		try{
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-rol", userRol);
			conn.setRequestProperty("user", user);
			
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
		}catch (MalformedURLException e) {
			resultado = new StringBuilder();
			resultado.append("resuest_error");
			e.printStackTrace();
	  } catch (IOException e) {
			resultado = new StringBuilder();  
			resultado.append("erorr_client");
			e.printStackTrace();
	  }catch (UnauthorizedException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_autothorized");
		  e.printStackTrace();
	  }catch (InternalServerErrorException e) {
		  resultado = new StringBuilder();
		  resultado.append("error_server");
		  e.printStackTrace();
	  }catch (NotFoundException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_found_error");
		  e.printStackTrace();
	  }
		return resultado.toString();
	}

	public String doGet(String URL, String userRol, String headerParam){
		StringBuilder resultado = new StringBuilder();
		try{
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-rol", userRol);
			conn.setRequestProperty("hparam", headerParam);
			
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
		}catch (MalformedURLException e) {
			resultado = new StringBuilder();
			resultado.append("resuest_error");
			e.printStackTrace();
	  } catch (IOException e) {
			resultado = new StringBuilder();  
			resultado.append("erorr_client");
			e.printStackTrace();
	  }catch (UnauthorizedException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_autothorized");
		  e.printStackTrace();
	  }catch (InternalServerErrorException e) {
		  resultado = new StringBuilder();
		  resultado.append("error_server");
		  e.printStackTrace();
	  }catch (NotFoundException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_found_error");
		  e.printStackTrace();
	  }
		return resultado.toString();
	}
	
	public String doGet(String URL,String headerParam, String headerParam1, String userRol
			){
		StringBuilder resultado = new StringBuilder();
		try{
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-rol", userRol);
			conn.setRequestProperty("idNumero", headerParam);
			conn.setRequestProperty("idPuesto", headerParam1);
			
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
		}catch (MalformedURLException e) {
			resultado = new StringBuilder();
			resultado.append("resuest_error");
			e.printStackTrace();
	  } catch (IOException e) {
			resultado = new StringBuilder();  
			resultado.append("erorr_client");
			e.printStackTrace();
	  }catch (UnauthorizedException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_autothorized");
		  e.printStackTrace();
	  }catch (InternalServerErrorException e) {
		  resultado = new StringBuilder();
		  resultado.append("error_server");
		  e.printStackTrace();
	  }catch (NotFoundException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_found_error");
		  e.printStackTrace();
	  }
		return resultado.toString();
	}

	
	public String doDelete(String URL, String input, String userRol) {
		StringBuilder resultado = new StringBuilder();
		try {
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("user-rol",userRol);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
		
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			
			String output;
			System.out.println("RestClient DELETE con " + URL+ "input = "+ input );
			while ((output = br.readLine()) != null) {
				resultado.append(output);
			}
			conn.disconnect();
	
		}catch (MalformedURLException e) {
			resultado = new StringBuilder();
			resultado.append("resuest_error");
			e.printStackTrace();
	  } catch (IOException e) {
			resultado = new StringBuilder();  
			resultado.append("erorr_client");
			e.printStackTrace();
	  }catch (UnauthorizedException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_autothorized");
		  e.printStackTrace();
	  }catch (InternalServerErrorException e) {
		  resultado = new StringBuilder();
		  resultado.append("error_server");
		  e.printStackTrace();
	  }catch (NotFoundException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_found_error");
		  e.printStackTrace();
		  }
		return resultado.toString();
	}

	public String doPut(String URL, String input, String userRol) {
		StringBuilder resultado = new StringBuilder();
		try {
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("user-rol",userRol);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
		
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			
			String output;
			System.out.println("RestClient PUT con " + URL+ "input = "+ input );
			while ((output = br.readLine()) != null) {
				resultado.append(output);
			}
			conn.disconnect();
	
		  }catch (MalformedURLException e) {
				resultado = new StringBuilder();
				resultado.append("resuest_error");
				e.printStackTrace();
		  } catch (IOException e) {
				resultado = new StringBuilder();  
				resultado.append("erorr_client");
				e.printStackTrace();
		  }catch (UnauthorizedException e) {
			  resultado = new StringBuilder();
			  resultado.append("not_autothorized");
			  e.printStackTrace();
		  }catch (InternalServerErrorException e) {
			  resultado = new StringBuilder();
			  resultado.append("error_server");
			  e.printStackTrace();
		  }catch (NotFoundException e) {
			  resultado = new StringBuilder();
			  resultado.append("not_found_error");
			  e.printStackTrace();
		  }
		return resultado.toString();
}

	
public String doPut1(String URL, String input, String userRol) {
	StringBuilder resultado = new StringBuilder();
	try {
		URL url = new URL(URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("user-rol",userRol);
		conn.setRequestProperty("idPuesto", input);


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

	  }catch (MalformedURLException e) {
			resultado = new StringBuilder();
			resultado.append("resuest_error");
			e.printStackTrace();
	  } catch (IOException e) {
			resultado = new StringBuilder();  
			resultado.append("erorr_client");
			e.printStackTrace();
	  }catch (UnauthorizedException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_autothorized");
		  e.printStackTrace();
	  }catch (InternalServerErrorException e) {
		  resultado = new StringBuilder();
		  resultado.append("error_server");
		  e.printStackTrace();
	  }catch (NotFoundException e) {
		  resultado = new StringBuilder();
		  resultado.append("not_found_error");
		  e.printStackTrace();
	  }
	return resultado.toString();
}
}
