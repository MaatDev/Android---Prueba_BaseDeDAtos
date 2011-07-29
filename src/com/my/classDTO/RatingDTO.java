package com.my.classDTO;

public class RatingDTO {
	
	public static final String campo_cod_rating = "_id";
	public static final String campo_num_estrellas = "num_estrellas";
	public static final String campo_desc_comentario = "desc_comentario";
	
	
	private int cod_rating;
	private int num_estrellas;
	private String desc_comentario;
	
	
	public int getCod_rating() {
		return cod_rating;
	}
	public void setCod_rating(int cod_rating) {
		this.cod_rating = cod_rating;
	}
	public int getNum_estrellas() {
		return num_estrellas;
	}
	public void setNum_estrellas(int num_estrellas) {
		this.num_estrellas = num_estrellas;
	}
	public String getDesc_comentario() {
		return desc_comentario;
	}
	public void setDesc_comentario(String desc_comentario) {
		this.desc_comentario = desc_comentario;
	}
	
	

}
