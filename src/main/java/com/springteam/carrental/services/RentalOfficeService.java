package com.springteam.carrental.services;

import com.springteam.carrental.model.dto.BranchDTO;
import com.springteam.carrental.model.dto.RentalOfficeDTO;
import com.springteam.carrental.model.entity.Branch;
import com.springteam.carrental.model.entity.RentalOffice;
import com.springteam.carrental.model.mappers.BranchMapper;
import com.springteam.carrental.model.mappers.RentalOfficeMapper;
import com.springteam.carrental.model.repository.RentalOfficeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentalOfficeService {

    RentalOfficeRepo rentalOfficeRepo;

    @Autowired
    public RentalOfficeService(RentalOfficeRepo rentalOfficeRepo) {
        this.rentalOfficeRepo = rentalOfficeRepo;
//        rentalOfficeRepo.save(new RentalOffice("Rentcar","www.rentcar.com", "Wrocław", "Spring-Team", "logotype"));
    }

    public List<RentalOfficeDTO> getAllOffices() {
        List<RentalOffice> offices = rentalOfficeRepo.findAll();
        List<RentalOfficeDTO> result = new ArrayList<>();
        for (RentalOffice rentalOffice : offices)
            result.add(RentalOfficeMapper.INSTANCE.officeToDto(rentalOffice));
        return result;
    }

    public List<BranchDTO> getAllBranchesForOfficeWithId(Long id) {
        List<Branch> branches = rentalOfficeRepo.getOne(id).getBranches();
        List<BranchDTO> result = new ArrayList<>();
        for (Branch branch : branches)
            result.add(BranchMapper.INSTANCE.branchToDto(branch));
        return result;
    }

    public void saveRentalOffice(RentalOfficeDTO rentalOfficeDTO) {
        RentalOffice rentalOffice = RentalOfficeMapper.INSTANCE.dtoToOffice(rentalOfficeDTO);
        rentalOfficeRepo.save(rentalOffice);
    }

    public RentalOfficeDTO getOfficeById(Long id) {
        Optional<RentalOffice> office = rentalOfficeRepo.findById(id);
        return office.map(RentalOfficeMapper.INSTANCE::officeToDto).orElse(null);
    }

    public void deleteOfficeById(Long id) {
        rentalOfficeRepo.deleteById(id);
    }
}
