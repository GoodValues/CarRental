package com.springteam.carrental.services;

import com.springteam.carrental.model.dto.CarDTO;
import com.springteam.carrental.model.dto.ReservationDTO;
import com.springteam.carrental.model.dto.UserDTO;
import com.springteam.carrental.model.entity.Reservation;
import com.springteam.carrental.model.entity.User;
import com.springteam.carrental.model.mappers.ReservationMapper;
import com.springteam.carrental.model.mappers.UserMapper;
import com.springteam.carrental.model.repository.ReservationRepo;
import com.springteam.carrental.model.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (User user : users)
            result.add(UserMapper.INSTANCE.userToDto(user));
        return result;
    }

    public User getUserByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return user;
    }

    public void saveUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.dtoToUser(userDTO);
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
