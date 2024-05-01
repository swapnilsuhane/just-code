package com.just.code.lld.parkinglot.model.parking;

public class ParkingSlot {
    int id;
    String location;
    ParkingStatus parkingStatus;
    ParkingType parkingType;

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public ParkingStatus getParkingStatus() {
        return parkingStatus;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public ParkingSlot(int id, String location, ParkingStatus parkingStatus, ParkingType parkingType) {
        this.id = id;
        this.location = location;
        this.parkingStatus = parkingStatus;
        this.parkingType = parkingType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setParkingStatus(ParkingStatus parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }
}
