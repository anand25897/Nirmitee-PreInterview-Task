package com.nirmitee.service;

import com.nirmitee.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    CarDto createCar(CarDto carDto);
    CarDto getCarById(Long id);

    List<CarDto> getAllCars();

    CarDto updateCar(Long id, CarDto carDto);

    int deleteCar(Long id);
}
