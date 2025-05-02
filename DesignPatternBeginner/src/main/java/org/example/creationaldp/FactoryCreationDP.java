package org.example.creationaldp;

/*The Factory Pattern is a creational design pattern in Java that provides an interface for creating objects,
allowing subclasses or a separate factory class to decide which class to instantiate. This pattern centralizes
 object creation logic and decouples the client from the specific classes used, making code more flexible
 and maintainable
 */

public class FactoryCreationDP {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw(); // Output: Inside Circle::draw() method.

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw(); // Output: Inside Rectangle::draw() method.

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw(); // Output: Inside Square::draw() method.
    }
}
