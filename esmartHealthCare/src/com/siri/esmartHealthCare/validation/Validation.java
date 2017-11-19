package com.siri.esmartHealthCare.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.siri.esmartHealthCare.beans.SignupBean;

public class Validation {
	
	


		//which objects can be validated by this validator
		public boolean supports(Class<?> paramClass) {
			return SignupBean.class.equals(paramClass);
		}

		
		public void validate(Object obj, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
			
			SignupBean sign = (SignupBean) obj;
			/*if(sign.getId() <=0){
				errors.rejectValue("id", "negativeValue", new Object[]{"'id'"}, "id can't be negative");
			}
			*/
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
		}
	

}
