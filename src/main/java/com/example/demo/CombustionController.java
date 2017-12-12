package com.example.demo;

import com.example.demo.api.CombustionApi;
import com.example.demo.dto.CombustionDTO;
import com.example.demo.dto.CombustionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CombustionController {

    private final CombustionApi combustionApi;

    @RequestMapping(value = "/combustion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCombustionData(){
        return ResponseEntity.ok().body(combustionApi.getAllCombustionData());
    }

    @RequestMapping(value = "/combustion", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCombustion(@RequestBody CombustionRequestDTO combustionRequestDTO){
        combustionApi.deleteCombustion(combustionRequestDTO);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/combustion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCombustion(@RequestBody CombustionRequestDTO combustionRequestDTO){
        return ResponseEntity.ok(combustionApi.getCombustion(combustionRequestDTO));
    }

    @RequestMapping(value = "/combustion/add", method = RequestMethod.POST)
    public ResponseEntity addCombustion(@RequestBody CombustionDTO combustionDTO){
        combustionApi.addCombustion(combustionDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
