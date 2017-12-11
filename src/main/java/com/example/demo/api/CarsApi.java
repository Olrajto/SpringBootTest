package com.example.demo.api;

import com.example.demo.dto.CarRequestDTO;
import com.example.demo.dto.CarsDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarsApi {

    public void deleteCar(CarRequestDTO carRequestDTO){

    }

    public List<CarsDTO> getCars(CarRequestDTO carRequestDTO){
        return new ArrayList<>();
    }

    public  List<CarsDTO> getAllCars(){
        return new ArrayList<>();
    }
}
