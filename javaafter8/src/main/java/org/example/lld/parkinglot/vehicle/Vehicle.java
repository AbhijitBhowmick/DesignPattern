package org.example.lld.parkinglot.vehicle;

public abstract class Vehicle {
    protected String licenseNumber;
    protected VehicleType vehicleType;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
