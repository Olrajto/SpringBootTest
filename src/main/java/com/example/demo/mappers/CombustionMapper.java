package com.example.demo.mappers;

import com.example.demo.dto.CombustionDTO;
import com.example.demo.entity.Combustion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CombustionMapper {

    CombustionDTO toCombustionDTO(Combustion combustion);
    List<CombustionDTO> toCombustionDTO(List<Combustion> data);
}
