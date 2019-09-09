package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

//understands space to station a vehicle
class ParkingLot {
    private static String CANNOT_PARK_VEHICLE = "Vehicle could not be parked";
    private static String CANNOT_UNPARK_VEHICLE = "Vehicle could not be unparked";
    private int capacity;
    private List<Parkable> vehicles;
    private ParkingLotOwner owner;

    ParkingLot(int capacity) {
        this.capacity = capacity;
        vehicles = new ArrayList<>();
    }

    ParkingLot(int capacity, ParkingLotOwner owner) {
        this.capacity = capacity;
        vehicles = new ArrayList<>();
        this.owner = owner;
    }

    void park(Parkable vehicle) throws CannotParkException {
        if (isParkingSlotNotAvailable()) {
            throw new CannotParkException(CANNOT_PARK_VEHICLE);
        }
        vehicles.add(vehicle);
        if (isOwnerPresent() && isParkingSlotNotAvailable()) {
            owner.notifyParkingFull();
        }
    }

    void unpark(Parkable vehicle) throws CannotUnparkException {
        if (isVehicleNotParked(vehicle)) {
            throw new CannotUnparkException(CANNOT_UNPARK_VEHICLE);
        }
        vehicles.remove(vehicle);
        if (isOwnerPresent() && parkingBecameAvailable()) {
            owner.notifyParkingAvailable();
        }
    }

    boolean isVehicleParked(Parkable vehicle) {
        return vehicles.contains(vehicle);
    }

    private boolean isParkingSlotNotAvailable() {
        return vehicles.size() == capacity;
    }

    private boolean isVehicleNotParked(Parkable vehicle) {
        return !vehicles.contains(vehicle);
    }

    private boolean isOwnerPresent() {
        return owner != null;
    }

    private boolean parkingBecameAvailable() {
        return (vehicles.size() == capacity - 1);
    }
}