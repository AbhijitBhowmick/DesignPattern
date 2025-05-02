package org.example.collibra;

public class Circle implements Shape {

    private final int x;

    public Circle(int x) {
        this.x = x;
    }

    @Override
    public int calculateArea() {
        return 3 * x * x;
    }
}
