package com.my.classDTO;

public class IngredienteDTO {
	
	public static final String campo_cod_ingrediente = "_id";
	public static final String campo_desc_ingrediente = "desc_ingrediente";
	public static final String campo_asc_cantidad = "cantidad";
	public static final String campo_asc_unidad = "unidad";
	public static final String campo_asc_cod_plato = "cod_plato";
	public static final String campo_asc_cod_ingrediente = "cod_ingrediente";
	
	private int cod_ingrediente;
	private String desc_ingrediente;
	private int cod_plato;
	private double cantidad;
	private String unidad;
	
	public int getCod_ingrediente() {
		return cod_ingrediente;
	}
	public void setCod_ingrediente(int cod_ingrediente) {
		this.cod_ingrediente = cod_ingrediente;
	}
	public String getDesc_ingrediente() {
		return desc_ingrediente;
	}
	public void setDesc_ingrediente(String desc_ingrediente) {
		this.desc_ingrediente = desc_ingrediente;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public int getCod_plato() {
		return cod_plato;
	}
	public void setCod_plato(int cod_plato) {
		this.cod_plato = cod_plato;
	}
	

}
