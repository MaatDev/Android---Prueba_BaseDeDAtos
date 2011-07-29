package com.my.classDTO;

public class RegionDTO {
	
	public static final String campo_cod_region = "_id";
	public static final String campo_desc_region = "desc_region";
	
	private int cod_region;
	private String desc_region;
	
	public int getCod_region() {
		return cod_region;
	}
	public void setCod_region(int cod_region) {
		this.cod_region = cod_region;
	}
	public String getDesc_region() {
		return desc_region;
	}
	public void setDesc_region(String desc_region) {
		this.desc_region = desc_region;
	}
		
	
}
