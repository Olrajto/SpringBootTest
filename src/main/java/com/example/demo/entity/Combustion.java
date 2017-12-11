package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "combustion_items")
@Data
public class Combustion {

    @Id
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private Integer value;

    @Column(name = "fuel_type")
    private String fuel_type;

}
