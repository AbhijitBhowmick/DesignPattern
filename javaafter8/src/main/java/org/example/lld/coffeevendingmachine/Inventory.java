package org.example.lld.coffeevendingmachine;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// --- Inventory Singleton ---
public class Inventory {

    private final ConcurrentMap<String, Integer> ingredientStock = new ConcurrentHashMap<>();
    private static Inventory inventoryInstance ;

    private Inventory() {}

    public static Inventory getInstance() {
        if (null == inventoryInstance){
            inventoryInstance = new Inventory();
        }
        return inventoryInstance;
    }

    // Initialize or refill ingredients
    public synchronized void addIngredient(String name, int quantity) {
        ingredientStock.merge(name, quantity, Integer::sum);
    }

    // Check if enough ingredients are available for a recipe
    public boolean hasIngredients(Recipe recipe) {
        return recipe.ingredients().entrySet().stream()
                .allMatch(e->ingredientStock.getOrDefault(e.getKey(),0)>=e.getValue());
    }

    // Deduct ingredients for a recipe, return false if insufficient
    public synchronized boolean useIngredients(Recipe recipe) {
        if (!hasIngredients(recipe)) {
            return false;
        }
        recipe.ingredients().forEach((name , qty) ->
                ingredientStock.computeIfPresent(name, (k,v)-> v - qty));

       return true;
    }

    // Check for low stock ingredients (threshold = 10)
    public List<String> getLowStockIngredients(int threshold) {
        return ingredientStock.entrySet().stream()
                .filter(e -> e.getValue()<=threshold)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Integer> getCurrentStock() {
        return Map.copyOf(ingredientStock);
    }


}
