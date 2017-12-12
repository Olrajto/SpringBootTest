package com.example.demo.mappers;

import com.example.demo.dto.CombustionDTO;
import com.example.demo.entity.Combustion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CombustionMapper {

    CombustionDTO toCombustionDTO(Combustion combustion);
    List<CombustionDTO> toCombustionDTO(List<Combustion> data);

    @Mappings({
            @Mapping(ignore = true, target = "id")
    })
    Combustion toCombustionEntity(CombustionDTO combustionDTO);
}
