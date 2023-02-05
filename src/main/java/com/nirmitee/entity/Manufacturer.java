package com.nirmitee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "manufacture")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", nullable = false)
    private Integer code;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "manufacturer")
    private Details details;

    public Manufacturer(Long id, Integer code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
