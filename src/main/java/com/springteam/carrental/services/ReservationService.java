package com.springteam.carrental.services;

import com.springteam.carrental.model.dto.CarDTO;
import com.springteam.carrental.model.dto.ReservationDTO;
import com.springteam.carrental.model.entity.Car;
import com.springteam.carrental.model.entity.Reservation;
import com.springteam.carrental.model.mappers.CarMapper;
import com.springteam.carrental.model.mappers.ReservationMapper;
import com.springteam.carrental.model.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    ReservationRepo reservationRepo;
    UserService userService;

    @Autowired
    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepo.findAll();
        List<ReservationDTO> result = new ArrayList<>();
        for (Reservation reservation : reservations)
            result.add(ReservationMapper.INSTANCE.reservationToDto(reservation));
        return result;
    }

    public List<ReservationDTO> getReservationsForUserByEmail(String email) {
        List<Reservation> reservations = userService.getUserByEmail(email).getReservations();
        List<ReservationDTO> reservationDTO = ReservationMapper.INSTANCE.reservationsToDto(reservations);
        return reservationDTO;
    }

    public void saveReservation(ReservationDTO reservationDTO) {
        Reservation reservation = ReservationMapper.INSTANCE.dtoToReservation(reservationDTO);
        reservationRepo.save(reservation);
    }

    public ReservationDTO getReservationById(Long id) {
        Optional<Reservation> reservation = reservationRepo.findById(id);
        return reservation.map(ReservationMapper.INSTANCE::reservationToDto).orElse(null);
    }

    public void deleteReservationById(Long id) {
        reservationRepo.deleteById(id);
    }
}
