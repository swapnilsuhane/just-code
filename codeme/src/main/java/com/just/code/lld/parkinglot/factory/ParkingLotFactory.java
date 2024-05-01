package com.just.code.lld.parkinglot.factory;

import com.just.code.lld.parkinglot.model.parking.ParkingLot;
import com.just.code.lld.parkinglot.model.parking.ParkingSlot;
import com.just.code.lld.parkinglot.model.parking.ParkingStatus;
import com.just.code.lld.parkinglot.model.parking.ParkingType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotFactory {
    public static ParkingLot createParkingLot() {
        ParkingLot parkingLot = new ParkingLot();
        String address = "address 1, 934932";
        parkingLot.setAddress(address);
        int CAPACITY = 100;
        parkingLot.setTotalCapacity(CAPACITY);
        parkingLot.setAvailableCapacity(CAPACITY);
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        for (int i = 1; i < CAPACITY; i++) {
            if (i < 50) {
                parkingSlots.add(new ParkingSlot(i, address + "-" + i, ParkingStatus.AVAILABLE, ParkingType.CAR));
            } else if (i > 50 && i < 80) {
                parkingSlots.add(new ParkingSlot(i, address + "-" + i, ParkingStatus.AVAILABLE, ParkingType.BUS_TRUCK));
            } else {
                parkingSlots.add(new ParkingSlot(i, address + "-" + i, ParkingStatus.AVAILABLE, ParkingType.TWO_WHEELER));
            }
        }
        parkingLot.setParkingSlots(parkingSlots);
        return parkingLot;
    }
}
