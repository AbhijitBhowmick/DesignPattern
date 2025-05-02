package org.example.creationaldp;

public class Car {
    private final String model;
    private final String engine;
    private final int seats;
    private final boolean gps;

    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.engine = builder.engine;
        this.seats = builder.seats;
        this.gps = builder.gps;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", engine=" + engine + ", seats=" + seats + ", gps=" + gps + "]";
    }

    // Static Builder class
    public static class CarBuilder {
        private String model;
        private String engine;
        private int seats;
        private boolean gps;

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public CarBuilder setGps(boolean gps) {
            this.gps = gps;
            return this;
        }

        public Car build() {
            // Optional: validate fields before building
            return new Car(this);
        }
    }
}

