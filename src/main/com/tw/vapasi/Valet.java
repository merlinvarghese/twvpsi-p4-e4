package com.tw.vapasi;

import java.util.List;

// understands stationing/unstationing a vehicle in an allotted space
class Valet {
    private static String CANNOT_PARK_VEHICLE_BY_VALET = "Vehicle could not be parked by valet";
    private static String CANNOT_UNPARK_VEHICLE_BY_VALET = "Vehicle could not be unparked by valet";

    private final List<ParkingLot> parkingLots;

    Valet(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    void park(Parkable vehicle) throws CannotParkException {
        //check which first parking lot is available
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isParkingAvailable()) {
                parkingLot.park(vehicle);
                return;
            }
        }
        throw new CannotParkException(CANNOT_PARK_VEHICLE_BY_VALET);
    }


/*    void unpark(Parkable vehicle) throws CannotUnParkException {

    }*/

    void notifyParkingFull(ParkingLot parkingLot) {
    }

    void notifyParkingAvailable(ParkingLot parkingLot) {
    }

}
