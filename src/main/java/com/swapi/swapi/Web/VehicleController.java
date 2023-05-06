package com.swapi.swapi.Web;

import com.swapi.swapi.Web.Model.Starships;
import com.swapi.swapi.Web.Model.Vehicle;
import com.swapi.swapi.Web.dto.starships.StarshipsApiPage;
import com.swapi.swapi.Web.dto.starships.StarshipsCreateRequest;
import com.swapi.swapi.Web.dto.starships.StarshipsResponse;
import com.swapi.swapi.Web.dto.vehicle.VehicleApiPage;
import com.swapi.swapi.Web.dto.vehicle.VehicleCreateRequest;
import com.swapi.swapi.Web.dto.vehicle.VehicleResponse;
import com.swapi.swapi.Web.error.InvalidObjectException;
import com.swapi.swapi.Web.mapping.StarshipsMapper;
import com.swapi.swapi.Web.mapping.VehicleMapper;
import com.swapi.swapi.Web.service.StarshipsService;
import com.swapi.swapi.Web.service.VehicleService;
import com.swapi.swapi.Web.validation.ObjectValidator;
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

        return ResponseEntity.ok(vehicleMapper.responseFromModel(vehicle));
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