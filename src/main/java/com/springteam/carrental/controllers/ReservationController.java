package com.springteam.carrental.controllers;

import com.springteam.carrental.model.dto.CarDTO;
import com.springteam.carrental.model.dto.RentalOfficeDTO;
import com.springteam.carrental.model.dto.ReservationDTO;
import com.springteam.carrental.model.dto.UserDTO;
import com.springteam.carrental.model.entity.Reservation;
import com.springteam.carrental.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@SessionAttributes({"loggedUser", "reservation"})
public class ReservationController {

    ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public String getAllReservations(Model model) {
        List<ReservationDTO> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservations";
    }

    @GetMapping("/reservationsForUser")
    public String getAllReservationsForUser(Model model, @SessionAttribute("loggedUser") UserDTO userDTO) {
        List<ReservationDTO> reservations = reservationService.getReservationsForUserByEmail(userDTO.getEmail());
        model.addAttribute("reservations", reservations);
        return "reservations";
    }

    @GetMapping("/addReservationData")
    public String addReservationData(Model model, @SessionAttribute("office") RentalOfficeDTO rentalOfficeDTO) {
        model.addAttribute("branches", rentalOfficeDTO.getBranches());
        return "addReservationData";
    }

    @PostMapping("/addReservationData")
    public String addReservationData(Model model, @SessionAttribute("reservation") ReservationDTO reservationDTO) {
        model.addAttribute(reservationDTO);
        return "addReservation";
    }

    @PostMapping("/addReservation")
    public String addReservation(@SessionAttribute("reservation") ReservationDTO reservationDTO, @SessionAttribute("loggedUser") UserDTO userDTO) {
        reservationDTO.setRentalDate(LocalDateTime.now());
        reservationDTO.setClient(userDTO);
        LocalDateTime rentalDay = reservationDTO.getDateFrom().toLocalDate().atStartOfDay();
        LocalDateTime returnDay = reservationDTO.getDateTo().toLocalDate().atStartOfDay();
        reservationDTO.setTotalPrice(
                reservationDTO.getCar().getPriceForDay().multiply(BigDecimal.valueOf(ChronoUnit.DAYS.between(rentalDay, returnDay))));
        reservationService.saveReservation(reservationDTO);
        return "redirect:/reservations";
    }

    @GetMapping("/editReservation")
    public String editCar(Model model, @RequestParam Long id) {
        ReservationDTO reservationDTO = reservationService.getReservationById(id);
        model.addAttribute("reservation", reservationDTO);
        return "editReservation";
    }

    @PutMapping("/editReservation")
    public String saveEditedReservation(ReservationDTO reservationDTO) {
        reservationService.saveReservation(reservationDTO);
        return "redirect:/reservations";
    }

    @GetMapping("/deleteReservation")
    public String deleteReservation(@RequestParam Long id) {
        reservationService.deleteReservationById(id);
        return "redirect:/reservations";
    }
}
