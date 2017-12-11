package com.example.demo.api;

import com.example.demo.EntityNotFoundException;
import com.example.demo.dto.CombustionRequestDTO;
import com.example.demo.dto.CombustionDTO;
import com.example.demo.entity.Combustion;
import com.example.demo.mappers.CombustionMapper;
import com.example.demo.repositories.CombustionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CombustionApi {

    private final CombustionRepository combustionRepository;
    private final CombustionMapper combustionMapper;

    @Autowired
    public CombustionApi(CombustionRepository combustionRepository, CombustionMapper combustionMapper ){
        this.combustionRepository = combustionRepository;
        this.combustionMapper = combustionMapper;
    }

    public void deleteCombustion(CombustionRequestDTO combustionRequestDTO){
        throw new EntityNotFoundException();
    }

    public CombustionDTO getCombustion(CombustionRequestDTO combustionRequestDTO) {
        Combustion combustion = combustionRepository.findOne(combustionRequestDTO.getId());
        if (combustion == null) throw new EntityNotFoundException();
        return combustionMapper.toCombustionDTO(combustion);
    }

    public List<CombustionDTO> getAllCombustionData(){
        return combustionMapper.toCombustionDTO(combustionRepository.findAll());
    }
}
