package com.sarp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jboss.com.sun.corba.se.impl.corba.EnvironmentImpl;

public class UtilService {

	private static final String propertiesPath = "/home/ubuntu/EAP-6.4.0/modules/conf/sarp_front.properties";
	private static final String propertiesPathLocal =  "/Users/franciscocabrera/git/bps_front_end/local.properties";

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
			  System.out.println("NO ESTA EL ARCHIVO");
			  try{
				  System.out.println("BUSCO LOCAL");
				  input = new FileInputStream(propertiesPathLocal);
				  prop.load(input);  
			  }catch(Exception ex) { 
				  System.out.println("NO LO ENCONTRO AL PROPERTIE NI LOCAL");
			  }
			  
		  } catch (IOException e){
			  System.out.println("ERROR LEYENDO");
		  }
		  return prop;
	}
	 
}
