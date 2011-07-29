package com.my.classDTO;

public class ImagenSecDTO {
	
	public static final String campo_cod_img_sec = "_id";
	public static final String campo_cod_plato = "cod_plato";
	public static final String campo_cod_fuente = "cod_fuente";
	public static final String campo_url_external_img = "url_external_img";
	public static final String campo_url_local_img = "url_local_img";
	
	private int cod_img_sec;
	private Fuente_ArchivoDTO fuente;
	private int cod_plato;
	private String url_external_img;
	private String url_local_img;
	
	public ImagenSecDTO(){
		
		fuente = new Fuente_ArchivoDTO();
		
	}
	
	public Fuente_ArchivoDTO getFuente() {
		return fuente;
	}
	public void setFuente(Fuente_ArchivoDTO fuente) {
		this.fuente = fuente;
	}
	public int getCod_img_sec() {
		return cod_img_sec;
	}
	public void setCod_img_sec(int cod_img_sec) {
		this.cod_img_sec = cod_img_sec;
	}	
	public int getCod_plato() {
		return cod_plato;
	}
	public void setCod_plato(int cod_plato) {
		this.cod_plato = cod_plato;
	}
	public String getUrl_external_img() {
		return url_external_img;
	}
	public void setUrl_external_img(String url_external_img) {
		this.url_external_img = url_external_img;
	}
	public String getUrl_local_img() {
		return url_local_img;
	}
	public void setUrl_local_img(String url_local_img) {
		this.url_local_img = url_local_img;
	}
	
		
}
