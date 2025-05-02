package org.example.lld.parkinglot;

import org.example.lld.parkinglot.vehicle.Vehicle;
import org.example.lld.parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Level {
    private final int floors;
    private final List<ParkingSpot> parkingSpots;


    public Level(int floors, int noOfParkingSpot) {
        this.floors = floors;//For simplifying we are taking floor as 1
        this.parkingSpots = new ArrayList<>(noOfParkingSpot);
        // Assuming parkingSpots is a List<ParkingSpot>
        IntStream.rangeClosed(1, (int) (noOfParkingSpot * VehicleType.MotorCycle.getParkingWeight()))
                .mapToObj(i -> new ParkingSpot(i, VehicleType.MotorCycle))
                .forEach(parkingSpots::add);
        IntStream.rangeClosed(1, (int) (noOfParkingSpot * VehicleType.CAR.getParkingWeight()))
                .mapToObj(i -> new ParkingSpot(i, VehicleType.CAR))
                .forEach(parkingSpots::add);
        IntStream.rangeClosed(1, (int) (noOfParkingSpot * VehicleType.Trucks.getParkingWeight()))
                .mapToObj(i -> new ParkingSpot(i, VehicleType.Trucks))
                .forEach(parkingSpots::add);
    }

    public synchronized boolean parkingVehicle(Vehicle vehicle) {
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getVehicleType() == vehicle.getVehicleType())
                .findFirst()
                .map(spot -> {
                    spot.parkVehicle(vehicle);
                    return true;
                })
                .orElse(false);
    }

    public synchronized boolean unParkingVehicle(Vehicle vehicle) {
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getVehicleType() == vehicle.getVehicleType())
                .findFirst()
                .map(spot -> {
                    spot.unparkVehicle();
                    return true;
                })
                .orElse(false);
    }

    public void displayAvailability() {
        System.out.println("Level " + floors + " Availability:");

        parkingSpots.forEach(spot -> System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available For" : "Occupied By ") + " " + spot.getVehicleType()));

    }
}
