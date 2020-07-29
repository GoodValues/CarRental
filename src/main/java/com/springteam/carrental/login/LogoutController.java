package com.springteam.carrental.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	@GetMapping(value = "/logout")
	public String userPage(Model model, HttpSession session) {

		session.invalidate();
		return "redirect:/";
	}
}
