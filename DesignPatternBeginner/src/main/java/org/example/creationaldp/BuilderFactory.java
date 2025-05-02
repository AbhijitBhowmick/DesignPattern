package org.example.creationaldp;

public class BuilderFactory {
    public static void main(String[] args) {
        CarBuilderFactory factory;

        String carType = "City"; // This could come from config/user input

        if ("Sports".equalsIgnoreCase(carType)) {
            factory = new SportsCarBuilderFactory();
        } else {
            factory = new CityCarBuilderFactory();
        }

        Car car = factory.createBuilder().build();
        System.out.println(car);
    }
}
