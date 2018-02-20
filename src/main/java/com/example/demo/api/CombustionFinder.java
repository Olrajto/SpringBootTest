package com.example.demo.api;

import com.example.demo.dto.CombustionDTO;
import com.example.demo.entity.QCombustion;
import com.example.demo.enums.FuelType;
import com.example.demo.mappers.CombustionMapper;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CombustionFinder {

    private final EntityManager entityManager;
    private final CombustionMapper combustionMapper;

    public List<CombustionDTO> findCombustion(Integer combustionValue, Integer distance, FuelType fuelType, Date startDate, Date endDate){

        QCombustion combustion = QCombustion.combustion;
        JPAQuery query = new JPAQuery(entityManager).from(combustion);

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if(fuelType != null){
            booleanBuilder.and(combustion.fuelType.eq(fuelType));
        }
        if(combustionValue != null){
            booleanBuilder.and(combustion.value.eq(combustionValue));
        }
        if(startDate != null && endDate != null){
            booleanBuilder.and(combustion.date.between(startDate, endDate));
        }
        if(distance != null){
            booleanBuilder.and(combustion.distance.eq(distance));
        }
        query.where(booleanBuilder);

        return combustionMapper.toCombustionDTO(query.list(combustion));
    }

}
