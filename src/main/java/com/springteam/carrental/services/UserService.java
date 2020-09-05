package com.springteam.carrental.services;

import com.springteam.carrental.model.dto.UserDTO;
import com.springteam.carrental.model.entity.Role;
import com.springteam.carrental.model.entity.RoleName;
import com.springteam.carrental.model.entity.User;
import com.springteam.carrental.model.mappers.UserMapper;
import com.springteam.carrental.model.repository.RoleRepo;
import com.springteam.carrental.model.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }


    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (User user : users)
            result.add(UserMapper.INSTANCE.userToDto(user));
        return result;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public void saveUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.dtoToUser(userDTO);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRoles(Set.of(roleRepo.findByName(RoleName.ROLE_USER).get()));
        userRepo.save(user);
    }

    public UserDTO getReservationById(Long id) {
        Optional<User> reservation = userRepo.findById(id);
        return reservation.map(UserMapper.INSTANCE::userToDto).orElse(null);
    }

    public void deleteCarById(Long id) {
        userRepo.deleteById(id);
    }
}
