package com.sarp.jsonModeler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sarp.jsons.JSONDisplay;
import com.sarp.jsons.JSONPuesto;
import com.sarp.jsons.JSONTramite;

public class JSONModeler {

	public JSONDisplay toJSONDisplay(String jsonDisplay) throws Exception{
		
		JSONObject json = (JSONObject)new JSONParser().parse(jsonDisplay);
		JSONDisplay display = new JSONDisplay(Integer.parseInt(json.get("displayId").toString()),json.get("rutaArchivo").toString());
		
		return display;
			
	}
	
	public JSONTramite toJSONTramite(String jsonTramite) throws Exception{
			
			JSONObject json = (JSONObject)new JSONParser().parse(jsonTramite);
			JSONTramite tramite = new JSONTramite(Integer.parseInt(json.get("codigo").toString()),json.get("nombre").toString());
			
			return tramite;
				
	
		}
	
	public JSONPuesto toJSONPuesto(String jsonPuesto) throws Exception{


		JSONObject json = (JSONObject)new JSONParser().parse(jsonPuesto);
		JSONPuesto puesto = new JSONPuesto(json.get("nombreMaquina").toString(),json.get("usuarioId").toString(),Integer.parseInt(json.get("numeroPuesto").toString()),json.get("estado").toString());
		
		return puesto;
			
	
	}
	
	public List<JSONPuesto> toJSONPuestos(String jsonPuesto) throws Exception{

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonPuesto);
        JSONArray array = (JSONArray)obj;
        List<JSONPuesto> puestosReturn = new ArrayList();
        
    	Iterator<String> iterator = array.iterator();
    	while (iterator.hasNext()) {
    		puestosReturn.add(this.toJSONPuesto(iterator.next()));
    	}
		
		return puestosReturn;
			
	}
	
	public List<JSONTramite> toJSONTramites(String jsonTramite) throws Exception{

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonTramite);
        JSONArray array = (JSONArray)obj;
        List<JSONTramite> tramitesReturn = new ArrayList();
        
    	Iterator<String> iterator = array.iterator();
    	while (iterator.hasNext()) {
    		tramitesReturn.add(this.toJSONTramite(iterator.next()));
    	}
		
		return tramitesReturn;
			
	}
	
	public List<JSONDisplay> toJSONDisplays(String jsonDisplay) throws Exception{

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonDisplay);
        JSONArray array = (JSONArray)obj;
        List<JSONDisplay> displaysReturn = new ArrayList();
        
    	Iterator<String> iterator = array.iterator();
    	while (iterator.hasNext()) {
    		displaysReturn.add(this.toJSONDisplay(iterator.next()));
    	}
		
		return displaysReturn;
			
	}
	


}
