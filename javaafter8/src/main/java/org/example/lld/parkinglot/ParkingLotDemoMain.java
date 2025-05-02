package org.example.lld.parkinglot;

import org.example.lld.parkinglot.vehicle.Car;
import org.example.lld.parkinglot.vehicle.MotorCycle;
import org.example.lld.parkinglot.vehicle.Truck;
import org.example.lld.parkinglot.vehicle.Vehicle;
import org.example.lld.parkinglot.ParkingLot;

public class ParkingLotDemoMain {
    public static void main(String args[]) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 80));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new MotorCycle("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.displayAvailability();

        // Unpark vehicle
        parkingLot.unparkVehicle(motorcycle);

        // Display updated availability
        parkingLot.displayAvailability();
    }
}
