package com.my.classDTO;

import java.util.ArrayList;

public class CevicheDTO {
	
	public static final String campo_cod_plato = "_id";
	public static final String campo_nombre = "desc_plato";
	public static final String campo_cod_tipo = "cod_tipo";
	public static final String campo_cod_region = "cod_region";
	public static final String campo_cod_tip = "cod_tip";
	public static final String campo_cod_rating = "cod_rating";
	public static final String campo_cod_img_prim = "cod_img_prim";
	
	
	
	private int cod_plato;
	private String nombre;
	private ImagenPrimDTO img_prim;
	private RatingDTO rating;
	private RegionDTO region;
	private TipDTO tip;
	private TipoDTO tipo;
	private VideoDTO video;
	private ArrayList<ImagenSecDTO> imgs_sec;
	private ArrayList<IngredienteDTO> ingredientes;
	
	
	public CevicheDTO(){
		
		img_prim = new ImagenPrimDTO();
		rating = new RatingDTO();
		region = new RegionDTO();
		tip = new TipDTO();
		tipo = new TipoDTO();
		video = new VideoDTO();
		imgs_sec = new ArrayList<ImagenSecDTO>();
		ingredientes = new ArrayList<IngredienteDTO>();
		
	}
	
	
	public int getCod_plato() {
		return cod_plato;
	}
	public void setCod_plato(int cod_plato) {
		this.cod_plato = cod_plato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ImagenPrimDTO getImg_prim() {
		return img_prim;
	}
	public void setImg_prim(ImagenPrimDTO img_prim) {
		this.img_prim = img_prim;
	}
	public RatingDTO getRating() {
		return rating;
	}
	public void setRating(RatingDTO rating) {
		this.rating = rating;
	}
	public RegionDTO getRegion() {
		return region;
	}
	public void setRegion(RegionDTO region) {
		this.region = region;
	}
	public TipDTO getTip() {
		return tip;
	}
	public void setTip(TipDTO tip) {
		this.tip = tip;
	}
	public TipoDTO getTipo() {
		return tipo;
	}
	public void setTipo(TipoDTO tipo) {
		this.tipo = tipo;
	}
	public ArrayList<ImagenSecDTO> getImgs_sec() {
		return imgs_sec;
	}
	public void setImgs_sec(ArrayList<ImagenSecDTO> imgs_sec) {
		this.imgs_sec = imgs_sec;
	}
	public ArrayList<IngredienteDTO> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<IngredienteDTO> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public VideoDTO getVideo() {
		return video;
	}
	public void setVideo(VideoDTO video) {
		this.video = video;
	}
	
	
	
	

}
