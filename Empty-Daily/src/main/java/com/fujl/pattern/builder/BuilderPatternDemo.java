package com.fujl.pattern.builder;

public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal prepareNonVegMeal = mealBuilder.prepareNonVegMeal();
        prepareNonVegMeal.showItems();
        System.out.println("Total cost:" + prepareNonVegMeal.getCost());
        System.out.println("----------------------");
        Meal prepareVegMeal = mealBuilder.prepareVegMeal();
        prepareVegMeal.showItems();
        System.out.println("Total cost:" + prepareVegMeal.getCost());
    }
}
