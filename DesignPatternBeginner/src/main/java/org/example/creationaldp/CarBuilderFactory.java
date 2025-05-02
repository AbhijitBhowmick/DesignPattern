package org.example.creationaldp;

// Builder interface for Cars (optional if you want different builder types)
interface CarBuilderFactory {
    Car.CarBuilder createBuilder();
}
