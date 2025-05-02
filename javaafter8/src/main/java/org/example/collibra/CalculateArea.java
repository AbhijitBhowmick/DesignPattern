package org.example.collibra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateArea {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        try {
            List<Shape> listShapes = new ArrayList<>();
            listShapes.add(new Square(5));
            listShapes.add(new Circle(4));

            // Format areas to 2 decimal places and join with commas
            String areas = listShapes.stream()
                    .map(shape -> String.valueOf(shape.calculateArea()))
                    .collect(Collectors.joining(", "));

//            // Print the formatted areas
            System.out.println("Area: " + areas);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);  // exit with error code 1 on failure
        }
    }
}
