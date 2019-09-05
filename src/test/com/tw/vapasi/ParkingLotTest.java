package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void expectCanParkWhenParkingAvailable() throws CannotParkException {
        Parkable vehicle = new Vehicle("KA031111");
        ParkingLot parking = new ParkingLot(2);
        parking.park(vehicle);
        assertDoesNotThrow(() -> parking.park(vehicle));
    }

    @Test
    void expectCannotParkWhenParkingFull() {
        Parkable vehicle = new Vehicle("KA031112");
        ParkingLot parking = new ParkingLot(0);
        assertThrows(CannotParkException.class, () -> parking.park(vehicle));
    }

    @Test
    void expectCanUnParkWhenAlreadyParked() {
        Parkable vehicle = new Vehicle("KA031112");
        ParkingLot parking = new ParkingLot(2);
        assertDoesNotThrow(() -> parking.park(vehicle));
        assertDoesNotThrow(() -> parking.unpark(vehicle));
    }

    @Test
    void expectCannotUnParkWhenNotParked() {
        Parkable vehicle = new Vehicle("KA031112");
        ParkingLot parking = new ParkingLot(2);
        assertThrows(CannotUnparkException.class, () -> parking.unpark(vehicle));
    }

    @Test
    void expectCarIsParked() throws CannotParkException {
        Parkable vehicleOne = new Vehicle("KA034451");
        Parkable vehicleTwo = new Vehicle("KA034571");
        Parkable vehicleThree = new Vehicle("KA034221");
        Parkable vehicleFour = new Vehicle("KA034433");
        ParkingLot parking = new ParkingLot(10);

        parking.park(vehicleOne);
        parking.park(vehicleTwo);
        parking.park(vehicleThree);
        parking.park(vehicleFour);

        assertTrue(parking.isVehicleParked(vehicleThree));
    }

    @Test
    void expectCarIsNotParked() throws CannotParkException {
        Parkable vehicleOne = new Vehicle("KA034451");
        Parkable vehicleTwo = new Vehicle("KA034571");
        Parkable vehicleThree = new Vehicle("KA034221");
        Parkable vehicleFour = new Vehicle("KA034433");
        ParkingLot parking = new ParkingLot(10);

        parking.park(vehicleOne);
        parking.park(vehicleTwo);
        parking.park(vehicleThree);

        assertFalse(parking.isVehicleParked(vehicleFour));
    }
}
