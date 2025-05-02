package org.example.structuraldp.decorator;

// Concrete Component
public class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain pizza";
    }

    @Override
    public double cost() {
        return 8.0;
    }
}