package com.my.classDTO;

public class ImagenPrimDTO {
	
	public static final String campo_cod_img_prim = "_id";
	public static final String campo_cod_fuente = "cod_fuente";
	public static final String campo_url_external_img = "url_external_img";
	public static final String campo_url_local_img = "url_local_img";
	

	private int cod_img_prim;
	private Fuente_ArchivoDTO fuente;
	private String url_external_img;
	private String url_local_img;
	
	public ImagenPrimDTO(){
		
		fuente = new Fuente_ArchivoDTO();
		
		
	}
	
	
	public Fuente_ArchivoDTO getFuente() {
		return fuente;
	}
	public void setFuente(Fuente_ArchivoDTO fuente) {
		this.fuente = fuente;
	}
	public int getCod_img_prim() {
		return cod_img_prim;
	}
	public void setCod_img_prim(int cod_img_prim) {
		this.cod_img_prim = cod_img_prim;
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
