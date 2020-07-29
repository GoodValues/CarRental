package com.springteam.carrental.login;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.springteam.carrental.model.dto.RentalOfficeDTO;
import com.springteam.carrental.model.entity.RentalOffice;
import com.springteam.carrental.services.BranchService;
import com.springteam.carrental.services.RentalOfficeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	private BranchService branchService;
	private RentalOfficeService rentalOfficeService;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("dateTime", LocalDateTime.now());
		List<RentalOfficeDTO> offices = rentalOfficeService.getAllOffices();
		model.addAttribute("offices", offices); // dlaczego z tą linijką nie wchodzi mi pod endpoint?
		return "index";
	}
}
