package org.example.creationaldp;

// Concrete Factory for City Car Builder
class CityCarBuilderFactory implements CarBuilderFactory {
    @Override
    public Car.CarBuilder createBuilder() {
        return new Car.CarBuilder()
                .setModel("City")
                .setEngine("Electric")
                .setSeats(4)
                .setGps(false);
    }
}
