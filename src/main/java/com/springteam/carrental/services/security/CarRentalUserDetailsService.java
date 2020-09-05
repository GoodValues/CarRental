package com.springteam.carrental.services.security;

import com.springteam.carrental.exception.UserNotFoundException;
import com.springteam.carrental.model.entity.User;
import com.springteam.carrental.model.security.CarRentalUserDetails;
import com.springteam.carrental.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CarRentalUserDetailsService implements UserDetailsService {
    private final UserService service;

    public CarRentalUserDetailsService(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = service.getUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + email));
        return new CarRentalUserDetails(user);
    }
}
