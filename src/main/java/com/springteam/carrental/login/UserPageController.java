package com.springteam.carrental.login;

import com.springteam.carrental.model.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserPageController {

	@GetMapping(value = "/user_page")
	public String userPage(Model model, @SessionAttribute("loggedUser") UserDTO userDTO) {

		model.addAttribute("usr", userDTO);
		return "user_page";
	}
	
	@ExceptionHandler(ServletRequestBindingException.class)
	public String handle() {
		
		return "redirect:/login";
	}
}
