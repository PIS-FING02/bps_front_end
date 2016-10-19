package com.sarp.jsons;

public class JSONDatosComp {

	private String doc;
	private String tipoDoc;
	private String nombreCompleto;
	
	public JSONDatosComp(){}
	
	public JSONDatosComp(String doc, String tipoDoc, String nombreCompleto) {
		this.doc = doc;
		this.tipoDoc = tipoDoc;
		this.nombreCompleto = nombreCompleto;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	 @Override
    public String toString() {
	 	String doc = this.doc!= null ? this.doc: "null";
		String tipoDoc = this.tipoDoc!= null ? this.tipoDoc : "null";
		String nombreCompleto = this.nombreCompleto!= null ? this.nombreCompleto : "null";
	 	
        return "{\n"
			+ "\"docId\":\"" + doc + "\",\n"
			+ "\"tipoDoc\":\"" + tipoDoc + "\",\n"
			+ "\"nombreCompleto\":\""+ nombreCompleto  + "\"\n"
			+ "}";
    }
}
