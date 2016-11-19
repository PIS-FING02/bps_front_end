package com.sarp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilService {

	private static final String propertiesPath = System.getProperty("jboss.home.dir")+"/modules/conf/sarp_front.properties";

	public static Integer getIntegerProperty(String key) {    
		return  Integer.valueOf(getProperty().getProperty(key));
	}
	
	public static String getStringProperty(String key) {    
		return  getProperty().getProperty(key);
	}
	
	private static Properties getProperty() {
		Properties prop = new Properties(); 
		  InputStream input; 
		  try { 
			  input = new FileInputStream(propertiesPath);
			  prop.load(input);  
		  } catch(FileNotFoundException e) { 
			  try{
				  input = UtilService.class.getResourceAsStream("local.properties");
				  prop.load(input);  
				  System.out.println("Enctro local");
			  }catch(Exception ex) { 
				  System.out.println("NO LO ENCONTRO AL PROPERTIE NI LOCAL");
			  }
			  
		  } catch (IOException e){
			  System.out.println("ERROR LEYENDO");
		  }
		  return prop;
	}
	 
}
