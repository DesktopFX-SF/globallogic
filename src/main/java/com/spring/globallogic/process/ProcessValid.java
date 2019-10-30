package com.spring.globallogic.process;



import org.springframework.http.HttpStatus;

import com.spring.globallogic.model.Person;
import com.spring.globallogic.result.Result;

public class ProcessValid  {
	
	private Utilities utilities = new Utilities();
	
	
	
	public  Result validateObject (Person p) {
		Result rs = new Result();
		try {
					
			rs.setStatus(false);
			
			if (p.getEmail() == null) {
				rs.setMessage("email no puede ser null.");
				return rs;
			}
			
			if (!utilities.validateEmail(p.getEmail())) {
				rs.setMessage("Campo email no es correcto.");
				return rs;
			}
			
			if (!utilities.validatePassword(p.getPassword())) {
				rs.setMessage("La contraseña debe tener al menos 1 mayuscula, 1 minuscula, 1 digito, de (8-16) de largo.");
				return rs;
			}
			
			if (p.getName() == null || p.getName().length() == 0) {
				rs.setMessage("Debe ingresar un nombre.");
				return rs;
			}					
			
			
			rs.setStatus(true);
			rs.setMessage("OK");
			
		} catch (Exception e) {
			rs.setMessage(e.getMessage());
			rs.setStatus(false);
			rs.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return rs;
		
	}
}
