package com.tw.vapasi;

import java.util.Map;

//understands space to station a vehicle
class ParkingLot {
    private Map<String, String> allocationDetails;

    ParkingLot(Map<String, String> allocationDetails) {
        this.allocationDetails = allocationDetails;
    }

    boolean isParkingAvailable() {
        return allocationDetails.containsValue(null);
    }
}

