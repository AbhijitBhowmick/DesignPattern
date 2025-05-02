package org.example.lld.coffeevendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class CoffeeMachine {
    private final Map<String, CoffeeType> menu = new HashMap<>();
    private final Inventory inventory = Inventory.getInstance();

    public CoffeeMachine() {
        // Initialize menu with coffee types and recipes
        menu.put("espresso", new CoffeeType("Espresso", 2.5, new Recipe(Map.of(
                "CoffeeBeans", 10,
                "Water", 30
        ))));
        menu.put("cappuccino", new CoffeeType("Cappuccino", 3.0, new Recipe(Map.of(
                "CoffeeBeans", 8,
                "Water", 20,
                "Milk", 40
        ))));
        menu.put("latte", new CoffeeType("Latte", 3.5, new Recipe(Map.of(
                "CoffeeBeans", 8,
                "Water", 20,
                "Milk", 60
        ))));
    }
    public void displayMenu(){
        System.out.println("===Coffee Menu===");
        menu.values().forEach(coffee ->System.out.printf("%s - $%.2f%n", coffee.name(),coffee.price()));
    }
    public Optional<CoffeeType> selectCoffee(String coffeeName) {
        return Optional.ofNullable(menu.get(coffeeName.toLowerCase()));
    }
    // Process order: payment, ingredient check, dispenseø
    public synchronized boolean orderCoffee(String coffeeName, PaymentStrategy paymentStrategy) {
        var coffeeOpt = selectCoffee(coffeeName);
        if (coffeeOpt.isEmpty()) {
            System.out.println("Selected coffee not available.");
            return false;
        }
        var coffee = coffeeOpt.get();
        if (!inventory.hasIngredients(coffee.recipe())) {
            System.out.println("Ingredients not sufficient to prepare " + coffee.name());
            return false;
        }

        if (!paymentStrategy.pay(coffee.price())) {
            System.out.println("Payment failed.");
            return false;
        }

        if (!inventory.useIngredients(coffee.recipe())) {
            System.out.println("Failed to use ingredients due to concurrent modification.");
            return false;
        }

        dispenseCoffee(coffee);
        notifyLowStock();
        return true;

    }

    private void dispenseCoffee(CoffeeType coffee) {
        System.out.println("Dispensing your " + coffee.name() + "... Enjoy!");
    }

    private void notifyLowStock() {
        var lowStock = inventory.getLowStockIngredients(10);
        if (!lowStock.isEmpty()) {
            System.out.println("Warning: Low stock for ingredients: " + String.join(", ", lowStock));
        }
    }

    // For testing: refill inventory
    public void refillIngredient(String name, int qty) {
        inventory.addIngredient(name, qty);
        System.out.println("Refilled " + name + " by " + qty);
    }


}





