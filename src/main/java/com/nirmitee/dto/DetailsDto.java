package com.nirmitee.dto;

import com.nirmitee.entity.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailsDto {

    private Long id;
    private String body;
    private String model;
    private Integer numberOfDoors;
    private String fuelType;
    private String engine;
    private Integer modelYear;
    private Integer productionYear;
    private String externalColor;

    private ManufacturerDto manufacturerDto;
}
