package com.bhupesh.spring.controller;

import com.bhupesh.spring.entity.ErrorObject;
import com.bhupesh.spring.entity.Vehicle;
import com.bhupesh.spring.service.VehicleService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/addVehicle")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @PostMapping("/addVehicles")
    public List<Vehicle> addAllVehicles(@RequestBody List<Vehicle> vehicles) {
        return vehicleService.saveVehicles(vehicles);
    }

    @GetMapping(value = "/getAllVehicle", produces = "application/json")
    public ResponseEntity<?> getAllVehicle(){
        try{
            Optional<?> optionalVehicle = Optional.ofNullable(vehicleService.getVehicles());
            if(optionalVehicle.isPresent()){
                return ResponseEntity.ok(optionalVehicle.get());
            }else{
                return notFound();
            }
        }catch (Exception ex) {
            return badRequest(ex);
        }
    }

    @GetMapping(value = "/getVehicleById/{id}", produces = "application/json")
    public ResponseEntity<?> getVehicleById(@PathVariable int id) {
        try{
            Optional<Vehicle> optionalVehicle = Optional.ofNullable(vehicleService.getVehicleById(id));
            if(optionalVehicle.isPresent()){
                return ResponseEntity.ok(optionalVehicle.get());
            }
            else{
                return notFound();
            }
        }catch (Exception ex) {
            return badRequest(ex);
        }
    }

    private ResponseEntity<?> notFound(){
        return new ResponseEntity<>(new ErrorObject(HttpStatus.NOT_FOUND.toString(), "Vehicle Not Found"), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<?> badRequest(Throwable throwable){
        return new ResponseEntity<>(new ErrorObject(HttpStatus.NOT_FOUND.toString(), "Bad Request"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getVehicleByName/{name}")
    public List<Vehicle> getVehicleByName(@PathVariable String name) {
        return vehicleService.getVehicleByName(name);
    }

    @PutMapping("/updateVehicle")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping(value = "/deleteVehicle/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, String> deleteVehicle(@PathVariable int id){
        String result = vehicleService.deleteVehicle(id);
        HashMap<String, String> response = new HashMap<>();
        response.put("message", vehicleService.deleteVehicle(id));
        response.put("status", HttpStatus.OK.toString());
        return response;
    }
}
