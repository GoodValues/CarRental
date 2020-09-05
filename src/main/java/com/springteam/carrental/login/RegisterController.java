package com.springteam.carrental.login;

import com.springteam.carrental.login.validator.UserValidator;
import com.springteam.carrental.model.dto.UserDTO;
import com.springteam.carrental.model.entity.Role;
import com.springteam.carrental.model.entity.RoleName;
import com.springteam.carrental.model.entity.User;
import com.springteam.carrental.model.mappers.UserMapper;
import com.springteam.carrental.model.repository.UserRepo;
import com.springteam.carrental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Set;

@RestController
public class RegisterController {

	@Autowired
	UserValidator userValidator;

	@Autowired
	UserService userService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {

		binder.addValidators(userValidator);
	}

//	@PostMapping(value = "/register")
//	public String postRegister(@ModelAttribute("user") @Validated UserDTO userDTO, BindingResult bindingResult) {
//
//		if (bindingResult.hasErrors()) {
//			return "register";
//		}
//		return "index";
//	}

	@PostMapping(value = "/register")
	public String postRegister(@RequestBody @Validated UserDTO userDTO, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "register";
		}
		userService.saveUser(userDTO);
		return "index";
	}

	@GetMapping(value = "/register")
	public String register(Model model) {

		model.addAttribute("user", new UserDTO());
		return "register";
	}
}
