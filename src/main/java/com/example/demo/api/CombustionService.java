package com.example.demo.api;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.WeatherRequestException;
import com.example.demo.dto.CombustionDTO;
import com.example.demo.dto.WeatherDTO;
import com.example.demo.enums.FuelType;
import com.example.demo.gateway.WeatherGateway;
import com.example.demo.mappers.CombustionMapper;
import com.example.demo.repositories.CombustionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import javax.persistence.PersistenceException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CombustionService {

    private final CombustionRepository combustionRepository;
    private final CombustionMapper combustionMapper;
    private final CombustionFinder combustionFinder;
    private final WeatherGateway weatherGateway;

    public void deleteCombustion(long id){
       combustionRepository.delete(combustionRepository.findOneById(id)
               .orElseThrow(EntityNotFoundException::new));
    }

    public List<CombustionDTO> getCombustion(Integer combustionValue, Integer distance, FuelType fuelType,
                                             Date startDate, Date endDate) {
        return combustionFinder.findCombustion(combustionValue, distance, fuelType, startDate, endDate);
    }

    public void addCombustion(CombustionDTO combustionDTO) {
        combustionRepository.save(combustionMapper.toCombustionEntity(combustionDTO));
    }

    public WeatherDTO getWeather(String cityId) throws WeatherRequestException {
        try {
            return weatherGateway.getCurrentWeather(cityId);
        } catch (URISyntaxException  | RestClientException e) {
            throw new WeatherRequestException(e);
        }
    }
}
