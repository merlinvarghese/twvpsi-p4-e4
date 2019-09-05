package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void expectCanParkWhenParkingAvailable() throws CannotParkException {
        Vehicle vehicle = new Vehicle("KA031111");
        ParkingLot parking = new ParkingLot(2);
        parking.park(vehicle);
        assertDoesNotThrow(() -> parking.park(vehicle));
    }

    @Test
    void expectCannotParkWhenParkingFull() {
        Vehicle vehicle = new Vehicle("KA031112");
        ParkingLot parking = new ParkingLot(0);
        assertThrows(CannotParkException.class, () -> parking.park(vehicle));
    }

    @Test
    void expectCanUnParkWhenAlreadyParked() {
        Vehicle vehicle = new Vehicle("KA031112");
        ParkingLot parking = new ParkingLot(2);
        assertDoesNotThrow(() -> parking.park(vehicle));
        assertDoesNotThrow(() -> parking.unPark(vehicle));
    }

    @Test
    void expectCannotUnParkWhenNotParked() {
        Vehicle vehicle = new Vehicle("KA031112");
        ParkingLot parking = new ParkingLot(2);
        assertThrows(CannotUnParkException.class, () -> parking.unPark(vehicle));
    }
}
