package com.springteam.carrental.model.mappers;

import com.springteam.carrental.model.dto.BranchDTO;
import com.springteam.carrental.model.dto.ReservationDTO;
import com.springteam.carrental.model.entity.Branch;
import com.springteam.carrental.model.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservationMapper {

    static ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    ReservationDTO reservationToDto(Reservation reservation);
    Reservation dtoToReservation(ReservationDTO reservationDTO);
    List<ReservationDTO> reservationsToDto(List<Reservation> reservations);
    List<Reservation> dtoToReservations(List<ReservationDTO> reservationsDTO);
}
