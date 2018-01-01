package com.example.demo.entity;

import com.example.demo.enums.FuelType;
import lombok.Data;
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
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(name = "distance")
    private Integer distance;

}
