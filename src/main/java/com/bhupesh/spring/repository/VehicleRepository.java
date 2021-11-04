package com.bhupesh.spring.repository;

import com.bhupesh.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Vehicle findByName(String name);

    List<Vehicle> findAllByName(String name);
}
