package org.example.lld.parkinglot.vehicle;

public enum VehicleType {
    CAR(0.3),
    MotorCycle(0.2),
    Trucks(.5);
    final double parkingWeight;


    VehicleType(double parkingWeight) {
        this.parkingWeight = parkingWeight;

    }

    public double getParkingWeight() {
        return parkingWeight;
    }
}
