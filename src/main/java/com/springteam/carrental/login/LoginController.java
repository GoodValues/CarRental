package com.springteam.carrental.login;

import com.springteam.carrental.configuration.token.JwtProvider;
import com.springteam.carrental.model.dto.BranchDTO;
import com.springteam.carrental.model.dto.JwtDTO;
import com.springteam.carrental.model.dto.LoginDTO;
import com.springteam.carrental.model.dto.UserDTO;
import com.springteam.carrental.services.BranchService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@SessionAttributes("loggedUser")
public class LoginController {
    private final BranchService branchService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider provider;

    public LoginController(BranchService branchService, AuthenticationManager authenticationManager,
                           JwtProvider provider) {
        this.branchService = branchService;
        this.authenticationManager = authenticationManager;
        this.provider = provider;
    }

    @PostMapping(value = "/login")
    public String postLogin(Model model, @ModelAttribute("user") UserDTO userDTO) {
        List<BranchDTO> branches = branchService.getAllBranches();
        branches.add(new BranchDTO(1L, "Wrocław", null, null));
        branches.add(new BranchDTO(2L, "Warszawa", null, null));
        model.addAttribute("branches", branches);
        model.addAttribute("loggedUser", userDTO);
        return "redirect:user_page";
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<JwtDTO> getTokenForUser(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = provider.generateToken(authentication);
        return ResponseEntity.ok(new JwtDTO(token));
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login";
    }
}
