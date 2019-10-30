package com.spring.globallogic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "phone")
public class Phone {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@JsonIgnore
	private Integer		id;	
	private String		number;
	private String		cityCode;
	private String		countryCode;

	@Column(name="OWNER_ID")
	private Integer ownerId;
	
	public Phone() {}
	
	public Phone (Integer id, String number, String countryCode, String cityCode) {
		this.id					= id;
		this.number				= number;
		this.cityCode			= cityCode;
		this.countryCode		= countryCode;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id		= id;
	} 
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number		= number;
	} 
	
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode		= cityCode;
	} 
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode		= countryCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
