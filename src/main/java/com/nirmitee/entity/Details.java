package com.nirmitee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "details")
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body", nullable = false)
    private String body;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "numberOfDoors", nullable = false)
    private Integer numberOfDoors;
    @Column(name = "fuelType", nullable = false)
    private String fuelType;
    @Column(name = "engine", nullable = false)
    private String engine;
    @Column(name = "modelYear", nullable = false)
    private Integer modelYear;
    @Column(name = "productionYear", nullable = false)
    private Integer productionYear;
    @Column(name = "externalColor", nullable = false)
    private String externalColor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="manufacturer_id",
      referencedColumnName = "id")
    private Manufacturer manufacturer;
}
