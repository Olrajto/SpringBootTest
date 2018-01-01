package com.example.demo.api;

import com.example.demo.EntityNotFoundException;
import com.example.demo.dto.CombustionRequestDTO;
import com.example.demo.dto.CombustionDTO;
import com.example.demo.entity.Combustion;
import com.example.demo.mappers.CombustionMapper;
import com.example.demo.repositories.CombustionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CombustionApi {

    private final CombustionRepository combustionRepository;
    private final CombustionMapper combustionMapper;
    private final CombustionFinder combustionFinder;

    public void deleteCombustion(CombustionRequestDTO combustionRequestDTO){
       combustionRepository.delete(combustionRepository.findOneById(combustionRequestDTO.getId())
               .orElseThrow(EntityNotFoundException::new));
    }

    public List<CombustionDTO> getCombustion(CombustionRequestDTO combustionRequestDTO) {
        return combustionFinder.findCombustion(combustionRequestDTO);
    }

    public List<CombustionDTO> getAllCombustionData(){
        return combustionMapper.toCombustionDTO(combustionRepository.findAll());
    }

    public void addCombustion(CombustionDTO combustionDTO) {
        Combustion combustion = combustionMapper.toCombustionEntity(combustionDTO);
        combustionRepository.save(combustion);
    }
}
