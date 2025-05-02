package org.example.creationaldp;

// Concrete Factory for Sports Car Builder
class SportsCarBuilderFactory implements CarBuilderFactory {
    @Override
    public Car.CarBuilder createBuilder() {
        return new Car.CarBuilder()
                .setModel("Sports")
                .setEngine("V8")
                .setSeats(2)
                .setGps(true);
    }
}
