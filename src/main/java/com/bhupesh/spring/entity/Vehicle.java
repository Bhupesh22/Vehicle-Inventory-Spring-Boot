package com.bhupesh.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VEHICLE_TBL")
public class Vehicle {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int year;
    private double selling_price;
    private double km_driven;
    private String fuel;
    private String seller_type;
    private String transmission;
    private String owner;
    private String mileage;
    private String engine;
    private String max_power;
    private String torque;
    private String seats;
}