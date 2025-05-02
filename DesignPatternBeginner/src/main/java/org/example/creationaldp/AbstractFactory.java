package org.example.creationaldp;

/*
The Abstract Factory Pattern is a creational design pattern that provides an interface for creating
 families of related objects without specifying their concrete classes. It is particularly useful
 when a system needs to work with multiple variants of related products (e.g., UI components for
 different operating systems). Below is a Java implementation using the same components as earlier
 examples (GUIs for Windows and macOS).

Abstract Factory Pattern Example: Cross-Platform UI Components
Scenario:
Create UI components (Buttons and Checkboxes) that are consistent with a specific operating system
(Windows or macOS). The Abstract Factory ensures that all components from a factory belong to the
same OS family.
*/


public class AbstractFactory {
    public static void main(String[] args) {
        // Simulate OS detection
        String os = System.getProperty("os.name").toLowerCase();

        GUIFactory factory;
        if (os.contains("win")) {
            factory = new WindowsFactory();
        } else if (os.contains("mac")) {
            factory = new MacFactory();
        } else {
            throw new UnsupportedOperationException("OS not supported");
        }

        Application app = new Application(factory);
        app.renderUI();
    }
}
