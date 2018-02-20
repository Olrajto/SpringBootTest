package com.example.demo;

import com.example.demo.api.CombustionService;
import com.example.demo.dto.CombustionDTO;
import com.example.demo.enums.FuelType;
import com.example.demo.exceptions.WeatherRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CombustionController {

    private final CombustionService combustionService;


    @RequestMapping(value = "/combustion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCombustion(@RequestParam(name = "combustionValue", required = false) Integer combustionValue,
                                        @RequestParam(name = "distance", required = false) Integer distance,
                                        @RequestParam(required = false) FuelType fuelType,
                                        @RequestParam(required = false) Date startDate,
                                        @RequestParam(required = false) Date endDate){

        return ResponseEntity.ok().body(combustionService.getCombustion(combustionValue, distance, fuelType, startDate, endDate));
    }

    @RequestMapping(value = "/combustion/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCombustion(@PathVariable(name = "id") long id){
        combustionService.deleteCombustion(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/combustion/add", method = RequestMethod.POST)
    public ResponseEntity addCombustion(@RequestBody CombustionDTO combustionDTO){
        combustionService.addCombustion(combustionDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @RequestMapping(value = "/weather/{cityId}", method = RequestMethod.GET)
    public ResponseEntity getWeather(@PathVariable(name = "cityId") String cityId) throws WeatherRequestException {
        return ResponseEntity.ok(combustionService.getWeather(cityId));
    }

    @RequestMapping(value = "/TEST", method = RequestMethod.POST)
    public ResponseEntity test(){

        int l = 155;
        System.out.println("Long: " + l);
        System.out.println("Long binarnie: " + Integer.toBinaryString(l));
        System.out.println("Przesuniecie: ");
        System.out.println(Integer.toBinaryString(l >>> 2));
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
