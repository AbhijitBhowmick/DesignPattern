package org.example.lld.coffeevendingmachine;

import java.util.Map;

public record Recipe(Map<String, Integer> ingredients) {
    public Recipe {
        ingredients = Map.copyOf(ingredients);
     }
}
