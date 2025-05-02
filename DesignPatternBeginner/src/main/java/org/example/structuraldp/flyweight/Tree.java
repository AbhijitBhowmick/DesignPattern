package org.example.structuraldp.flyweight;

public class Tree {
    private final TreeType type; // Shared flyweight
    private int x;
    private int y;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

