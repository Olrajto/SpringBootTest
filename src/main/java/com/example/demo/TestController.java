package com.example.demo;

import com.example.demo.api.CarsApi;
import com.example.demo.dto.CarRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TestController {

    private final CarsApi carsApi;

    @Autowired
    public TestController(CarsApi carsApi){
        this.carsApi = carsApi;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCars(){
        return ResponseEntity.ok().body(carsApi.getAllCars());
    }

    @RequestMapping(value = "/cars", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCar(@RequestBody CarRequestDTO carRequestDTO){
        carsApi.deleteCar(carRequestDTO);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCars(@RequestBody CarRequestDTO carRequestDTO){
        carsApi.getCars(carRequestDTO);
        return ResponseEntity.ok().build();
    }
}
