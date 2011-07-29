package com.my.classDTO;

public class TipDTO {
	
	public static final String campo_cod_tip = "_id";
	public static final String campo_desc_tip = "desc_tip";
	
	private int cot_tip;
	private String desc_tip;
	
	
	public int getCot_tip() {
		return cot_tip;
	}
	public void setCot_tip(int cot_tip) {
		this.cot_tip = cot_tip;
	}
	public String getDesc_tip() {
		return desc_tip;
	}
	public void setDesc_tip(String desc_tip) {
		this.desc_tip = desc_tip;
	}
	
	

}
