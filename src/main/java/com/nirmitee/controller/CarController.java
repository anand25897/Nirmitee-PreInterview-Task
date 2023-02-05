package com.nirmitee.controller;

import com.nirmitee.dto.CarDto;
import com.nirmitee.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarServiceImpl carServiceImpl;

//    @GetMapping
//    public String home(){
//        return "Abhishe";
//    }
    @PostMapping
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto){
        //System.out.println("carDto "+carDto.toString());
        CarDto newCarDto = carServiceImpl.createCar(carDto);
        if(newCarDto != null)
            return new ResponseEntity<>(newCarDto, HttpStatus.CREATED);
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getByCarId(@PathVariable Long id){
        CarDto carDto = carServiceImpl.getCarById(id);
        if(carDto == null)
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(carDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> findAllCar(){
        List<CarDto> carDto = carServiceImpl.getAllCars();
        if(carDto == null)
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(carDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @RequestBody CarDto carDto){
        CarDto carDto1 = carServiceImpl.updateCar(id, carDto);
        if(carDto1 == null)
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        else{
            return new ResponseEntity<>(carDto, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id){
        int response = carServiceImpl.deleteCar(id);
        if(response == 0)
            return new ResponseEntity<>("Id not available in database", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(id+"Deleted Successfully", HttpStatus.OK);
    }
}
