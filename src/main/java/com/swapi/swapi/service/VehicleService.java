package com.swapi.swapi.service;

import com.swapi.swapi.Model.Vehicle;
import com.swapi.swapi.Repository.VehiclePagingRepository;
import com.swapi.swapi.Repository.VehicleRepository;
import com.swapi.swapi.error.NotFoundObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repo;

    @Autowired
    private VehiclePagingRepository pagingRepo;

    public Vehicle save(Vehicle vehicle) {

        return repo.save(vehicle);
    }

    public Page<Vehicle> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Vehicle findById(String vehicleId) {
        return repo.findById(UUID.fromString(vehicleId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Vehicle Not Found",Vehicle.class.getName(), vehicleId);
        });
    }

    public void deleteById(String vehicleId) {
        repo.deleteById(UUID.fromString(vehicleId));

    }
}