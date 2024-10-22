package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    ArrayList<String> wishes = new ArrayList<>();
    private final HashMap<String, ArrayList<String>> dinnerByCategories;

    DinnerConstructor() {
        dinnerByCategories = new HashMap<>();
    }

    void addDish(String dishType, String dishName) {
        if (dinnerByCategories.containsKey(dishType)) {
            ArrayList<String> dishes = dinnerByCategories.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dinnerByCategories.put(dishType, dishes);
        }
    }

    void addWishes(String dish) {
        wishes.add(dish);
    }

    void generateDishCombo(int numberOfCombos, ArrayList<String> wishes) {
        Random random = new Random();

        for (int i = 1; i <= numberOfCombos; i++) {
            System.out.println("Комбо №" + i + ":");
            ArrayList<String> generatedCombo = new ArrayList<>();

            for (String wish : wishes) {
                ArrayList<String> dishes = dinnerByCategories.get(wish);
                int randomNumber = random.nextInt(dishes.size());
                generatedCombo.add(dishes.get(randomNumber));
            }
            System.out.println(generatedCombo);

        }
    }

    boolean checkType(String type) {
        return dinnerByCategories.containsKey(type);
    }

    boolean checkOnRepeat (String dishType, String dishName) {
        if (!dinnerByCategories.isEmpty()) {
            if (dinnerByCategories.containsKey(dishType)) {
                return dinnerByCategories.get(dishType).contains(dishName);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

