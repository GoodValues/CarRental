package com.springteam.carrental.services;

import com.springteam.carrental.model.dto.BranchDTO;
import com.springteam.carrental.model.entity.Branch;
import com.springteam.carrental.model.mappers.BranchMapper;
import com.springteam.carrental.model.repository.BranchRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BranchServiceTest {
    private final BranchRepo branchRepo = mock(BranchRepo.class);
    private final BranchService service = new BranchService(branchRepo);

    @Test
    void shouldReturnAllBranches() {
        // given
        Branch branch1 = new Branch(1L, "address",
                new ArrayList<>(), new ArrayList<>());
        Branch branch2 = new Branch(2L, "different address",
                new ArrayList<>(), new ArrayList<>());
        List<Branch> branches = List.of(branch1, branch2);
        when(branchRepo.findAll()).thenReturn(branches);
        // when
        List<BranchDTO> result = service.getAllBranches();
        // then
        assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .contains(BranchMapper.INSTANCE.branchToDto(branch1))
                .contains(BranchMapper.INSTANCE.branchToDto(branch2));
    }

    @Test
    void shouldReturnEmptyListForNotExistingBranches() {
        // given
        List<Branch> branches = new ArrayList<>();
        when(branchRepo.findAll()).thenReturn(branches);
        // when
        List<BranchDTO> result = service.getAllBranches();
        // then
        assertThat(result).isEmpty();
    }

    @Test
    void shouldReturnSavedBranchAsDto() {
        // given
        BranchDTO dto = new BranchDTO();
        dto.setAddress("address");
        Branch branch = new Branch();
        branch.setAddress("address");
        branch.setId(1L);
        Branch branch2 = new Branch();
        branch2.setAddress("address");
        when(branchRepo.save(branch2)).thenReturn(branch);
        // when
        BranchDTO result = service.saveBranch(dto);
        // then
        assertThat(result)
                .isNotNull()
                .hasFieldOrPropertyWithValue("address", "address")
                .hasFieldOrPropertyWithValue("id", 1L);
    }

    @Test
    void shouldReturnNullForNotWorkingDB() {
        // given
        BranchDTO dto = new BranchDTO();
        dto.setAddress("address");
        when(branchRepo.save(any())).thenReturn(null);
        // when
        BranchDTO result = service.saveBranch(dto);
        // then
        assertThat(result).isNull();
    }

    @Test
    void shouldReturnBranchForExistingId() {
        // arrange
        Branch branch = new Branch();
        branch.setId(1L);
        branch.setAddress("address");
        when(branchRepo.findById(1L)).thenReturn(Optional.of(branch));
        // act
        BranchDTO result = service.getBranchById(1L);
        // assert
        assertThat(result)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("address", "address");
    }

    @Test
    void shouldReturnBranchForNotExistingId() {
        // given
        when(branchRepo.findById(1L)).thenReturn(Optional.empty());
        // when/then
        assertThat(service.getBranchById(1L)).isNull();
    }
}