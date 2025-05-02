package org.example.collibra;

public class Square implements Shape {
    private final int x;

    public Square(int x) {
        this.x = x;
    }


    public int calculateArea() {
        return x * x;
    }
}
