package com.springteam.carrental.login;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.springteam.carrental.model.dto.RentalOfficeDTO;
import com.springteam.carrental.model.entity.RentalOffice;
import com.springteam.carrental.model.security.CarRentalUserDetails;
import com.springteam.carrental.services.BranchService;
import com.springteam.carrental.services.RentalOfficeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class HomeController {

	private BranchService branchService;
	private RentalOfficeService rentalOfficeService;

	@GetMapping("/")
	@PreAuthorize("hasRole('USER')")
	public String index(Model model) {
		CarRentalUserDetails user = (CarRentalUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("Logged user: {}", user.getUsername());
		return "Hello " + user.getUsername();
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String admin(Model model) {
		CarRentalUserDetails user = (CarRentalUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("Logged user: {}", user.getUsername());
		return "Hello admin: " + user.getUsername();
	}
}
