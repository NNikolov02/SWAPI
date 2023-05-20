package com.swapi.swapi.Web;

import com.swapi.swapi.Model.Vehicle;
import com.swapi.swapi.dto.character.CharacterResponse;
import com.swapi.swapi.dto.vehicle.VehicleApiPage;
import com.swapi.swapi.dto.vehicle.VehicleCreateRequest;
import com.swapi.swapi.dto.vehicle.VehicleResponse;
import com.swapi.swapi.error.InvalidObjectException;
import com.swapi.swapi.mapping.VehicleMapper;
import com.swapi.swapi.service.VehicleService;
import com.swapi.swapi.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor
public class VehicleController {

    @Autowired
    private ObjectValidator validator;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleMapper vehicleMapper;
    private final Integer Page_Size = 10;


    @GetMapping(name = "", produces = "application/json")
    public VehicleApiPage<VehicleResponse> getAllVehicles(

            @RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<VehicleResponse> vehiclePage =
                vehicleService.fetchAll(currPage, Page_Size).map(vehicleMapper::responseFromModel);
        return new VehicleApiPage<>(vehiclePage);


    }


    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleResponse> getStarshipsById(@PathVariable String vehicleId) {
        Vehicle vehicle = vehicleService.findById(vehicleId);

        VehicleResponse responseVehicle = vehicleMapper.responseFromModel(vehicle);
       responseVehicle.getUrl();


        return ResponseEntity.ok(responseVehicle);
    }

    @DeleteMapping("/{vehicleId}")
    public void deletevehiclesById(@PathVariable String vehicleId) {
        vehicleService.deleteById(vehicleId);
    }

    @PostMapping("")
    public ResponseEntity<VehicleResponse> createVehicles(@RequestBody VehicleCreateRequest vehicleDto) {

        Map<String, String> validationErrors = validator.validate(vehicleDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Vehicle Create", validationErrors);
        }


        Vehicle mappedVehicle = vehicleMapper.modelFromCreateRequest(vehicleDto);

        Vehicle savedVehicles = vehicleService.save(mappedVehicle);

        VehicleResponse responseVehicle = vehicleMapper.responseFromModel(savedVehicles);

        return ResponseEntity.status(201).body(responseVehicle);

    }
}