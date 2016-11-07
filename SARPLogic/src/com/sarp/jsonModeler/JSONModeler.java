package com.sarp.jsonModeler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sarp.jsons.JSONCantNumEnSector;
import com.sarp.jsons.JSONDisplay;
import com.sarp.jsons.JSONEstadoPuesto;
import com.sarp.jsons.JSONMetricasNumero;
import com.sarp.jsons.JSONMetricasPuesto;
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
	
	public JSONEstadoPuesto toJSONEstadoPuesto(String jsonEstadoPuesto) throws Exception{
		
		System.out.println(jsonEstadoPuesto);
		JSONObject json = (JSONObject)new JSONParser().parse(jsonEstadoPuesto);
		JSONPuesto jpuesto = (json.get("puesto")!= null)? toJSONPuesto(json.get("puesto").toString()) : null;
		JSONNumero jnumero = (json.get("numero")!= null)? toJSONNumero(json.get("numero").toString()) : null;
		JSONEstadoPuesto estadoPuesto = new JSONEstadoPuesto(jpuesto,jnumero);
		
		return estadoPuesto;	
	}
	
	public JSONPuesto toJSONPuesto(String jsonPuesto) throws Exception{
		JSONObject json = (JSONObject)new JSONParser().parse(jsonPuesto);
		
		String usuario = ((json.get("usuarioId") == null) ? null : json.get("usuarioId").toString());
		Integer numero = ((json.get("numeroPuesto") == null) ? null : Integer.parseInt(json.get("numeroPuesto").toString()));
		String estado = ((json.get("estado") == null) ? null : json.get("estado").toString());
		List<JSONSector> sectores = (json.get("sectores")!= null)? toJSONSectores(json.get("sectores").toString()) : null;
		List<JSONTramite> tramites = (json.get("tramites")!= null)? toJSONTramites(json.get("tramites").toString()) : null;
		usuario = ((json.get("usuarioId") == null) ? null : json.get("usuarioId").toString());
		JSONPuesto puesto = new JSONPuesto(json.get("nombreMaquina").toString(), usuario, numero, estado,sectores,tramites);
		return puesto;
	}
	
	public JSONMetricasPuesto toJSONMetricasPuesto(String jsonMetricasPuesto) throws Exception{
		JSONObject json = (JSONObject)new JSONParser().parse(jsonMetricasPuesto);
		
		String nombreMaquina = ((json.get("nombreMaquina") == null) ? null : json.get("nombreMaquina").toString());
		String usuarioAtencion = ((json.get("usuarioAtencion") == null) ? null : json.get("usuarioAtencion").toString());
		String estado = ((json.get("estado") == null) ? null : json.get("estado").toString());
		String timeSpent = ((json.get("timeSpent") == null) ? null : json.get("timeSpent").toString());
		String lastUpdated = ((json.get("lastUpdated") == null) ? null : json.get("lastUpdated").toString());
		String dateCreated = ((json.get("dateCreated") == null) ? null : json.get("dateCreated").toString());
		
		JSONMetricasPuesto puesto = new JSONMetricasPuesto(nombreMaquina,usuarioAtencion,estado,timeSpent,lastUpdated,dateCreated);
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
		String idTramite = ((json.get("idTramite") == null) ? null : json.get("idTramite").toString());
		String idSector = ((json.get("idSector") == null) ? null : json.get("idSector").toString());
		JSONNumero numero = new JSONNumero(id,externalId,hora,estado,prioridad,idTramite,idSector);
		return numero;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public JSONMetricasNumero toJSONMetricasNumero(String jsonNumero) {
		JSONObject json;
		try {
			json = (JSONObject)new JSONParser().parse(jsonNumero);
	
		String externalId = ((json.get("externalId") == null) ? null : json.get("externalId").toString());
		JSONMetricasNumero numero = new JSONMetricasNumero(externalId);
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

	public JSONCantNumEnSector toJSONCantNumEnSector(String jsonNumEnEspera) {
		JSONObject json;
		try {
			json = (JSONObject)new JSONParser().parse(jsonNumEnEspera);

			Integer num = ((json.get("cantNumEspera") == null) ? null : Integer.parseInt(json.get("cantNumEspera").toString()));
			String codigo = ((json.get("codigo") == null) ? null : json.get("codigo").toString());
			String nombre = ((json.get("nombre") == null) ? null : json.get("nombre").toString());
			JSONCantNumEnSector numEnSector = new JSONCantNumEnSector(codigo,nombre,num);
			return numEnSector;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
	}
	
	public List<JSONCantNumEnSector> toJSONCantNumEnSectores(String jsonNumEnEspera) {
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(jsonNumEnEspera);
	        JSONArray array = (JSONArray)obj;
	        List<JSONCantNumEnSector> numerosEnSectorReturn = new ArrayList<JSONCantNumEnSector>();
	        
	    	Iterator<JSONObject> iterator = array.iterator();
	    	while (iterator.hasNext()) {
	    		numerosEnSectorReturn.add(this.toJSONCantNumEnSector(iterator.next().toJSONString()));
	    	}
			return numerosEnSectorReturn;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<JSONMetricasPuesto> toJSONMetricasPuestos(String jsonMetricasPuesto) throws Exception{
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(jsonMetricasPuesto);
	        JSONArray array = (JSONArray)obj;
	        List<JSONMetricasPuesto> metricasReturn = new ArrayList<JSONMetricasPuesto>();
	        
	    	Iterator<JSONObject> iterator = array.iterator();
	    	while (iterator.hasNext()) {
	    		metricasReturn.add(this.toJSONMetricasPuesto(iterator.next().toJSONString()));
	    	}
			return metricasReturn;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<JSONMetricasNumero> toJSONMetricasNumeros(String jsonMetricasNumero) throws Exception{
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(jsonMetricasNumero);
	        JSONArray array = (JSONArray)obj;
	        List<JSONMetricasNumero> metricasReturn = new ArrayList<JSONMetricasNumero>();
	        
	    	Iterator<JSONObject> iterator = array.iterator();
	    	while (iterator.hasNext()) {
	    		metricasReturn.add(this.toJSONMetricasNumero(iterator.next().toJSONString()));
	    	}
			return metricasReturn;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
