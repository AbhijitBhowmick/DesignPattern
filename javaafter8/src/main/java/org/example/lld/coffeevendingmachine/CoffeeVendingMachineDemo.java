package org.example.lld.coffeevendingmachine;

public class CoffeeVendingMachineDemo {
    public static void main(String[] args) {
        var machine = new CoffeeMachine();
        // Refill inventory
        machine.refillIngredient("CoffeeBeans", 10);
        machine.refillIngredient("Water", 500);
        machine.refillIngredient("Milk", 300);

        machine.displayMenu();

        // User orders
        machine.orderCoffee("Espresso", new CashPayment(5.0));
        machine.orderCoffee("Latte", new CashPayment(3.0)); // Insufficient cash
        machine.orderCoffee("Cappuccino", new CashPayment(3.5));

    }
}
