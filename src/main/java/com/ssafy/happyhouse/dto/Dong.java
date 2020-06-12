package com.ssafy.happyhouse.dto;

import java.util.Date;


public class Dong {
	private String city; 
	private String code; 
	private String dongcode; 
	private String gugun; 
	private String dong;
	
	public Dong() {
		super();
	}
	public Dong(String city, String code, String dongcode, String gugun, String dong) {
		super();
		this.city = city;
		this.code = code;
		this.dongcode = dongcode;
		this.gugun = gugun;
		this.dong = dong;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	@Override
	public String toString() {
		return "Dong [city=" + city + ", code=" + code + ", dongcode=" + dongcode + ", gugun=" + gugun + ", dong="
				+ dong + "]";
	} 
	
	

	
}
