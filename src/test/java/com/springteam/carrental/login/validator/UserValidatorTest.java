package com.springteam.carrental.login.validator;

import com.springteam.carrental.model.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import static org.assertj.core.api.Assertions.assertThat;

class UserValidatorTest {
    private final UserValidator validator = new UserValidator();

    @Test
    void shouldSkipValidationForInvalidObject() {
        // given
        String[] code = {"Target should be instance of UserDTO.validUser", "Target should be instance of UserDTO"};
        Errors errors = new BeanPropertyBindingResult(new UserDTO(), "validUser");
        // when
        validator.validate("String", errors);
        // then
        assertThat(errors.hasErrors()).isTrue();
        assertThat(errors.getAllErrors())
                .hasSize(1)
                .contains(new ObjectError("validUser", code, null, null));
    }

    @Test
    void shouldReturnNoErrorForCorrectData() {
        // given
        UserDTO dto = new UserDTO(1L, "John", "Rambo", "john@rambo.com", "password", "password");
        Errors errors = new BeanPropertyBindingResult(dto, "validUser");
        // when
        validator.validate(dto, errors);
        // then
        assertThat(errors.hasErrors()).isFalse();
        assertThat(errors.getAllErrors()).isEmpty();
    }

    @Test
    void shouldReturnErrorForIncorrectFirstName() {
        // given
        String[] codes = {"err_code.validUser.firstName", "err_code.firstName", "err_code.java.lang.String", "err_code"};
        UserDTO dto = new UserDTO(1L, "a", "Rambo", "john@rambo.com", "password", "password");
        Errors errors = new BeanPropertyBindingResult(dto, "validUser");
        // when
        validator.validate(dto, errors);
        // then
        assertThat(errors.hasErrors()).isTrue();
        assertThat(errors.getAllErrors())
                .hasSize(1)
                .contains(new FieldError("validUser", "firstName", "a",
                        false, codes, null,
                        "The text should contain a minimum of 3 characters"));
    }

    @Test
    void shouldReturnErrorForIncorrectLastName() {
        // given
        String[] codes = {"err_code.validUser.lastName", "err_code.lastName", "err_code.java.lang.String", "err_code"};
        UserDTO dto = new UserDTO(1L, "John", "r", "john@rambo.com", "password", "password");
        Errors errors = new BeanPropertyBindingResult(dto, "validUser");
        // when
        validator.validate(dto, errors);
        // then
        assertThat(errors.hasErrors()).isTrue();
        assertThat(errors.getAllErrors())
                .hasSize(1)
                .contains(new FieldError("validUser", "lastName", "r",
                        false, codes, null,
                        "The text should contain a minimum of 3 characters"));
    }

    @Test
    void shouldReturnErrorForIncorrectPassword() {
        // given
        String[] codes = {"err_code.validUser.password", "err_code.password", "err_code.java.lang.String", "err_code"};
        UserDTO dto = new UserDTO(1L, "John", "Rambo", "john@rambo.com", "pass", "pass");
        Errors errors = new BeanPropertyBindingResult(dto, "validUser");
        // when
        validator.validate(dto, errors);
        // then
        assertThat(errors.hasErrors()).isTrue();
        assertThat(errors.getAllErrors())
                .hasSize(1)
                .contains(new FieldError("validUser", "password", "pass",
                        false, codes, null,
                        "The text should contain a minimum of 6 characters"));
    }

    @Test
    void shouldReturnErrorForIncorrectEmail() {
        // given
        String[] codes = {"err_code.validUser.email", "err_code.email", "err_code.java.lang.String", "err_code"};
        UserDTO dto = new UserDTO(1L, "John", "Rambo", "john", "password", "password");
        Errors errors = new BeanPropertyBindingResult(dto, "validUser");
        // when
        validator.validate(dto, errors);
        // then
        assertThat(errors.hasErrors()).isTrue();
        assertThat(errors.getAllErrors())
                .hasSize(1)
                .contains(new FieldError("validUser", "email", "john",
                        false, codes, null, "Email format required"));
    }

    @Test
    void shouldReturnErrorForNotMatchingPasswords() {
        // given
        String[] codes = {"err_code.validUser.password", "err_code.password", "err_code.java.lang.String", "err_code"};
        UserDTO dto = new UserDTO(1L, "John", "Rambo", "john@rambo.com", "password", "pass");
        Errors errors = new BeanPropertyBindingResult(dto, "validUser");
        // when
        validator.validate(dto, errors);
        // then
        assertThat(errors.hasErrors()).isTrue();
        assertThat(errors.getAllErrors())
                .hasSize(1)
                .contains(new FieldError("validUser", "password", "password",
                        false, codes, null, "Passwords must be the same"));
    }

    @Test
    void shouldReturnErrorsForIncorrectFirstNameAndEmailAndConfirmPassword() {
        // given
        String[] codes = {"err_code.validUser.password", "err_code.password", "err_code.java.lang.String", "err_code"};
        UserDTO dto = new UserDTO(1L, "a", "Rambo", "john", "password", "pass");
        Errors errors = new BeanPropertyBindingResult(dto, "validUser");
        // when
        validator.validate(dto, errors);
        // then
        assertThat(errors.hasErrors()).isTrue();
        assertThat(errors.getAllErrors())
                .hasSize(3)
                .contains(new FieldError("validUser", "password", "password",
                        false, codes, null, "Passwords must be the same"));
    }
}