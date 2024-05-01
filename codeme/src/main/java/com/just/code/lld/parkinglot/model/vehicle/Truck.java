package com.just.code.lld.parkinglot.model.vehicle;

public class Truck extends Vehicle{

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
