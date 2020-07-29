package com.springteam.carrental.login;

import com.springteam.carrental.model.dto.BranchDTO;
import com.springteam.carrental.model.dto.UserDTO;
import com.springteam.carrental.model.entity.User;
import com.springteam.carrental.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("loggedUser")
public class LoginController {

	@Autowired
	BranchService branchService;

	@PostMapping(value = "/login")
	public String postLogin(Model model, @ModelAttribute("user") UserDTO userDTO) {
		List<BranchDTO> branches = branchService.getAllBranches();
		branches.add(new BranchDTO(1L, "Wrocław", null, null));
		branches.add(new BranchDTO(2L, "Warszawa", null, null));
		model.addAttribute("branches", branches);
		model.addAttribute("loggedUser", userDTO);
		return "redirect:user_page";
	}
	
	@GetMapping(value = "/login")
	public String login(Model model) {

		model.addAttribute("user", new UserDTO());
		return "login";
	}
}
