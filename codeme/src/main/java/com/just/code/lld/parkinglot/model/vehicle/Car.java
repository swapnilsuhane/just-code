package com.just.code.lld.parkinglot.model.vehicle;

public class Car extends Vehicle{

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
