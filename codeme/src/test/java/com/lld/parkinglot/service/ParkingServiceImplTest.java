package com.lld.parkinglot.service;

import com.just.code.lld.parkinglot.model.vehicle.VehicleType;
import com.just.code.lld.parkinglot.service.ParkingService;
import com.just.code.lld.parkinglot.service.ParkingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingServiceImplTest {


    @BeforeEach
    void setUp() {
    }

    @Test
    void isAvailable() {
        //Mockito.when(parkingLot.getAvailableCapacity()).thenReturn(100);
        ParkingService parkingService = new ParkingServiceImpl();
        boolean available = parkingService.isAvailable(VehicleType.CAR);
        assertEquals(available, true);
    }

    @Test
    void enterParking() {
    }

    @Test
    void exitParking() {
    }
}