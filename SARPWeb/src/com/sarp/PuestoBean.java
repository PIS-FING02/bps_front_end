package com.sarp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONCantNumEnSector;
import com.sarp.jsons.JSONEstadoPuesto;
import com.sarp.jsons.JSONNumero;
import com.sarp.jsons.JSONPuesto;
import com.sarp.jsons.JSONPuestoTramite;
import com.sarp.jsons.JSONSector;
import com.sarp.jsons.JSONSectorPuesto;
import com.sarp.jsons.JSONTramite;



@ManagedBean(name = "puesto", eager = true)
@SessionScoped
public class PuestoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String estadoComboBox;
	private String maquina;
	private String usuarioId;
	private Integer numero;
	private String estado;
	private String roles;
	private List<JSONTramite> tramites;
	private List<JSONSector> sectores;
	private String codigo;
	private String nombre;
	
	//atributos del numero
	private Integer id;
	private String externalId;
	private String hora;
	private String fecha;
	private String estadoNumero;
	private Integer prioridad;
	private String tiempoEspera;
	private String serie;
	private String externalNum;
	//JSONDatosComp datosComplementarios;

	private String idTramite;
	private String idSector;
	private boolean es_desvio;
	private String sector_desvio;
	private String json_estado_tramites;

	private String searchString;
	private List<JSONPuesto> puestosList;
	private List<JSONPuesto> puestosListBusqueda = new ArrayList<JSONPuesto>();
	private List<JSONPuesto> puestosListAsignar;
	private List<JSONPuesto> puestosListBusquedaAsignar = new ArrayList<JSONPuesto>();
	private List<JSONPuesto> puestosListDesasignar;
	private List<JSONPuesto> puestosListBusquedaDesasignar = new ArrayList<JSONPuesto>();
	
	@ManagedProperty("#{sessionScope.login}")
	public LoginBean login;
	
	@ManagedProperty("#{sector}")
	public SectorBean sector;
	
	@ManagedProperty("#{sessionScope.shared}")
	public SharedBean shared;
	
	private	ControladorREST c = new ControladorREST();
	private static final JSONModeler modeler = new JSONModeler();

	

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public SectorBean getSector() {
		return sector;
	}

	public void setSector(SectorBean sector) {
		this.sector = sector;
	}

	public SharedBean getShared() {
		return shared;
	}

	public void setShared(SharedBean shared) {
		this.shared = shared;
	}

	
	public String alta() throws Exception {
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, "", this.numero, "");
		String status = c.altaPuesto(jpuesto.toString(), "RESPSEC");
		
		JSONSectorPuesto jsectorpuesto = new JSONSectorPuesto(this.idSector, this.maquina);
		String response = c.asignarPuestoSector(jsectorpuesto.toString(), "RESPSEC");
		
		if (status.contains("existe")) {
			shared.updateNotice(response, "El puesto con nombre de m�quina "+ this.maquina + " ya se encontraba en el sistema, se asign� correctamente al sector con c�digo " + this.idSector + ".");
		} else if (status.equals("OK")) {
			shared.updateNotice(response, "El puesto con nombre de m�quina "+ this.maquina + " fue creado y se asign� correctamente al sector con c�digo " + this.idSector + ".");
		} else {
			shared.updateNotice(status, "");
		}
		return "/pages/sectores.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String baja(String maquina) throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(maquina, "id", 0, "CERRADO");
		String status = c.bajaPuesto(jpuesto.toString(), "RESPSEC");
		shared.updateNotice(status, "El puesto con nombre de m�quina "+ maquina + " se elimin� correctamente.");
		return "/pages/puestos.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String modificar(){
		Integer numero = this.numero;
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, numero, this.estadoComboBox);
		System.out.println(jpuesto);
		String status = c.modPuesto(jpuesto.toString(), "RESPSEC");
		shared.updateNotice(status, "El puesto con nombre de m�quina "+ this.maquina + " se modific� correctamente.");
		return "/pages/puestos.xhtml?busqueda=false&faces-redirect=true";
	}
	
	public String goToPuesto(String maquina, String estado, String usuario, String numero) {
		return "/pages/forms.xhtml?tipoForm=modPuesto&estado=" + estado + "&maquina=" + maquina + "&usuario=" + usuario + "&numero=" + numero + "faces-redirect=true";
	}

	public List<JSONPuesto> listar() throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> requestMap = context.getExternalContext().getSessionMap();

		if (shared.getRolesMap().get("RESPSEC")){	

			String resp = c.listarPuestos("RESPSEC",shared.getUser());
			Pattern pat = Pattern.compile("(.*)ERROR(.*)");
			Matcher numNotFound = pat.matcher(resp);
		
			if(!numNotFound.find()){
				this.puestosList = modeler.toJSONPuestos(resp);
				if (this.puestosList.isEmpty())
					shared.updateNoticeInfo("No se encontraron puestos para el sector/es donde tienes autorizaci�n.");
				return this.puestosList;
			}else{
				//shared.updateNotice("ERROR",resp);
				throw new Exception(resp);
			}
			
		} else {
			return null;
		}
	}

	public List<JSONPuesto> listarParaSector(String input) throws Exception {
		shared.clean();
		if (shared.getRolesMap().get("RESPSEC")) {
			this.puestosListAsignar = modeler.toJSONPuestos(c.listarPuestosParaSector(input, "RESPSEC", shared.getUser()));
			if (this.puestosListAsignar.isEmpty())
				shared.updateNoticeInfo("No se encontraron puestos disponibles en el sistema.");
			return this.puestosListAsignar;
		} else if (shared.getRolesMap().get("CONSULTOR")) {
			this.puestosListAsignar = modeler.toJSONPuestos(c.listarPuestosParaSector(input, "CONSULTOR", shared.getUser()));
			if (this.puestosListAsignar.isEmpty())
				shared.updateNoticeInfo("No se encontraron puestos disponibles en el sistema.");
			return this.puestosListAsignar;
		}else{
			return null;
		}
	}

	public List<JSONTramite> listarDeSector() throws Exception {
		shared.clean();
		List<JSONTramite> list = modeler.toJSONTramites(c.listarTramitesSector(this.maquina, "RESPSEC"));
		if (list.isEmpty())
			shared.updateNoticeInfo("El puesto con nombre de m�quina " + this.maquina + " no tiene ning�n tr�mite asignado.");
		return list;
	}
	
	public List<JSONPuesto> listarPuestosDeSector(String sectorId) throws Exception{
		shared.clean();
		if (sectorId == ""){
			return null;
		}else{
			this.puestosListDesasignar = modeler.toJSONPuestos(c.listarPuestosSector(sectorId, "RESPSEC"));
			if (this.puestosListDesasignar.isEmpty())
				shared.updateNoticeInfo("El sector con identificador " + sectorId + " no tiene ning�n puesto asignado.");
			return this.puestosListDesasignar;
		}
	}

	public List<JSONTramite> listarTramitesAsignables(String maquina) {
		shared.clean();
		if (!maquina.equals("")){
			try {
				List<JSONTramite> list = modeler.toJSONTramites(c.listarTramitesAsignables(maquina, "RESPSEC"));
				if (list.isEmpty())
					shared.updateNoticeInfo("No se encontraron tr�mites disponibles para asignarle al puesto con nombre de m�quina " + maquina + ".");
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				shared.updateNoticeInfo("El puesto con nombre de m�quina " + maquina + " no tiene ning�n sector asociado.");
				return null;
			}
		} else {
			return null;
		}
	}
	
	public String asignarTramitePuesto() throws Exception {
		JSONPuestoTramite jppuestotramiteuestotramite = new JSONPuestoTramite(this.codigo, this.maquina);
		String status = c.asignarTramite(jppuestotramiteuestotramite.toString(), "RESPSEC");
		shared.updateNotice(status, "El tr�mite con c�digo "+ this.codigo + " se asign� correctamente al puesto con nombre de m�quina " + this.maquina + ".");
		return "/pages/puestos.xhtml?busqueda=false&faces-redirect=true";
	}

	public String desasignarTramitePuesto() {  
		JSONPuestoTramite jppuestotramiteuestotramite = new JSONPuestoTramite(this.codigo, this.maquina);
		String status = c.desasignarTramite(jppuestotramiteuestotramite.toString(), "RESPSEC");
		shared.updateNotice(status, "El tr�mite con c�digo "+ this.codigo + " se desasign� correctamente del puesto con nombre de m�quina " + this.maquina + ".");
		return "/pages/puestos.xhtml?busqueda=false&faces-redirect=true";
	}

	public String abrir() throws Exception {
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		String response = c.abrirPuesto(jpuesto.toString(), "OPERADOR");
		
		if (response.startsWith("ERROR")) {
			shared.updateNotice(response, "");
			return "/pages/operadorAtencion.xhtml?faces-redirect=true";
		} else {
			JSONEstadoPuesto jestadoPuesto = modeler.toJSONEstadoPuesto(response);
			this.estado=jestadoPuesto.getPuesto().getEstado();
			this.sectores = jestadoPuesto.getPuesto().getSectores();
			this.tramites = jestadoPuesto.getPuesto().getTramites();
			
			if(jestadoPuesto.getPuesto().getEstado().equals("LLAMANDO") || jestadoPuesto.getPuesto().getEstado().equals("ATENDIENDO")){
				
				this.id = jestadoPuesto.getNumero().getId();
				this.externalId = jestadoPuesto.getNumero().getExternalId();
				this.hora= jestadoPuesto.getNumero().getHora();
				this.estadoNumero =  jestadoPuesto.getNumero().getEstado();
				this.prioridad = jestadoPuesto.getNumero().getPrioridad();
				this.idSector = jestadoPuesto.getNumero().getIdSector();
				String[] arrayFechaHora = jestadoPuesto.getNumero().getHora().split("-");
				this.fecha = arrayFechaHora[0];
				this.hora = arrayFechaHora[1];
				this.idTramite = jestadoPuesto.getNumero().getIdTramite();
				this.serie= jestadoPuesto.getNumero().getExternalId().split("-")[0];
				this.externalNum = jestadoPuesto.getNumero().getExternalId().split("-")[1];
				GregorianCalendar hora_actual = new GregorianCalendar();
				int dia = Integer.parseInt(this.fecha.substring(0, 2));
				int mes = Integer.parseInt(this.fecha.substring(3, 5)) - 1;
				int ano = Integer.parseInt(this.fecha.substring(6, 10));
				int hora= Integer.parseInt(this.hora.substring(0, 2));
				int min = Integer.parseInt(this.hora.substring(3,5));
				GregorianCalendar horaNumero = new GregorianCalendar(ano, mes, dia, hora, min);
				this.tiempoEspera = this.restaFechas(hora_actual, horaNumero);

			}
			
			if(jestadoPuesto.getPuesto().getEstado().equals("ATENDIENDO"))
				return "/pages/operadorAtendiendo.xhtml?faces-redirect=true";
			else if(jestadoPuesto.getPuesto().getEstado().equals("LLAMANDO"))
				return "/pages/operadorAtencion.xhtml?faces-redirect=true";
			else if(roles.contains("OPERADORSR"))
				return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
			else
				return "/pages/operadorAbierto.xhtml?faces-redirect=true";
		}
	}
	
	public String cerrar() throws Exception {
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, null, null, null);
		c.cerrarPuesto(jpuesto.toString(), "OPERADOR");
		return "/pages/operador.xhtml?faces-redirect=true";
	}
	
	public String comenzarAtencion() {
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.comenzarAtencion(jpuesto.toString(),"OPERADOR");
		return "/pages/operadorAtendiendo.xhtml?faces-redirect=true";
	}
	
	public String llamarNumero() throws Exception {
		String num = c.llamarNumero(this.maquina, "OPERADOR");
		Pattern pat = Pattern.compile("(.*)ERROR(.*)");
		Matcher numNotFound = pat.matcher(num);
	
		//El numero es null o No se pudo encontrar un numero disponible
		if(num != null && !numNotFound.find()){
					
			JSONNumero jnumero = modeler.toJSONNumero(num);
			this.externalId = jnumero.getExternalId(); 
			this.prioridad = jnumero.getPrioridad();
			this.idSector = jnumero.getIdSector();
			this.id = jnumero.getId();
			this.hora = jnumero.getHora();

			if(this.prioridad.equals(1)){
				String[] arrayFechaHora = jnumero.getHora().split("-");
				this.fecha = arrayFechaHora[0];
				this.hora = arrayFechaHora[1];
			}
			this.serie= jnumero.getExternalId().split("-")[0];
			this.externalNum = jnumero.getExternalId().split("-")[1];
			GregorianCalendar hora_actual = new GregorianCalendar();
			int dia = Integer.parseInt(this.hora.substring(0, 2));
			int mes = Integer.parseInt(this.hora.substring(3, 5)) - 1;
			int ano = Integer.parseInt(this.hora.substring(6, 10));
			int hora= Integer.parseInt(this.hora.substring(11, 13));
			int min = Integer.parseInt(this.hora.substring(14));
			GregorianCalendar horaNumero = new GregorianCalendar(ano, mes, dia, hora, min);
			this.tiempoEspera = this.restaFechas(hora_actual, horaNumero);
			return "/pages/operadorAtencion.xhtml?faces-redirect=true";
		}else{
			/*this.error_message = "No tienes n�meros disponibles para llamar en este momento";
			this.error = "show";*/
			shared.updateNoticeInfo("No existe ningún número que pueda atender en este momento");
			if(roles.contains("OPERADORSR")){
				return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
			}else{
				return "/pages/operadorAbierto.xhtml?faces-redirect=true";
			}
		}
	}
	
	public void reLlamarNumero() throws Exception {
		if (shared.getRolesMap().get("OPERADOR"))
			c.rellamarNumero(this.maquina, "OPERADOR");
		else
			c.rellamarNumero(this.maquina, "OPERADORSR");
	}
	
	public String liberar(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.atrasarNumero(jpuesto.toString(),"OPERADOR");
		this.estado="DISPONIBLE";
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
		}else{
			return "/pages/operadorAbierto.xhtml?faces-redirect=true";
		}
	}
	
	public String pausar() {
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.pausarNumero(jpuesto.toString(),"OPERADOR");
		this.estado="DISPONIBLE";
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
		}else{
			return "/pages/operadorAbierto.xhtml?faces-redirect=true";
		}
	}
	
	public List<JSONNumero> listarNumeros() throws Exception{
		return modeler.toJSONNumeros(c.listarNumeros(this.maquina, "OPERADOR"));
	}
	
	public String atrasaryLlamarSiguiente() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.atrasarNumero(jpuesto.toString(),"OPERADOR");
		this.estado="DISPONIBLE";
		return this.llamarNumero();
	}
	
public String llamarNumeroDemanda(String internalId){
		String resp = c.llamarNumeroDemanda(internalId,this.maquina, "OPERADORSR");
		Pattern pat = Pattern.compile("(.*)ERROR(.*)");
		Matcher numNotFound = pat.matcher(resp);

		if(!numNotFound.find()){
			JSONNumero num = modeler.toJSONNumero(resp);
			this.externalId = num.getExternalId();
			this.estadoNumero = num.getEstado();
			this.prioridad = num.getPrioridad();
			this.id = num.getId();
			String[] arrayFechaHora = num.getHora().split("-");
			this.fecha = arrayFechaHora[0];
			this.hora = arrayFechaHora[1];
			this.idTramite = num.getIdTramite();
			this.serie= num.getExternalId().split("-")[0];
			this.externalNum = num.getExternalId().split("-")[1];
			GregorianCalendar hora_actual = new GregorianCalendar();
			int dia = Integer.parseInt(this.fecha.substring(0, 2));
			int mes = Integer.parseInt(this.fecha.substring(3, 5)) - 1;
			int ano = Integer.parseInt(this.fecha.substring(6, 10));
			int hora= Integer.parseInt(this.hora.substring(0, 2));
			int min = Integer.parseInt(this.hora.substring(3,5));
			GregorianCalendar horaNumero = new GregorianCalendar(ano, mes, dia, hora, min);
			this.tiempoEspera = this.restaFechas(hora_actual, horaNumero);
		}else{
			return "/pages/operadorAbierto.xhtml?faces-redirect=true";
		}
			
	return "/pages/operadorAtencion.xhtml?faces-redirect=true";

	}

	public List<JSONNumero> listarNumerosPausados() {
		return modeler.toJSONNumeros(c.listarNumerosPausados(this.maquina, "OPERADOR"));
	}
	
	public List<JSONNumero> listarNumerosAtrasados(){
		return modeler.toJSONNumeros(c.listarNumerosAtrasados(this.maquina, "OPERADOR"));
	}
	
	public String showEstadosFinalizar(){
		return "/pages/finalizarAtencion.xhtml?faces-redirect=true&idSector="+ this.idSector;
	}
	
	public String finalizarAtencion(){
		
		String json = "{\"nombreMaquina\" : \"" + this.maquina + "\",\"id\":" + this.id.toString() + ",\"tramiteResultado\": "+
		this.json_estado_tramites.substring(0,this.json_estado_tramites.length()-1) + "]}";
		
		if(!this.es_desvio)
			c.finalizarAtencion(json, "OPERADOR");
		else
			c.desviarFinaizarAtencion(json, this.sector_desvio, "OPERADOR");	

		if(roles.contains("OPERADORSR"))
			return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
		else
			return "/pages/operadorAbierto.xhtml?faces-redirect=true";
			
	}
	
	public String desviarNumero(String idSector){
		this.es_desvio = true;
		this.setSector_desvio(idSector);
		return "/pages/finalizarAtencion.xhtml?faces-redirect=true&idSector="+ this.idSector;
	}

	public String volver(){
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
		} else {
			return "/pages/operadorAbierto.xhtml?faces-redirect=true";
		}
	}
	
	public String llamarNumeroPausado(String internalId){
		String resp = c.llamarNumeroPausado(internalId,this.maquina, "OPERADOR");
		Pattern pat = Pattern.compile("(.*)ERROR(.*)");
		Matcher numNotFound = pat.matcher(resp);
	
		if(!numNotFound.find()){
			JSONNumero num = modeler.toJSONNumero(resp);
			this.externalId = num.getExternalId();
			this.estadoNumero = num.getEstado();
			this.prioridad = num.getPrioridad();
			this.id = num.getId();
			int dia = 0;
			int mes = 0;
			int ano = 0;
			int horaFin= 0;
			int min = 0;
			
			String[] arrayFechaHora = num.getHora().split("-");
			this.fecha = arrayFechaHora[0];
			this.hora = arrayFechaHora[1];
			dia = Integer.parseInt(this.fecha.substring(0, 2));
			mes = Integer.parseInt(this.fecha.substring(3, 5)) - 1;
			ano = Integer.parseInt(this.fecha.substring(6, 10));
			horaFin= Integer.parseInt(this.hora.substring(0, 2));
			min = Integer.parseInt(this.hora.substring(3,5));
	
			this.idTramite = num.getIdTramite();
			this.serie= num.getExternalId().split("-")[0];
			this.externalNum = num.getExternalId().split("-")[1];
			GregorianCalendar hora_actual = new GregorianCalendar();

			GregorianCalendar horaNumero = (ano == 0)? new GregorianCalendar(ano, mes, dia, horaFin, min) : new GregorianCalendar();
			this.tiempoEspera = this.restaFechas(hora_actual, horaNumero);
			return "/pages/operadorAtencion.xhtml?faces-redirect=true";
			
		}else{
			if(roles.contains("OPERADORSR")){
				return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
				
			}else{
				return "/pages/operadorAbierto.xhtml?faces-redirect=true";
			}
		
		}
		
	}
	
	public String llamarNumeroAtrasado(String internalId){
		
		String resp = c.llamarNumeroAtrasado(internalId,this.maquina, "OPERADOR");
		Pattern pat = Pattern.compile("(.*)ERROR(.*)");
		Matcher numNotFound = pat.matcher(resp);
	
		if(!numNotFound.find()){
			
			
			JSONNumero num = modeler.toJSONNumero(resp);
			this.id = num.getId();
			this.externalId = num.getExternalId();
			this.estadoNumero = num.getEstado();
			this.prioridad = num.getPrioridad();
	
			String[] arrayFechaHora = num.getHora().split("-");
			this.fecha = arrayFechaHora[0];
			this.hora = arrayFechaHora[1];
	
			this.idTramite = num.getIdTramite();
			this.serie= num.getExternalId().split("-")[0];
			this.externalNum = num.getExternalId().split("-")[1];
			GregorianCalendar hora_actual = new GregorianCalendar();
			int dia = Integer.parseInt(this.fecha.substring(0, 2));
			int mes = Integer.parseInt(this.fecha.substring(3, 5)) - 1;
			int ano = Integer.parseInt(this.fecha.substring(6, 10));
			int hora= Integer.parseInt(this.hora.substring(0, 2));
			int min = Integer.parseInt(this.hora.substring(3,5));
			GregorianCalendar horaNumero = new GregorianCalendar(ano, mes, dia, hora, min);
			this.tiempoEspera = this.restaFechas(hora_actual, horaNumero);
			return "/pages/operadorAtencion.xhtml?faces-redirect=true";

			
		}else{
			if(roles.contains("OPERADORSR")){
				return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
				
			}else{
				return "/pages/operadorAbierto.xhtml?faces-redirect=true";
			}
		}
	}
		
	public String verPausados(){
		//atrasar numero y liberar puesto cuando viene de pantalla de atencion
		return "/pages/operadorPausados.xhtml?faces-redirect=true";
	}

	public String verAtrasados(){
		//atrasar numero y liberar puesto cuando viene de pantalla de atencion
		return "/pages/operadorAtrasados.xhtml?faces-redirect=true";
	}
	
	public String listarPuestosBusqueda(String page){
		this.puestosListBusqueda.clear();
		Iterator<JSONPuesto> iter = this.puestosList.iterator();
		while(iter.hasNext()){
			JSONPuesto puestoIter = iter.next();
           	if(puestoIter.getNombreMaquina().toLowerCase().contains(this.searchString.toLowerCase())){
           		this.puestosListBusqueda.add(puestoIter);
           	}
	    }
		return ("/pages/" + page + ".xhtml?busqueda=true&faces-redirect=true");
	}
	
	public String listarPuestosBusquedaAsignaciones(String page,boolean esAsig, String sectorId){
		if(!esAsig){
			this.puestosListBusquedaDesasignar.clear();
			Iterator<JSONPuesto> iter = this.puestosListDesasignar.iterator();
			while(iter.hasNext()){
				JSONPuesto puestoIter = iter.next();
	           	if(puestoIter.getNombreMaquina().toLowerCase().contains(this.searchString.toLowerCase())){
	           		this.puestosListBusquedaDesasignar.add(puestoIter);
	           	}
		    }
			return ("/pages/" + page + ".xhtml?busqueda=true&esSec=true&esAsig=false&entidad=puesto&id=BPS&faces-redirect=true");
		}else{ 
			this.puestosListBusquedaAsignar.clear();
			Iterator<JSONPuesto> iter = this.puestosListAsignar.iterator();
			while(iter.hasNext()){
				JSONPuesto puestoIter = iter.next();
	           	if(puestoIter.getNombreMaquina().toLowerCase().contains(this.searchString.toLowerCase())){
	           		this.puestosListBusquedaAsignar.add(puestoIter);
	           	}
		    }
			return ("/pages/" + page + ".xhtml?busqueda=true&esSec=true&esAsig=true&entidad=puesto&id=BPS&faces-redirect=true");
		}
	}
	
	public String getJson_estado_tramites() {
		return json_estado_tramites;
	}
	
	public List<JSONSector> listarSectoresDesvio() throws Exception{
		System.out.println(idSector);
		if (shared.getRolesMap().get("OPERADOR"))
			return modeler.toJSONSectores(c.listarSectoresDesvio(this.idSector, "OPERADOR"));
		else
			return  modeler.toJSONSectores(c.listarSectoresDesvio(this.idSector, "OPERADORSR"));
		
	}

	public void setJson_estado_tramites(String json_estado_tramites) {
		this.json_estado_tramites = json_estado_tramites;
	}
	
	public SectorBean getSectorBean() {
		return this.sector;
	}
	
	public void setSectorBean(SectorBean sector) {
		this.sector = sector;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEstadoNumero() {
		return estadoNumero;
	}

	public void setEstadoNumero(String estadoNumero) {
		this.estadoNumero = estadoNumero;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public String getIdTramite() {
		return idTramite;
	}

	public void setIdTramite(String idTramite) {
		this.idTramite = idTramite;
	}

	public String getIdSector() {
		return idSector;
	}

	public void setIdSector(String idSector) {
		this.idSector = idSector;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public List<JSONTramite> getTramites() {
		return tramites;
	}

	public void setTramites(List<JSONTramite> tramites) {
		this.tramites = tramites;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public List<JSONPuesto> getPuestosList() {
		return puestosList;
	}

	public void setPuestosList(List<JSONPuesto> puestosList) {
		this.puestosList = puestosList;
	}

	public List<JSONPuesto> getPuestosListBusqueda() {
		return puestosListBusqueda;
	}

	public void setPuestosListBusqueda(List<JSONPuesto> puestosListBusqueda) {
		this.puestosListBusqueda = puestosListBusqueda;
	}


	public List<JSONPuesto> getPuestosListAsignar() {
		return puestosListAsignar;
	}

	public void setPuestosListAsignar(List<JSONPuesto> puestosListAsignar) {
		this.puestosListAsignar = puestosListAsignar;
	}

	public List<JSONPuesto> getPuestosListBusquedaAsignar() {
		return puestosListBusquedaAsignar;
	}

	public void setPuestosListBusquedaAsignar(List<JSONPuesto> puestosListBusquedaAsignar) {
		this.puestosListBusquedaAsignar = puestosListBusquedaAsignar;
	}

	public List<JSONPuesto> getPuestosListDesasignar() {
		return puestosListDesasignar;
	}

	public void setPuestosListDesasignar(List<JSONPuesto> puestosListDesasignar) {
		this.puestosListDesasignar = puestosListDesasignar;
	}

	public List<JSONPuesto> getPuestosListBusquedaDesasignar() {
		return puestosListBusquedaDesasignar;
	}

	public void setPuestosListBusquedaDesasignar(List<JSONPuesto> puestosListBusquedaDesasignar) {
		this.puestosListBusquedaDesasignar = puestosListBusquedaDesasignar;
	}
	
	public boolean isEs_desvio() {
		return es_desvio;
	}

	public void setEs_desvio(boolean es_desvio) {
		this.es_desvio = es_desvio;
	}

	public String getSector_desvio() {
		return sector_desvio;
	}

	public void setSector_desvio(String sector_desvio) {
		this.sector_desvio = sector_desvio;
	}

	public String getTiempoEspera() {
		return tiempoEspera;
	}

	public void setTiempoEspera(String tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}
	
	public  String restaFechas(GregorianCalendar g1,GregorianCalendar g2){
        g1.add(Calendar.HOUR_OF_DAY, -g2.get(Calendar.HOUR_OF_DAY));
        g1.add(Calendar.MINUTE, -g2.get(Calendar.MINUTE));
        g1.add(Calendar.SECOND, -g2.get(Calendar.SECOND));
        if (g1.get(Calendar.HOUR_OF_DAY) > 0)
        	return Integer.toString(g1.get(Calendar.HOUR_OF_DAY))+" hora "+Integer.toString(g1.get(Calendar.MINUTE))+" minutos "+Integer.toString(g1.get(Calendar.SECOND)) + "segundos.";        
        else
        	return Integer.toString(g1.get(Calendar.MINUTE))+" minutos "+Integer.toString(g1.get(Calendar.SECOND)) + " segundos.";        
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getExternalNum() {
		return externalNum;
	}

	public void setExternalNum(String externalNum) {
		this.externalNum = externalNum;
	}

	public List<JSONCantNumEnSector> getNumEnEspera() {
		if(roles.contains("OPERADOR"))
			return   modeler.toJSONCantNumEnSectores(c.obtenerNumEnEspera(this.maquina,"OPERADOR"));
		else
			return   modeler.toJSONCantNumEnSectores(c.obtenerNumEnEspera(this.maquina,"OPERADORSR"));
	}

	public List<JSONSector> getSectores() {
		return sectores;
	}

	public void setSectores(List<JSONSector> sectores) {
		this.sectores = sectores;
	}

	public String getEstadoComboBox() {
		return estadoComboBox;
	}

	public void setEstadoComboBox(String estadoComboBox) {
		this.estadoComboBox = estadoComboBox;
	}
	
	public List<String> listarResultados() throws Exception{
		return c.listarRsultados();
	}

}
