package com.just.code.lld.parkinglot.model.parking;

import com.just.code.lld.parkinglot.model.vehicle.VehicleType;

public enum ParkingType {
    CAR,
    BUS_TRUCK,
    TWO_WHEELER;

    static public ParkingType getParkingType(VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.CAR)) {
            return ParkingType.CAR;
        } else if (vehicleType.equals(VehicleType.BUS) || vehicleType.equals(VehicleType.TRUCK)) {
            return ParkingType.BUS_TRUCK;
        } else {
            return ParkingType.TWO_WHEELER;
        }
    }

    }
