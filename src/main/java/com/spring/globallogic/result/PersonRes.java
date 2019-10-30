package com.spring.globallogic.result;


import java.util.Date;
import java.util.UUID;

public class PersonRes {
	
	

	
	
	private Integer 	id;
	private Date 		created;
	private Date 		modified;
	private Date 		last_login	;
	private UUID 		token;
	private Boolean		isactive;
	
	public PersonRes() {}
	
	public PersonRes(Integer id, Date created, Date modified, Date last_login, UUID token, Boolean isactive) {
		this.id			= id;
		this.created    = created;	
		this.modified	= modified;
		this.last_login = last_login;
		this.token	    = token;
		this.isactive   = isactive;
		
	}
	

	
	public Integer getId() {		
		return id;
	}

	public void setId(Integer id) {		
		this.id = id;
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

	public void setIsactive(Boolean isactive) {		
		this.isactive = isactive;
	}
	
}
