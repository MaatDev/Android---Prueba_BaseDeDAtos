package com.my.classDTO;

public class TipoDTO {
	
	public static final String campo_cod_tipo = "_id";
	public static final String campo_desc_tipo = "desc_tipo";
		
	private int cod_tipo;
	private String desc_tipo;
	
	
	public int getCod_tipo() {
		return cod_tipo;
	}
	public void setCod_tipo(int cod_tipo) {
		this.cod_tipo = cod_tipo;
	}
	public String getDesc_tipo() {
		return desc_tipo;
	}
	public void setDesc_tipo(String desc_tipo) {
		this.desc_tipo = desc_tipo;
	}
	
	
	

}
