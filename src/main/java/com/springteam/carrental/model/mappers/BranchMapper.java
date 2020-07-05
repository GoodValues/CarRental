package com.springteam.carrental.model.mappers;

import com.springteam.carrental.model.dto.BranchDTO;
import com.springteam.carrental.model.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BranchMapper {

    static BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);

    BranchDTO branchToDto(Branch branch);
    Branch dtoToBranch(BranchDTO branchDTO);
}
