package org.example.structuraldp.flyweight;

// Flyweight class holding intrinsic (shared) state
public class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree of color " + color + " with texture " + texture + " at (" + x + ", " + y + ")");
    }
}

