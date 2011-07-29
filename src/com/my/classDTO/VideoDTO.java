package com.my.classDTO;

public class VideoDTO {
	
	public static final String campo_cod_video="_id";
	public static final String campo_cod_fuente="cod_fuente";
	public static final String campo_url_external_video = "url_external_video";
	public static final String campo_url_local_video = "url_local_video";
	public static final String campo_cod_plato = "cod_plato";
	
	private int cod_video;
	private Fuente_ArchivoDTO fuente;
	private String url_external_video;
	private String url_local_video;
	private int cod_plato;
	
	public VideoDTO(){
		
		fuente = new Fuente_ArchivoDTO();
		
	}
	
	public int getCod_video() {
		return cod_video;
	}
	public void setCod_video(int cod_video) {
		this.cod_video = cod_video;
	}
	public String getUrl_external_video() {
		return url_external_video;
	}
	public void setUrl_external_video(String url_external_video) {
		this.url_external_video = url_external_video;
	}
	public String getUrl_local_video() {
		return url_local_video;
	}
	public void setUrl_local_video(String url_local_video) {
		this.url_local_video = url_local_video;
	}
	public int getCod_plato() {
		return cod_plato;
	}
	public void setCod_plato(int cod_plato) {
		this.cod_plato = cod_plato;
	}
	public Fuente_ArchivoDTO getFuente() {
		return fuente;
	}
	public void setFuente(Fuente_ArchivoDTO fuente) {
		this.fuente = fuente;
	}
	
	

}
