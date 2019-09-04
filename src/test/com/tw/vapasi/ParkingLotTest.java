package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void expectParkingAvailable() {
        Map<String, String> parkingWithEmptySpace = new HashMap<>();
        parkingWithEmptySpace.put("A11", "KA020000");
        parkingWithEmptySpace.put("A13", null);
        parkingWithEmptySpace.put("B15", "KA020000");
        parkingWithEmptySpace.put("C11", null);
        parkingWithEmptySpace.put("D23", "KA020000");

        ParkingLot parking = new ParkingLot(parkingWithEmptySpace);

        assertTrue(parking.isParkingAvailable());
    }

    @Test
    void expectParkingNotAvailable() {
        Map<String, String> parkingWithEmptySpace = new HashMap<>();
        parkingWithEmptySpace.put("A11", "KA020000");
        parkingWithEmptySpace.put("A11", "KA030007");
        parkingWithEmptySpace.put("A11", "KA039033");
        parkingWithEmptySpace.put("A11", "KA016788");
        parkingWithEmptySpace.put("A11", "KA019999");

        ParkingLot parking = new ParkingLot(parkingWithEmptySpace);

        assertFalse(parking.isParkingAvailable());
    }

}