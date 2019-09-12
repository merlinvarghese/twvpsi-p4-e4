package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

class ValetTest {
    @Test
    void expectValetToParkACarSuccessfully() {
        Parkable vehicle = mock(Parkable.class);
        ParkingLot parkingLotOne = new ParkingLot(5);
        ParkingLot parkingLotTwo = new ParkingLot(10);
        ParkingLot parkingLotThree = new ParkingLot(2);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLotOne, parkingLotTwo, parkingLotThree);
        Valet valet = new Valet(parkingLots);
        assertDoesNotThrow(() -> valet.park(vehicle));
    }


}
