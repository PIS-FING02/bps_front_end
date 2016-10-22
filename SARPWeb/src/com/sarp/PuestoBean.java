package com.sarp;

import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.sarp.controllers.ControladorREST;
import com.sarp.jsonModeler.JSONModeler;
import com.sarp.jsons.JSONNumero;
import com.sarp.jsons.JSONPuesto;
import com.sarp.jsons.JSONPuestoTramite;
import com.sarp.jsons.JSONTramite;
import com.sarp.utils.UtilService;

@ManagedBean(name = "puesto", eager = true)
@SessionScoped
public class PuestoBean {
	
	private String maquina;
	private String usuarioId;
	private Integer numero;
	private String estado;
	private String roles;
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
	
	//Atributo para mensaje de errores
	public String error = "hidden";
	public String error_message = "";
	
	private	ControladorREST c = new ControladorREST();
	private static final JSONModeler modeler = new JSONModeler();
	//List<JSONSector> sectores;
	//List<JSONTramite> tramites;
	//JSONNumero numeroAsignado;

	public String getOperadorTest(){
		try{
			return UtilService.getStringProperty("MAQUINA_OPERADOR_TEST");
		}catch (Exception e){
			System.out.println("TRANQUILOS DEVOLVEMOS MAQ1");
			return "maq1";
		} 
	}
	
	public String getRecepcionTest(){
		try{
			return UtilService.getStringProperty("MAQUINA_RECEPCION_TEST");	
		}catch (Exception e){
			System.out.println("TRANQUILOS DEVOLVEMOS MAQ2");
			return "maq2";
		}
		
	}
	
	public void alta() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, "0", this.numero, this.estado);
		String status = c.altaPuesto(jpuesto.toString(), "ResponsableSector");
		if (status.equals("OK")){
			this.error_message="El puesto "+ this.maquina + "se creo correctamente.";
		}else{
			this.error_message = "Ocurrio un error al crear el puesto.";
		}
		this.error = "show";
	}
	
	public void baja() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, "id", 0, "CERRADO");
		String status = c.bajaPuesto(jpuesto.toString(), "ResponsableSector");
		if (status.equals("OK")){
			this.error_message="El puesto "+ this.maquina + "se elimino correctamente.";
		}else{
			this.error_message = "Ocurrio un error al eliminar el puesto.";
		}
		this.error = "show";
	}
	
	public void modificar(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, this.numero, this.estado);
		String status = c.modPuesto(jpuesto.toString(), "ResponsableSector");
		if (status.equals("OK")){
			this.error_message="El puesto "+ this.maquina + "se modifico correctamente.";
		}else{
			this.error_message = "Ocurrio un error al modificar el puesto.";
		}
		this.error = "show";
	}

	public List<JSONPuesto> listar() throws Exception{
		return modeler.toJSONPuestos(c.listarPuestos("ResponsableSector"));
	}

	public List<JSONTramite> listarDeSector() throws Exception{
		return modeler.toJSONTramites(c.listarTramitesSector(this.maquina, "ResponsableSector"));
	}

	public List<JSONTramite> listarTramitesAsignables(String maquina) throws Exception{
		if (!maquina.equals("")){
			return modeler.toJSONTramites(c.listarTramitesAsignables(maquina, "ResponsableSector"));
		} else {
			return null;
		}
	}
	
	public void asignarTramitePuesto(){
		JSONPuestoTramite jppuestotramiteuestotramite = new JSONPuestoTramite(this.maquina, this.codigo);
		String status = c.asignarTramite(jppuestotramiteuestotramite.toString(), "ResponsableSector");
		if (status.equals("OK")){
			this.error_message="El tramite con codigo "+ this.codigo + "se asigno al puesto " + this.maquina;
		}else{
			this.error_message = "Ocurrio un error al asignar el tramite al puesto";
		}
		this.error = "show";
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
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public String abrir() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.abrirPuesto(jpuesto.toString(), "Operador");
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml";
		}else{
			return "/pages/operadorAbierto.xhtml";
		}
	}
	
	public String cerrar() throws Exception{
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, null, null, null);
		c.cerrarPuesto(jpuesto.toString(), "Operador");
		return "/pages/operador.xhtml";
	}
	
	public String comenzarAtencion(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.comenzarAtencion(jpuesto.toString(),"Operador");
		return "/pages/operadorAtendiendo.xhtml";
	}
	
	public String llamarNumero() throws Exception{
		String num = c.llamarNumero(this.maquina, "Operador");
		System.out.print(num);
		JSONNumero jnumero = modeler.toJSONNumero(num);
		this.externalId = jnumero.getExternalId(); 
		this.prioridad = jnumero.getPrioridad();
		if(this.prioridad.equals(1)){
			String[] arrayFechaHora = jnumero.getHora().split("-");
			this.fecha = arrayFechaHora[0];
			this.hora = arrayFechaHora[1];
		}
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAtencion.xhtml"; 
		}else{
			return "/pages/operadorAtencion.xhtml";
		}
	}
	
	public String liberar(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.atrasarNumero(jpuesto.toString(),"Operador");
		this.estado="DISPONIBLE";
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml";
		}else{
			return "/pages/operadorAbierto.xhtml";
		}
	}
	
	public String pausar() {
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.pausarNumero(jpuesto.toString(),"Operador");
		this.estado="DISPONIBLE";
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml";
		}else{
			return "/pages/operadorAbierto.xhtml";
		}
	}
	
	public String hideError(){
		this.error="hidden";
		return "/pages/respSector.xhtml";
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
			return "/pages/operadorAtencion.xhtml";
			
		}else{
			return "/pages/operadorsrAtencion.xhtml";
		}
		
	}

	public List<JSONNumero> listarNumerosPausados() {
		return modeler.toJSONNumeros(c.listarNumerosPausados(this.maquina,"Operador"));
	}
	
	public List<JSONNumero> listarNumerosAtrasados(){
		return modeler.toJSONNumeros(c.listarNumerosAtrasados(this.maquina,"Operador"));
	}
	
	public void finalizarAtencion(){
		JSONPuesto jpuesto = new JSONPuesto(this.maquina, this.usuarioId, null, null);
		c.finalizarAtencion(jpuesto.toString(),"Operador");
	}
	
	public void desviar(){
		System.out.println("Entre en desviar");
	}

	public String volver(){
		if(roles.contains("OPERADORSR")){
			return "/pages/operadorsrAbierto.xhtml";
		}else{
			return "/pages/operadorAbierto.xhtml";
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
			return "/pages/operadorAtencion.xhtml";
			
		}else{
			return "/pages/operadorsrAtencion.xhtml";
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
			return "/pages/operadorAtencion.xhtml";
			
		}else{
			return "/pages/operadorsrAtencion.xhtml";
		}
	}
	
	public String verPausados(){
		//atrasar numero y liberar puesto cuando viene de pantalla de atencion
		return "/pages/operadorPausados.xhtml";
	}

	public String verAtrasados(){
		//atrasar numero y liberar puesto cuando viene de pantalla de atencion
		return "/pages/operadorAtrasados.xhtml";
	}
}
