package com.just.code.lld.parkinglot.service;

import com.just.code.lld.parkinglot.model.vehicle.Vehicle;
import com.just.code.lld.parkinglot.model.vehicle.VehicleType;

public interface ParkingService {
    boolean isAvailable(VehicleType vehicleType);

    boolean enterParking(Vehicle vehicle);

    boolean exitParking(Vehicle vehicle);
}
