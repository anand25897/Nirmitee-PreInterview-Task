package com.nirmitee.service.impl;

import com.nirmitee.dto.CarDto;
import com.nirmitee.dto.DetailsDto;
import com.nirmitee.dto.LocationDto;
import com.nirmitee.dto.ManufacturerDto;
import com.nirmitee.entity.Car;
import com.nirmitee.entity.Details;
import com.nirmitee.entity.Location;
import com.nirmitee.entity.Manufacturer;
import com.nirmitee.repository.CarRepository;
import com.nirmitee.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = mapToEntity(carDto);
        Car newCar = carRepository.save(car);
        return mapToDto(newCar);
    }

    @Override
    public CarDto getCarById(Long id) {
        Optional<Car> optional = Optional.of(carRepository.findById(id).orElseThrow());
        if(optional.isPresent()){
            Car car = optional.get();
            return mapToDto(car);
        }
        return null;
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> car = carRepository.findAll();
        if(car.size()==0 || car == null)
            return null;
        List<CarDto> carDto = new ArrayList<>();
        for(Car c : car){
            CarDto cd = mapToDto(c);
            carDto.add(cd);
        }
        return carDto;
    }

    @Override
    public CarDto updateCar(Long id, CarDto carDto) {
        Car car = carRepository.findById(id).get();
        if(car == null)
            return null;
        else {
            //return createCar(carDto);
            //car.setId(carDto.getId());
            car.setCondition(carDto.getCondition());

            //Details
            Details details = car.getDetails();
            DetailsDto detailsDto = carDto.getDetailsDto();
            //details.setId(detailsDto.getId());
            details.setBody(detailsDto.getBody());
            details.setModel(detailsDto.getModel());
            details.setNumberOfDoors(detailsDto.getNumberOfDoors());
            details.setFuelType(detailsDto.getFuelType());
            details.setEngine(detailsDto.getEngine());
            details.setModelYear(detailsDto.getModelYear());
            details.setExternalColor(detailsDto.getExternalColor());
            details.setProductionYear(detailsDto.getProductionYear());

            //Manufacturer
            Manufacturer manufacturer = details.getManufacturer();
            ManufacturerDto manufacturerDto = detailsDto.getManufacturerDto();
            //manufacturer.setId(manufacturerDto.getId());
            manufacturer.setName(manufacturerDto.getName());
            manufacturer.setCode(manufacturerDto.getCode());

            //adding manufacturer in details
            details.setManufacturer(manufacturer);

            //adding details
            car.setDetails(details);

            //Location
            Location location = car.getLocation();
            LocationDto locationDto = carDto.getLocationDto();
            //location.setId(locationDto.getId());
            location.setLatitude(locationDto.getLatitude());
            location.setLongitude(locationDto.getLongitude());

            car.setLocation(location);

            carRepository.save(car);
            return carDto;
        }
    }

    @Override
    public int deleteCar(Long id) {
        Car car = carRepository.findById(id).get();
        if(car == null)
            return 0;
        else{
            carRepository.deleteById(id);
            return 1;
        }

    }

    private CarDto mapToDto(Car car){
        CarDto carDto = new CarDto();

        carDto.setId(car.getId());
        carDto.setCondition(car.getCondition());

        DetailsDto detailsDto = new DetailsDto();
        Details details = car.getDetails();
        detailsDto.setId(details.getId());
        detailsDto.setBody(details.getBody());
        detailsDto.setModel(details.getModel());
        detailsDto.setNumberOfDoors(details.getNumberOfDoors());
        detailsDto.setFuelType(details.getFuelType());
        detailsDto.setEngine(details.getEngine());
        detailsDto.setModelYear(details.getModelYear());
        detailsDto.setExternalColor(details.getExternalColor());
        detailsDto.setProductionYear(details.getProductionYear());

        ManufacturerDto manufacturerDto = new ManufacturerDto();
        Manufacturer manufacturer = details.getManufacturer();
        manufacturerDto.setId(manufacturer.getId());
        manufacturerDto.setName(manufacturer.getName());
        manufacturerDto.setCode(manufacturer.getCode());

        detailsDto.setManufacturerDto(manufacturerDto);

        carDto.setDetailsDto(detailsDto);

        LocationDto locationDto = new LocationDto();
        Location location = car.getLocation();
        locationDto.setId(location.getId());
        locationDto.setLatitude(location.getLatitude());
        locationDto.setLongitude(location.getLongitude());

        carDto.setLocationDto(locationDto);

        return carDto;
    }
    private Car mapToEntity(CarDto carDto){
        Car car = new Car();

        //car.setId(carDto.getId());
        car.setCondition(carDto.getCondition());

        //Details
        DetailsDto detailsDto = carDto.getDetailsDto();
        Details details = new Details();
        //details.setId(detailsDto.getId());
        details.setBody(detailsDto.getBody());
        details.setModel(detailsDto.getModel());
        details.setNumberOfDoors(detailsDto.getNumberOfDoors());
        details.setFuelType(detailsDto.getFuelType());
        details.setEngine(detailsDto.getEngine());
        details.setModelYear(detailsDto.getModelYear());
        details.setExternalColor(detailsDto.getExternalColor());
        details.setProductionYear(detailsDto.getProductionYear());

        //Manufacturer
        Manufacturer manufacturer = new Manufacturer();
        ManufacturerDto manufacturerDto = detailsDto.getManufacturerDto();
        //manufacturer.setId(manufacturerDto.getId());
        manufacturer.setName(manufacturerDto.getName());
        manufacturer.setCode(manufacturerDto.getCode());

        //adding manufacturer in details
        details.setManufacturer(manufacturer);

        //adding details
        car.setDetails(details);

        //Location
        Location location = new Location();
        LocationDto locationDto = carDto.getLocationDto();
        //location.setId(locationDto.getId());
        location.setLatitude(locationDto.getLatitude());
        location.setLongitude(locationDto.getLongitude());

        car.setLocation(location);

        return car;
    }
}
