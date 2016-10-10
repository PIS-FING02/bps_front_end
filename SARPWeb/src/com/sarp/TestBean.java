package com.sarp;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sarp.jsons.JSONDisplay;
import com.sarp.jsons.JSONTramite;

@ManagedBean(name = "test", eager = true)
@ViewScoped
public class TestBean {

	private TramiteBean tb = new TramiteBean();
	private PuestoBean pb = new PuestoBean();
	private DisplayBean db = new DisplayBean();
	
	public void testTramite() throws Exception {
		tb.setNombre("nombreTest");
		tb.alta();
		tb.setNombre("nombreTestMod");
		db.setRuta("rutaTestMod");
		List<JSONTramite> lista = tb.listar();
		tb.setCodigo(String.valueOf(lista.get(lista.size() - 1).getCodigo()));
		tb.modificar();
		tb.baja();
	}
	
	public void testDisplay() throws Exception {
		db.setRuta("rutaTest");
		db.alta();
		db.setRuta("rutaTestMod");
		List<JSONDisplay> lista = db.listar();
		db.setId(lista.get(lista.size() - 1).getDisplayId());
		db.modificar();
		db.baja();
	}
	
	public void testPuesto() throws Exception {
		pb.setEstado("CERRADO");
		pb.setMaquina("nombreMAquinaTest");
		pb.setNumero(0);
		pb.setUsuarioId("15");
		pb.alta();
		pb.setEstado("ATENDIENDO");
		pb.setNumero(5);
		pb.setUsuarioId("150");
		pb.modificar();
		pb.baja();
	}
}
