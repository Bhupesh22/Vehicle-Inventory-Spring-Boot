package com.bhupesh.spring.service;

import com.bhupesh.spring.entity.Vehicle;
import com.bhupesh.spring.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> saveVehicles(List<Vehicle> vehicles) {
        return vehicleRepository.saveAll(vehicles);
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(int id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public List<Vehicle> getVehicleByName(String name) {
        return vehicleRepository.findAllByName(name);
    }

    public String deleteVehicle(int id) {
        try {
            vehicleRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Vehicle Deleted Successfully [Info] ID = " + id;
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicle.getId()).orElse(null);
        existingVehicle.setName(vehicle.getName());
        existingVehicle.setYear(vehicle.getYear());
        existingVehicle.setSelling_price(vehicle.getSelling_price());
        existingVehicle.setKm_driven(vehicle.getKm_driven());
        existingVehicle.setFuel(vehicle.getFuel());
        existingVehicle.setSeller_type(vehicle.getSeller_type());
        existingVehicle.setTransmission(vehicle.getTransmission());
        existingVehicle.setOwner(vehicle.getOwner());
        existingVehicle.setMileage(vehicle.getMileage());
        existingVehicle.setEngine(vehicle.getEngine());
        existingVehicle.setMax_power(vehicle.getMax_power());
        existingVehicle.setTorque(vehicle.getTorque());
        existingVehicle.setSeats(vehicle.getSeats());
        return vehicleRepository.save(existingVehicle);

    }
}
