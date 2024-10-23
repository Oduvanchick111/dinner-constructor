package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private final Random random = new Random();
    private final HashMap<String, ArrayList<String>> dinnerByCategories;

    DinnerConstructor() {
        dinnerByCategories = new HashMap<>();
    }

    void addDish(String dishType, String dishName) {
        ArrayList<String> dishes = dinnerByCategories.computeIfAbsent(dishType, k -> new ArrayList<>());
        if (dishes.contains(dishName)) {
            System.out.println("Блюдо с названием " + dishName + " уже есть");
            return;
        }
        dishes.add(dishName);
    }

    void generateDishCombo(int numberOfCombos, ArrayList<String> wishes) {


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
        wishes.clear();
    }

    boolean checkType(String type) {
        return dinnerByCategories.containsKey(type);
    }
}

