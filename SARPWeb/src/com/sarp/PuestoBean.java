package com.sarp;

import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONNumero;
import com.sarp.jsons.JSONPuesto;
import com.sarp.jsons.JSONPuestoTramite;
import com.sarp.jsons.JSONTramite;
import com.sarp.utils.UtilService;

@ManagedBean(name = "puesto", eager = true)
@ViewScoped
public class PuestoBean {
	
	private String maquina;
	private String usuarioId;
	private Integer numero;
	private String estado;
	private String roles;
	private List<JSONTramite> tramites;
	//private List<JSONSector> sectores;
	//atributos de tramite
	private String codigo;
	private String nombre;
	
	//atributos del numero
	private Integer id;
	private String externalId;
	private String hora;
	private String fecha;
	private String estadoNumero;
	private Integer prioridad;
	
	//JSONDatosComp datosComplementarios;
	private Integer idTramite;
	private String idSector;
	private String json_estado_tramites;

	Boolean ejecutado = false;
	private String searchString;
	private List<JSONPuesto> puestosList;
	
	private	ControladorREST c = new ControladorREST();
	private static final JSONModeler modeler = new JSONModeler();
	public SharedBean notice = SharedBean.getInstance();
	public String getOperadorTest(){
		try{
			return UtilService.getStringProperty("MAQUINA_OPERADOR_TEST");
		}catch (Exception e){
			System.out.println("TRANQUILOS DEVOLVEMOS MAQ1");
			return "maq1";
		} 
	}
	
	public String getRecepcionTest(){
		try {
			return UtilService.getStringProperty("MAQUINA_RECEPCION_TEST");	
		} catch (Exception e){
			System.out.println("TRANQUILOS DEVOLVEMOS MAQ2");
			return "maq2";
		}
	}
	
	public String alta() throws Exception {
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, "", this.numero, "");
		String status = c.altaPuesto(jpuesto.toString(), "ResponsableSector");
		notice.updateNotice(status, "El puesto con nombre de maquina "+ this.maquina + " se creó correctamente.", 
				"Ocurrió un error al crear el puesto.");
		return "/pages/puestos.xhtml?faces-redirect=true";
	}
	
	public String baja(String maquina) throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(maquina, "id", 0, "CERRADO");
		String status = c.bajaPuesto(jpuesto.toString(), "ResponsableSector");
		notice.updateNotice(status, "El puesto con nombre de maquina "+ this.maquina + " se eliminó correctamente.", 
				"Ocurrió un error al eliminar el puesto.");
		return "/pages/puestos.xhtml?faces-redirect=true";
	}
	
	public String modificar(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, this.numero, this.estado);
		String status = c.modPuesto(jpuesto.toString(), "ResponsableSector");
		notice.updateNotice(status, "El puesto con nombre de maquina "+ this.maquina + " se modificó correctamente.", 
				"Ocurrió un error al modificar el puesto.");
		return "/pages/puestos.xhtml?faces-redirect=true";
	}
	
	public String goToPuesto(String maquina, String estado, String usuario, String numero) {
		return "/pages/forms.xhtml?tipoForm=modPuesto&estado=" + estado + "&maquina=" + maquina + "&usuario=" + usuario + "&numero=" + numero + "faces-redirect=true";
	}

	public List<JSONPuesto> listar() throws Exception{
		this.puestosList = modeler.toJSONPuestos(c.listarPuestos("ResponsableSector"));
		return this.puestosList;
	}

	public List<JSONTramite> listarDeSector() throws Exception{
		return modeler.toJSONTramites(c.listarTramitesSector(this.maquina, "ResponsableSector"));
	}
	
	public List<JSONPuesto> listarPuestosDeSector(String sectorId) throws Exception{
		if (sectorId == "")
			return null;
		else
			return modeler.toJSONPuestos(c.listarPuestosSector(sectorId, "ResponsableSector"));
	}

	public List<JSONTramite> listarTramitesAsignables(String maquina) throws Exception{
		if (!maquina.equals("")){
			String hhh = c.listarTramitesAsignables(maquina, "ResponsableSector");
			List<JSONTramite> ggg = modeler.toJSONTramites(hhh);;
			return ggg;
		} else {
			return null;
		}
	}
	
	public String asignarTramitePuesto(){
		JSONPuestoTramite jppuestotramiteuestotramite = new JSONPuestoTramite(this.codigo, this.maquina);
		String status = c.asignarTramite(jppuestotramiteuestotramite.toString(), "ResponsableSector");
		notice.updateNotice(status, "El tramite con codigo "+ this.codigo + " se asignó correctamente al puesto con nombre de maquina " + this.maquina + ".", 
				"Ocurrió un error al asignar el tramite con codigo "+ this.codigo + " al puesto con nombre de maquina " + this.maquina + ".");
		return "/pages/puestos.xhtml?faces-redirect=true";
	}

	public String desasignarTramitePuesto(){  //FALTA CAMBIAR
		JSONPuestoTramite jppuestotramiteuestotramite = new JSONPuestoTramite(this.codigo, this.maquina);
		String status = c.desasignarTramite(jppuestotramiteuestotramite.toString(), "ResponsableSector");
		notice.updateNotice(status, "El tramite con codigo "+ this.codigo + " se desasignó correctamente del puesto con nombre de maquina " + this.maquina + ".", 
				"Ocurrió un error al desasignar el tramite con codigo "+ this.codigo + " del puesto con nombre de maquina " + this.maquina + ".");
		return "/pages/puestos.xhtml?faces-redirect=true";
	}

	public String abrir() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.abrirPuesto(jpuesto.toString(), "Operador");
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml";
		}else{
			return "/pages/operadorAbierto.xhtml?faces-redirect=true";
		}
	}
	
	public String cerrar() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, null, null, null);
		c.cerrarPuesto(jpuesto.toString(), "Operador");
		return "/pages/operador.xhtml?faces-redirect=true";
	}
	
	public String comenzarAtencion(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.comenzarAtencion(jpuesto.toString(),"Operador");
		return "/pages/operadorAtendiendo.xhtml?faces-redirect=true";
	}
	
	public String llamarNumero() throws Exception{
		String num = c.llamarNumero(this.maquina, "Operador");
		if(num != null){
			JSONNumero jnumero = modeler.toJSONNumero(num);
			this.externalId = jnumero.getExternalId(); 
			this.prioridad = jnumero.getPrioridad();
			if(this.prioridad.equals(1)){
				String[] arrayFechaHora = jnumero.getHora().split("-");
				this.fecha = arrayFechaHora[0];
				this.hora = arrayFechaHora[1];
			}
			return "/pages/operadorAtencion.xhtml?faces-redirect=true";
		}else{
			/*this.error_message = "No tienes n�meros disponibles para llamar en este momento";
			this.error = "show";*/
			return "/pages/operadorAbierto.xhtml?faces-redirect=true";
		}
	}
	
	public String liberar(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.atrasarNumero(jpuesto.toString(),"Operador");
		this.estado="DISPONIBLE";
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
		}else{
			return "/pages/operadorAbierto.xhtml?faces-redirect=true";
		}
	}
	
	public String pausar() {
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.pausarNumero(jpuesto.toString(),"Operador");
		this.estado="DISPONIBLE";
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
		}else{
			return "/pages/operadorAbierto.xhtml?faces-redirect=true";
		}
	}
	
	public List<JSONNumero> listarNumeros() throws Exception{
		return modeler.toJSONNumeros(c.listarNumeros(this.maquina,"Operador"));
	}
	
	public String llamarNumeroDemanda(String internalId){
		JSONNumero num = modeler.toJSONNumero(c.llamarNumeroDemanda(internalId,this.maquina,"Operador"));
		this.externalId = num.getExternalId();
		this.estadoNumero = num.getEstado();
		this.prioridad = num.getPrioridad();
		if(this.prioridad.equals(1)){
			String[] arrayFechaHora = hora.split("-");
			this.fecha = arrayFechaHora[0];
			this.hora = arrayFechaHora[1];
		}else{
			this.fecha = "";
			this.hora = "";
		}
		this.idTramite = num.getIdTramite();
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorAtencion.xhtml?faces-redirect=true";
			
		}else{
			return "/pages/operadorsrAtencion.xhtml?faces-redirect=true";
		}
	}

	public List<JSONNumero> listarNumerosPausados() {
		return modeler.toJSONNumeros(c.listarNumerosPausados(this.maquina,"Operador"));
	}
	
	public List<JSONNumero> listarNumerosAtrasados(){
		return modeler.toJSONNumeros(c.listarNumerosAtrasados(this.maquina,"Operador"));
	}
	
	public String showEstadosFinalizar(){
		return "/pages/finalizarAtencion.xhtml?faces-redirect=true&id="+ this.maquina;
	}
	
	public void finalizarAtencion(){
		//JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		//c.finalizarAtencion(jpuesto.toString(),"Operador");
		String json = this.json_estado_tramites.substring(0,this.json_estado_tramites.length()-1) + "]}";
		c.finalizarAtencion(json, "Operador");
		System.out.println(json);
	}
	
	public void desviar(){
		System.out.println("Entre en desviar");
	}

	public String volver(){
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml?faces-redirect=true";
		} else {
			return "/pages/operadorAbierto.xhtml?faces-redirect=true";
		}
	}
	
	public String llamarNumeroPausado(String internalId){
		JSONNumero num = modeler.toJSONNumero(c.llamarNumeroPausado(internalId,this.maquina,"Operador"));
		this.externalId = num.getExternalId();
		this.estadoNumero = num.getEstado();
		this.prioridad = num.getPrioridad();
		if(this.prioridad.equals(1)){
			String[] arrayFechaHora = hora.split("-");
			this.fecha = arrayFechaHora[0];
			this.hora = arrayFechaHora[1];
		}else{
			this.fecha = "";
			this.hora = "";
		}
		this.idTramite = num.getIdTramite();
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorAtencion.xhtml?faces-redirect=true";
			
		}else{
			return "/pages/operadorsrAtencion.xhtml?faces-redirect=true";
		}
	}
	
	public String llamarNumeroAtrasado(String internalId){
		JSONNumero num = modeler.toJSONNumero(c.llamarNumeroAtrasado(internalId,this.maquina,"Operador"));
		this.externalId = num.getExternalId();
		this.estadoNumero = num.getEstado();
		this.prioridad = num.getPrioridad();
		if(this.prioridad.equals(1)){
			String[] arrayFechaHora = hora.split("-");
			this.fecha = arrayFechaHora[0];
			this.hora = arrayFechaHora[1];
		}else{
			this.fecha = "";
			this.hora = "";
		}
		this.idTramite = num.getIdTramite();
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorAtencion.xhtml?faces-redirect=true";
			
		}else{
			return "/pages/operadorsrAtencion.xhtml?faces-redirect=true";
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


	public String getJson_estado_tramites() {
		return json_estado_tramites;
	}

	public void setJson_estado_tramites(String json_estado_tramites) {
		this.json_estado_tramites = json_estado_tramites;
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

	public Integer getIdTramite() {
		return idTramite;
	}

	public void setIdTramite(Integer idTramite) {
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
}
