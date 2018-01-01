package com.example.demo.api;

import com.example.demo.dto.CombustionDTO;
import com.example.demo.dto.CombustionRequestDTO;
import com.example.demo.entity.QCombustion;
import com.example.demo.enums.FuelType;
import com.example.demo.mappers.CombustionMapper;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CombustionFinder {

    private final EntityManager entityManager;
    private final CombustionMapper combustionMapper;

    public List<CombustionDTO> findCombustion(CombustionRequestDTO combustionRequestDTO){

        QCombustion combustion = QCombustion.combustion;
        JPAQuery query = new JPAQuery(entityManager).from(combustion);

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if(combustionRequestDTO.getFuelType() != null){
            booleanBuilder.and(combustion.fuelType.eq(FuelType.valueOf(combustionRequestDTO.getFuelType())));
        }
        if(combustionRequestDTO.getValue() != null){
            booleanBuilder.and(combustion.value.eq(combustionRequestDTO.getValue()));
        }
        if(combustionRequestDTO.getStartDate() != null && combustionRequestDTO.getEndDate() != null){
            booleanBuilder.and(combustion.date.between(combustionRequestDTO.getStartDate(), combustionRequestDTO.getEndDate()));
        }
        query.where(booleanBuilder);

        return combustionMapper.toCombustionDTO(query.list(combustion));
    }

}
