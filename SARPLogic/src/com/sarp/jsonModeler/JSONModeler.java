package com.sarp.jsonModeler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sarp.jsons.JSONDisplay;
import com.sarp.jsons.JSONNumero;
import com.sarp.jsons.JSONPuesto;
import com.sarp.jsons.JSONSector;
import com.sarp.jsons.JSONTramite;
import com.sarp.jsons.JSONTramiteRecepcion;

public class JSONModeler {

	public JSONDisplay toJSONDisplay(String jsonDisplay) throws Exception{
		JSONObject json = (JSONObject)new JSONParser().parse(jsonDisplay);
		JSONDisplay display = new JSONDisplay(json.get("idDisplay").toString());
		return display;		
	}
	
	public JSONTramite toJSONTramite(String jsonTramite) throws Exception{
		JSONObject json = (JSONObject)new JSONParser().parse(jsonTramite);
		JSONTramite tramite = new JSONTramite(json.get("codigo").toString(),json.get("nombre").toString());
		return tramite;
	}
	
	public JSONTramiteRecepcion toJSONTramiteRecepcion(String jsonTramite) throws Exception{
		JSONObject json = (JSONObject)new JSONParser().parse(jsonTramite);
		JSONTramiteRecepcion tramite = new JSONTramiteRecepcion(json.get("tramiteId").toString(), 
				json.get("tramiteNombre").toString(), json.get("sectorId").toString(), json.get("sectorNombre").toString());
		return tramite;
	}
	
	public JSONPuesto toJSONPuesto(String jsonPuesto) throws Exception{
		JSONObject json = (JSONObject)new JSONParser().parse(jsonPuesto);
		
		String usuario = ((json.get("usuarioId") == null) ? null : json.get("usuarioId").toString());
		Integer numero = ((json.get("numeroPuesto") == null) ? null : Integer.parseInt(json.get("numeroPuesto").toString()));
		String estado = ((json.get("estado") == null) ? null : json.get("estado").toString());
		
		usuario = ((json.get("usuarioId") == null) ? null : json.get("usuarioId").toString());
		JSONPuesto puesto = new JSONPuesto(json.get("nombreMaquina").toString(), usuario, numero, estado);
		return puesto;
	}
	
	public List<JSONPuesto> toJSONPuestos(String jsonPuesto) throws Exception{

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonPuesto);
        JSONArray array = (JSONArray)obj;
        List<JSONPuesto> puestosReturn = new ArrayList<JSONPuesto>();
        
    	Iterator<JSONObject> iterator = array.iterator();
    	while (iterator.hasNext()) {
    		JSONPuesto g = this.toJSONPuesto(iterator.next().toJSONString());
    		puestosReturn.add(g);
    	}
		return puestosReturn;	
	}
	
	
	public JSONSector toJSONSector(String jsonSector) throws Exception{
		JSONObject json = (JSONObject)new JSONParser().parse(jsonSector); 
		
		String sectorId = ((json.get("codigo") == null) ? null : json.get("codigo").toString());
		String nombre = ((json.get("nombre") == null) ? null : json.get("nombre").toString());
		String ruta = ((json.get("rutaSector") == null) ? null : json.get("rutaSector").toString());

		JSONSector sector = new JSONSector(sectorId,nombre,ruta);
		return sector;
	}
	
	public List<JSONTramiteRecepcion> toJSONTramitesRecepcion(String jsonTramitesRecepcion) throws Exception {

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonTramitesRecepcion);
        JSONArray array = (JSONArray)obj;
        List<JSONTramiteRecepcion> tramitesRecepcionReturn = new ArrayList<JSONTramiteRecepcion>();
        
    	Iterator<JSONObject> iterator = array.iterator();
    	while (iterator.hasNext()) {
    		JSONTramiteRecepcion g = this.toJSONTramiteRecepcion(iterator.next().toJSONString());
    		tramitesRecepcionReturn.add(g);
    	}
		return tramitesRecepcionReturn;	
	}
	
	public List<JSONSector> toJSONSectores(String jsonSector) throws Exception {

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonSector);
        JSONArray array = (JSONArray)obj;
        List<JSONSector> sectoresReturn = new ArrayList<JSONSector>();
        
    	Iterator<JSONObject> iterator = array.iterator();
    	while (iterator.hasNext()) {
    		JSONSector g = this.toJSONSector(iterator.next().toJSONString());
    		sectoresReturn.add(g);
    	}
		return sectoresReturn;	
	}
	
	
	public List<JSONTramite> toJSONTramites(String jsonTramite) throws Exception{

		JSONParser parser = new JSONParser(); 
		Object obj = parser.parse(jsonTramite);
        JSONArray array = (JSONArray)obj;
        List<JSONTramite> tramitesReturn = new ArrayList<JSONTramite>();
        
    	Iterator<JSONObject> iterator = array.iterator();
    	while (iterator.hasNext()) {
    		JSONObject uuu = iterator.next();
    		String hhh = uuu.toJSONString();
    		JSONTramite tttt = this.toJSONTramite(hhh);
    		tramitesReturn.add(tttt);
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
	
	public JSONNumero toJSONNumero(String jsonNumero) {
		JSONObject json;
		try {
			json = (JSONObject)new JSONParser().parse(jsonNumero);
	
		
		Integer id = ((json.get("id") == null) ? null : Integer.parseInt(json.get("id").toString()));
		String externalId = ((json.get("externalId") == null) ? null : json.get("externalId").toString());
		String hora = ((json.get("hora") == null) ? null : json.get("hora").toString());
		String estado = ((json.get("estado") == null) ? null : json.get("estado").toString());
		Integer prioridad = ((json.get("prioridad") == null) ? null : Integer.parseInt(json.get("prioridad").toString()));
		Integer idTramite = ((json.get("idTramite") == null) ? null : Integer.parseInt(json.get("idTramite").toString()));
		String idSector = ((json.get("idSector") == null) ? null : json.get("idSector").toString());
		JSONNumero numero = new JSONNumero(id,externalId,hora,estado,prioridad,idTramite,idSector);
		return numero;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public List<JSONNumero> toJSONNumeros(String jsonNumero){
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(jsonNumero);
	        JSONArray array = (JSONArray)obj;
	        List<JSONNumero> numerosReturn = new ArrayList<JSONNumero>();
	        
	    	Iterator<JSONObject> iterator = array.iterator();
	    	while (iterator.hasNext()) {
	    		numerosReturn.add(this.toJSONNumero(iterator.next().toJSONString()));
	    	}
			return numerosReturn;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
