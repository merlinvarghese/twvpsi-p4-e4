package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParkingLotTest {

    @Test
    void expectCanParkWhenParkingAvailable() throws CannotParkException {
        Parkable vehicle = mock(Parkable.class);
        ParkingLot parking = new ParkingLot(2);
        parking.park(vehicle);
        assertDoesNotThrow(() -> parking.park(vehicle));
    }

    @Test
    void expectCannotParkWhenParkingFull() {
        Parkable vehicle = mock(Parkable.class);
        ParkingLot parking = new ParkingLot(0);
        assertThrows(CannotParkException.class, () -> parking.park(vehicle));
    }

    @Test
    void expectCanUnParkWhenAlreadyParked() {
        Parkable vehicle = mock(Parkable.class);
        ParkingLot parking = new ParkingLot(2);
        assertDoesNotThrow(() -> parking.park(vehicle));
        assertDoesNotThrow(() -> parking.unpark(vehicle));
    }

    @Test
    void expectCannotUnParkWhenNotParked() {
        Parkable vehicle = mock(Parkable.class);
        ParkingLot parking = new ParkingLot(2);
        assertThrows(CannotUnparkException.class, () -> parking.unpark(vehicle));
    }

    @Test
    void expectCarIsParked() throws CannotParkException {
        ParkingLot parking = new ParkingLot(10);
        Parkable vehicleOne = mock(Parkable.class);
        Parkable vehicleTwo = mock(Parkable.class);
        Parkable vehicleThree = mock(Parkable.class);
        Parkable vehicleFour = mock(Parkable.class);

        parking.park(vehicleOne);
        parking.park(vehicleTwo);
        parking.park(vehicleThree);
        parking.park(vehicleFour);

        assertTrue(parking.isVehicleParked(vehicleThree));
    }

    @Test
    void expectCarIsNotParked() throws CannotParkException {
        ParkingLot parking = new ParkingLot(10);
        Parkable vehicleOne = mock(Parkable.class);
        Parkable vehicleTwo = mock(Parkable.class);
        Parkable vehicleThree = mock(Parkable.class);
        Parkable vehicleFour = mock(Parkable.class);

        parking.park(vehicleOne);
        parking.park(vehicleTwo);
        parking.park(vehicleThree);

        assertFalse(parking.isVehicleParked(vehicleFour));
    }

    @Test
    void expectOwnerNotifiedWhenParkingFull() throws CannotParkException {
        ParkingLotOwner owner = mock(ParkingLotOwner.class);
        ParkingLot parking = new ParkingLot(1, owner);
        Parkable vehicle = mock(Parkable.class);
        parking.park(vehicle);
        verify(owner, times(1)).notifyParkingFull();
    }

    @Test
    void expectOwnerNotNotifiedWhenParkingAvailable() throws CannotParkException {
        ParkingLotOwner owner = mock(ParkingLotOwner.class);
        ParkingLot parking = new ParkingLot(2, owner);
        Parkable vehicle = mock(Parkable.class);
        parking.park(vehicle);
        verify(owner, never()).notifyParkingFull();
    }

    @Test
    void expectOwnerNotifiedWhenParkingBecameAvailable() throws CannotParkException, CannotUnparkException {
        ParkingLotOwner owner = mock(ParkingLotOwner.class);
        ParkingLot parking = new ParkingLot(1, owner);
        Parkable vehicle = mock(Parkable.class);
        parking.park(vehicle);
        parking.unpark(vehicle);
        verify(owner).notifyParkingAvailable();
    }

    @Test
    void expectOwnerNotNotifiedWhenParkingHasMultipleFreeSlots() throws CannotParkException, CannotUnparkException {
        ParkingLotOwner owner = mock(ParkingLotOwner.class);
        ParkingLot parking = new ParkingLot(3, owner);
        Parkable vehicle = mock(Parkable.class);
        parking.park(vehicle);
        parking.unpark(vehicle);
        verify(owner, never()).notifyParkingAvailable();
    }
}
