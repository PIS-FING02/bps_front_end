package com.sarp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilService {

	private static final String propertiesPath = "/home/ubuntu/EAP-6.4.0/modules/conf/sarp_front.properties";  

	public static Integer getIntegerProperty(String key) throws NumberFormatException, IOException{    
		return  Integer.valueOf(getProperty().getProperty(key));
	}
	
	public static String getStringProperty(String key) throws IOException{    
		return  getProperty().getProperty(key);
	}
	
	private static Properties getProperty() throws IOException{
		Properties prop = new Properties(); 
		  InputStream input; 
		  try { 
			  input = new FileInputStream(propertiesPath);
			  prop.load(input);  
		  } catch(FileNotFoundException e) { 
			  System.out.println("NO ESTA EL ARCHIVO");
			  throw e;
		  } catch (IOException e){
			  System.out.println("ERROR LEYENDO");
			  throw e;
		  }
		  return prop;
	}
	 
}
