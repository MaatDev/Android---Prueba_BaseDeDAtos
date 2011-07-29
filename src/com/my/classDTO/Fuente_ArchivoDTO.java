package com.my.classDTO;

public class Fuente_ArchivoDTO {
	
	public static final String campo_cod_fuente = "_id";
	public static final String campo_desc_fuente = "desc_fuente";
	
	private int cod_fuente;
	private String desc_fuente;
	
	public int getCod_fuente() {
		return cod_fuente;
	}
	public void setCod_fuente(int cod_fuente) {
		this.cod_fuente = cod_fuente;
	}
	public String getDesc_fuente() {
		return desc_fuente;
	}
	public void setDesc_fuente(String desc_fuente) {
		this.desc_fuente = desc_fuente;
	}
		
}
