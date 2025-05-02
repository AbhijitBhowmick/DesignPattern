package org.example.lld.parkinglot;

import org.example.lld.parkinglot.vehicle.Vehicle;
import org.example.lld.parkinglot.vehicle.VehicleType;

public class ParkingSpot {

    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;


    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getVehicleType() == vehicleType) {
            this.parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Parking Space not available or Wrong Vehicle Type");
        }

    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
