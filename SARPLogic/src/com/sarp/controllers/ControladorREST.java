package com.sarp.controllers;

import com.sarp.facade.PuestoFacade;
import com.sarp.facade.SectorFacade;
import com.sarp.facade.TramiteFacade;
import com.sarp.utils.UtilService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.sarp.facade.AttentionsFacade;
import com.sarp.facade.DisplayFacade;
import com.sarp.facade.NumeroFacade;

public class ControladorREST {

	PuestoFacade puestoFacade;
	TramiteFacade tramiteFacade;
	DisplayFacade displayFacade;
	SectorFacade sectorFacade;
	NumeroFacade numeroFacade;
	AttentionsFacade attentionsFacade;
	
	public ControladorREST(){
		this.puestoFacade = new PuestoFacade();
		this.tramiteFacade = new TramiteFacade();
		this.displayFacade = new DisplayFacade();
		this.sectorFacade = new SectorFacade();
		this.attentionsFacade = new AttentionsFacade();
		this.numeroFacade = new NumeroFacade();
	}

	//NUMEROS
	public String sacarNumero(String input, String userRol) throws Exception {
		return this.numeroFacade.sacar(input, userRol);
	}
	
	//PUESTOS
	public String listarPuestos(String userRol, String user) throws Exception {
		return this.puestoFacade.puestosAll(userRol, user);
	}

	public String listarPuestosParaSector(String input, String userRol, String user) throws Exception {
		return this.puestoFacade.puestosParaSector(input, userRol, user);
	}
	
	public String listarPuestosSector(String input, String userRol) throws Exception {
		return this.puestoFacade.puestosSector(input, userRol);
	}

	public String altaPuesto(String input, String userRol) throws Exception {
		return this.puestoFacade.alta(input,  userRol);
}

	public String bajaPuesto(String input, String userRol) {
		return this.puestoFacade.baja(input, userRol);
	}

	public String modPuesto(String input, String userRol) {
		return this.puestoFacade.mod(input, userRol);
	}

	public String asignarTramite(String input, String userRol) throws Exception {
		return this.puestoFacade.asignarTramite(input, userRol);
	}
	
	public String desasignarTramite(String input, String userRol) {
		return this.puestoFacade.desasignarTramite(input, userRol);
	}

	public String listarTramitesAsignables(String input, String userRol) {
		return this.puestoFacade.listarTramitesAsignables(input, userRol);
	}
	
	//TRAMITES
	public String listarTramite(String userRol, String user) throws Exception {
		return this.tramiteFacade.tramitesAll(userRol, user);
	}

	public String listarTramiteParaSector(String input, String userRol, String user) throws Exception {
		return this.tramiteFacade.tramitesParaSector(input, userRol, user);
	}

	public String listarTramitesSector(String input, String userRol) throws Exception {
		return this.tramiteFacade.tramitesSector(input, userRol);
	}

	public String listarTramitesRecepcion(String input, String userRol) throws Exception {
		return this.tramiteFacade.tramitesRecepcion(input, userRol);
	}

	public String listarTramitesPuesto(String input, String userRol) throws Exception {
		return this.tramiteFacade.tramitesPuesto(input, userRol);
	}

	public String altaTramite(String input, String userRol) throws Exception {
		return this.tramiteFacade.alta(input,  userRol);
}

	public String bajaTramite(String input, String userRol) {
		return this.tramiteFacade.baja(input, userRol);
	}

	public String modTramite(String input, String userRol) {
		return this.tramiteFacade.mod(input, userRol);
	}
	
	//DISPLAYS
	public String altaDisplay(String input, String userRol) throws Exception {
		return this.displayFacade.alta(input, userRol);
	}
	
	public String bajaDisplay(String input, String userRol)  {
		return this.displayFacade.baja(input, userRol);
	}
	
	public String modificarDisplay(String input, String userRol) throws Exception {
		return this.displayFacade.mod(input, userRol);
	}	

	public String listarDisplays(String userRol) {
		return this.displayFacade.displaysAll(userRol);
	}

	public String listarDisplaysParaSector(String input, String userRol, String user) throws Exception {
		return this.displayFacade.displaysParaSector(input, userRol, user);
	}

	public String listarDisplaysSector(String input, String userRol) throws Exception {
		return this.displayFacade.displaysSector(input, userRol);
	}

	//SECTORES
	public String importarSectoreGafu(String userRol)  {
		return this.sectorFacade.importarSectoresGafu(userRol);
	}
	
	public String listarSectores(String userRol, String user)  {
		return this.sectorFacade.sectoresAll(userRol, user);
	}

	//ATENCION
	public String abrirPuesto(String input, String userRol){
		return this.attentionsFacade.abrir(input, userRol);
	}
	
	public String cerrarPuesto(String input, String userRol){
		return this.attentionsFacade.cerrar(input, userRol);
	}
	
	public String asignarTramiteSector(String input, String userRol) throws Exception  {
		return this.sectorFacade.asignarTramiteSector(input, userRol);
	}
	
	public String desasignarTramiteSector(String input, String userRol)  {
		return this.sectorFacade.desasignarTramiteSector(input, userRol);
	}
	
	public String asignarPuestoSector(String input, String userRol) throws Exception {
		return this.sectorFacade.asignarPuestoSector(input, userRol);
	}
	
	public String desasignarPuestoSector(String input, String userRol) {
		return this.sectorFacade.desasignarPuestoSector(input, userRol);
	}

	public String asignarDisplayoSector(String input, String userRol) throws Exception {
		return this.sectorFacade.asignarDisplaySector(input,userRol);	
	}
	
	public String desasignarDisplayoSector(String input, String userRol) {
		return this.sectorFacade.desasignarDisplaySector(input,userRol);	
	}

	public String llamarNumero(String hparam, String userRol){
		return this.attentionsFacade.llamarNumero(hparam, userRol);
	}
	
	public String listarNumeros(String input, String userRol){
		return this.attentionsFacade.listarNumeros(input, userRol);
	}

	public String listarNumerosPausados(String input, String userRol) {
		return this.attentionsFacade.listarNumerosPausados(input, userRol);
	}

	public String listarNumerosAtrasados(String input, String userRol) {
		return this.attentionsFacade.listarNumerosAtrasados(input, userRol);
	}

	public String comenzarAtencion(String input, String userRol) {
		return this.attentionsFacade.comenzarAtencion(input,userRol);
	}

	public String atrasarNumero(String maquina, String userRol) {
		return this.attentionsFacade.atrasarNumero(maquina,userRol);	
	}

	public String pausarNumero(String input, String userRol) {
		return this.attentionsFacade.pausarNumero(input, userRol);
	}

	public String finalizarAtencion(String input, String userRol) {
		return this.attentionsFacade.finalizarAtencion(input,userRol);
	}

	public String llamarNumeroPausado(String input, String input2, String userRol) {
		return this.attentionsFacade.llamarNumeroPausado(input,input2, userRol);
	}

	public String llamarNumeroAtrasado(String externalId, String maquina, String userRol) {
		return this.attentionsFacade.llamarNumeroAtrasado(externalId,maquina,userRol);
	}

	public String listarNumerosSector(String idSector, String userRol) {
		return this.sectorFacade.listarNumerosSector(idSector,userRol);
	}

	public String llamarNumeroDemanda(String internalId, String maquina, String userRol) {
		return this.attentionsFacade.llamarNumeroDemanda(internalId,maquina, userRol);
	}

	public String listarTramiteSector(String idSector, String userRol) throws Exception {
		return this.tramiteFacade.tramitesSector(idSector,userRol);
	}

	public String listarNumerosPausadosSector(String idSector, String userRol, String user) {
		return this.sectorFacade.listarNumerosPausadosSector(idSector, userRol, user);
	}
	
	public String listarNumerosAtrasadosSector(String idSector, String userRol, String user) {
		return this.sectorFacade.listarNumerosAtrasadosSector(idSector, userRol, user);
	}

	public String listarNumerosEnEsperaSector(String idSector, String userRol, String user) {
		return this.sectorFacade.listarNumerosEnEsperaSector(idSector, userRol, user);
	}

	public String rellamarNumero(String maquina, String userRol) {
		return this.attentionsFacade.reLlamarNumero(maquina, userRol);
	}

	public String listarSectoresDesvio(String idSector, String userRol) {
		return this.sectorFacade.listarSectoresDesvio(idSector, userRol);
	}

	public String desviarFinaizarAtencion(String json, String sector_desvio, String userRol) {
		return this.attentionsFacade.desviarFinalizarAtencion(json,sector_desvio,userRol);
		
	}

	public String listarTramite(String idSector, String userRol, String user) throws Exception {
		return this.tramiteFacade.tramitesParaSector(idSector, userRol, user);
	}

	public String obtenerNumEnEspera(String idPuesto, String userRol) {
		return this.attentionsFacade.obtenerNumEnEspera(idPuesto,userRol);
	}
	
	//METRICAS
	public String listarMetricasPuestos(String userRol,String user){
		return this.puestoFacade.listarMetricasPuestos(userRol,user);
	}
	
	public String listarMetricasPuesto(String nombreMaquina, String userRol, String user){
		return this.puestoFacade.listarMetricasPuesto(nombreMaquina,userRol,user);
	}
	
	public String listarMetricasNumeros(String userRol,String user){
		return this.numeroFacade.listarMetricasNumeros(userRol,user);
	}
	
	public String listarMetricasNumero(String externalId, String userRol, String user){
		return this.numeroFacade.listarMetricasNumero(externalId,userRol,user);
	}
	
	public String listarMetricasNumerosEstado(String userRol,String user){
		return this.numeroFacade.listarMetricasNumerosEstado(userRol,user);
	}
	
	public String listarMetricasNumeroEstado(String externalId, String userRol, String user){
		return this.numeroFacade.listarMetricasNumeroEstado(externalId,userRol,user);
	}

	public List<String> listarRsultados() {
		return  Arrays.asList(UtilService.getStringProperty("RESULTADO_ATENCION").split("&"));
	}
}
