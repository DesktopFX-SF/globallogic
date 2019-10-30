package com.spring.globallogic.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "person")
public class Person {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EMP_ID")
	private Integer id;		
	private String name;
	private String email;		
	private String password;	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="OWNER_ID", referencedColumnName="EMP_ID")
	private List<Phone> phones;
	
	
	private Date	created;
	
	private Date	modified;
	
	private Date	last_login;
	
	private UUID	token;
	
	private Boolean	isactive;
	
	
	public Person() {}
	
	public Person (int id, String name, String email, String password, List<Phone> phones, Date created, Date modified, Date last_login, UUID token, Boolean isactive) {
		this.id			= id;
		this.name		= name;
		this.email		= email;
		this.password	= password;
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id		= id;
	} 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name	= name;
	} 
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email	= email;
	} 
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
	public List<Phone> getPhone() {
		return phones;
	}
	public void setPhone(List<Phone> phones) {
		this.phones	= phones;
	} 

	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	} 
	
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	
	public UUID getToken() {
		return token;
	}
	public void setToken(UUID token) {
		this.token = token;
	}
	
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
		
	
	
}