package com.just.code.lld.parkinglot.service;

import com.just.code.lld.parkinglot.model.parking.ParkingSlot;
import com.just.code.lld.parkinglot.model.parking.ParkingStatus;
import com.just.code.lld.parkinglot.model.parking.ParkingType;
import com.just.code.lld.parkinglot.model.vehicle.Vehicle;
import com.just.code.lld.parkinglot.model.vehicle.VehicleType;
import com.just.code.lld.parkinglot.factory.ParkingLotFactory;
import com.just.code.lld.parkinglot.model.parking.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingServiceImpl implements ParkingService {
    ParkingLot parkingLot;
    Map<Integer, ParkingSlot> parkedMap;

    public ParkingServiceImpl() {
        this.parkingLot = ParkingLotFactory.createParkingLot();
        this.parkedMap = new HashMap<>();
    }

    @Override
    public boolean isAvailable(VehicleType vehicleType) {
        return parkingLot.getAvailableCapacity() > 0;
    }

    @Override
    public boolean enterParking(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.getType();
        ParkingType parkingType = ParkingType.getParkingType(vehicleType);
        Optional<ParkingSlot> optionalParkingSlot = parkingLot.getParkingSlots().stream().filter(parkingSlot -> parkingSlot.getParkingType().equals(parkingType)
                && parkingSlot.getParkingStatus().equals(ParkingStatus.AVAILABLE)).findAny();
        optionalParkingSlot.ifPresent(parkingSlot -> parkedMap.put(vehicle.id, parkingSlot));
        optionalParkingSlot.ifPresent(parkingSlot -> parkingSlot.setParkingStatus(ParkingStatus.OCCUPIED));
        parkingLot.setAvailableCapacity(parkingLot.getAvailableCapacity()-1);
        return true;
    }

    @Override
    public boolean exitParking(Vehicle vehicle) {
        return false;
    }
}
