package com.example.demo;

import com.example.demo.api.CombustionApi;
import com.example.demo.dto.CombustionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class CombustionController {

    private final CombustionApi combustionApi;

    @Autowired
    public CombustionController(CombustionApi combustionApi){
        this.combustionApi = combustionApi;
    }

    @RequestMapping(value = "/oombustion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCars(){
        return ResponseEntity.ok().body(combustionApi.getAllCombustionData());
    }

    @RequestMapping(value = "/combustion", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCar(@RequestBody CombustionRequestDTO combustionRequestDTO){
        combustionApi.deleteCombustion(combustionRequestDTO);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/combustion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCars(@RequestBody CombustionRequestDTO combustionRequestDTO){
        combustionApi.getCombustion(combustionRequestDTO);
        return ResponseEntity.ok().build();
    }
}
