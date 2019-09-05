package com.tw.vapasi;

import java.util.HashSet;
import java.util.Set;

//understands space to station a vehicle
class ParkingLot {
    private int capacity;
    private Set<Vehicle> vehicles;

    ParkingLot(int capacity) {
        this.capacity = capacity;
        vehicles = new HashSet<>();
    }

    void park(Vehicle vehicle) throws CannotParkException {
        if (isParkingSlotNotAvailable()) {
            throw new CannotParkException();
        }
        vehicles.add(vehicle);
    }

    void unPark(Vehicle vehicle) throws CannotUnParkException {
        if (isVehicleNotParked(vehicle)) {
            throw new CannotUnParkException();
        }
        vehicles.remove(vehicle);
    }

    private boolean isParkingSlotNotAvailable() {
        return vehicles.size() == capacity;
    }

    private boolean isVehicleNotParked(Vehicle vehicle) {
        return !vehicles.contains(vehicle);
    }
}

