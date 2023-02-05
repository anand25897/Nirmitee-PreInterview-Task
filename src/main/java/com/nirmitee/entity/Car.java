package com.nirmitee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "condition", nullable = false)
    private String condition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id",
    referencedColumnName = "id")
    private Details details;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id",
    referencedColumnName = "id")
    private Location location;
}
