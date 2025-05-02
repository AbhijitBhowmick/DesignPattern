package org.example.lld.parkinglot;

import org.example.lld.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

//Singleton class
public class ParkingLot {
    private static ParkingLot instanceParkingLot;
    private List<Level> levels;


    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instanceParkingLot == null) {
            instanceParkingLot = new ParkingLot();
        }
        return instanceParkingLot;
    }
    public void addLevel(Level level) {
        levels.add(level);
    }
    public boolean parkVehicle(Vehicle vehicle) {

        return levels.stream()
                .filter(level -> level.parkingVehicle(vehicle))
                .findFirst()
                .map(level-> {
                    System.out.println("Vehicle parked successfully.");
                    return true;
                })
                .orElseGet(() -> {
                    System.out.println("Could not park vehicle.");
                    return false;
                });
    }

    public boolean unparkVehicle(Vehicle vehicle) {

        return levels.stream()
                .filter(level -> level.unParkingVehicle(vehicle))
                .findFirst()
                .map(level-> {
                    System.out.println("Vehicle unparked parked successfully.");
                    return true;
                })
                .orElseGet(() -> {
                    System.out.println("Could not unpark vehicle.");
                    return false;
                });
    }

    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }

}






