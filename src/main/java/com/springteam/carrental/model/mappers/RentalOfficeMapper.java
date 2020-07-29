package com.springteam.carrental.model.mappers;

import com.springteam.carrental.model.dto.BranchDTO;
import com.springteam.carrental.model.dto.RentalOfficeDTO;
import com.springteam.carrental.model.entity.Branch;
import com.springteam.carrental.model.entity.RentalOffice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentalOfficeMapper {

    static RentalOfficeMapper INSTANCE = Mappers.getMapper(RentalOfficeMapper.class);

    RentalOfficeDTO officeToDto(RentalOffice rentalOffice);
    RentalOffice dtoToOffice(RentalOfficeDTO rentalOfficeDTO);
}
