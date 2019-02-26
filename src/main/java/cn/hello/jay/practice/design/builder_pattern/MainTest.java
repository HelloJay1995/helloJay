/**
 * Copyright (C), 2011-2019, 微贷网.
 */
package cn.hello.jay.practice.design.builder_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class MainTest {

    public static void main(String[] args) {
        Meal meal = new Meal.MealBuilder().prepareVegMeal().prepareNonVegMeal().show();
        meal.showItems();
        System.out.println("总价：" + meal.getCost());
    }
}
