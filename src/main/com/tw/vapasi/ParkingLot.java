package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

//understands space to station a vehicle
class ParkingLot {
    private int capacity;
    private List<Parkable> vehicles;

    ParkingLot(int capacity) {
        this.capacity = capacity;
        vehicles = new ArrayList<>();
    }

    void park(Parkable vehicle) throws CannotParkException {
        if (isParkingSlotNotAvailable()) {
            throw new CannotParkException();
        }
        vehicles.add(vehicle);
    }

    void unpark(Parkable vehicle) throws CannotUnparkException {
        if (isVehicleNotParked(vehicle)) {
            throw new CannotUnparkException();
        }
        vehicles.remove(vehicle);
    }

    private boolean isParkingSlotNotAvailable() {
        return vehicles.size() == capacity;
    }

    private boolean isVehicleNotParked(Parkable vehicle) {
        return !vehicles.contains(vehicle);
    }

    boolean isVehicleParked(Parkable vehicle) {
        return vehicles.contains(vehicle);
    }
}