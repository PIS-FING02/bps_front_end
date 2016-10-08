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
		
		Integer d = Integer.parseInt(json.get("codigo").toString());
		String f = json.get("rutaArchivo").toString();
		JSONDisplay display = new JSONDisplay(d, f);
		
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
        List<JSONPuesto> puestosReturn = new ArrayList<JSONPuesto>();
        
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
        List<JSONTramite> tramitesReturn = new ArrayList<JSONTramite>();
        
    	Iterator<JSONObject> iterator = array.iterator();
    	while (iterator.hasNext()) {
    		tramitesReturn.add(this.toJSONTramite(iterator.next().toJSONString()));
    	}
		
		return tramitesReturn;
			
	}
	
	public List<JSONDisplay> toJSONDisplays(String jsonDisplay) throws Exception{

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonDisplay);
        JSONArray array = (JSONArray)obj;
        List<JSONDisplay> displaysReturn = new ArrayList<JSONDisplay>();
        
    	Iterator<JSONObject> iterator = array.iterator();
    	while (iterator.hasNext()) {
    		displaysReturn.add(this.toJSONDisplay(iterator.next().toJSONString()));
    	}
		
		return displaysReturn;
			
	}
	


}
