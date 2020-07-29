package com.springteam.carrental.login.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.springteam.carrental.model.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserDTO userDTO = (UserDTO) target;
		
		validate(ValidatorEnum.USERNAME, userDTO.getFirstName(), "firstName", errors);
		validate(ValidatorEnum.USERNAME, userDTO.getLastName(), "lastName", errors);
		validate(ValidatorEnum.PASSWORD, userDTO.getPassword(), "password", errors);
		validate(ValidatorEnum.EMAIL, userDTO.getEmail(), "email", errors);
		
		String password = userDTO.getPassword();
		String confirmPassword = userDTO.getConfirmPassword();
		if(!password.equals(confirmPassword)) {
			
			errors.rejectValue("password", "err_code", "Passwords must be the same");
		}
	}

	private void validate(ValidatorEnum validator, String value, String fieldName, Errors errors) {

		String patternReg = validator.getPattern();
		Pattern pattern = Pattern.compile(patternReg);
		Matcher matcher = pattern.matcher(value);
		if (!matcher.matches()) {

			errors.rejectValue(fieldName, validator.getErrCode(), validator.getErrMessage());
		}
	}

}
