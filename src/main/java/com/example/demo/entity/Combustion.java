package com.example.demo.entity;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "combustion_items")
@Data
public class Combustion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private Integer value;

    @Column(name = "fuel_type")
    private String fuelType;

}
