package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    private final HashMap<String, ArrayList<String>> dinnerByCategories;
    DinnerConstructor () {
        dinnerByCategories = new HashMap<>();
    }
    void addDish(String dishType, String dishName) {
        if (dinnerByCategories.containsKey(dishType)) {
            ArrayList<String> dishes = dinnerByCategories.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList <String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dinnerByCategories.put(dishType, dishes);
        }
    }
    void generateDinner (int countOfCombos, ArrayList<String> typeOfdishes) {
        typeOfdishes = new ArrayList<>();
        typeOfdishes.addAll(dinnerByCategories.keySet());

    }
}
