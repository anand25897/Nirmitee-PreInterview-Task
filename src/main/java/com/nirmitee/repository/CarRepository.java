package com.nirmitee.repository;

import com.nirmitee.dto.CarDto;
import com.nirmitee.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

}
