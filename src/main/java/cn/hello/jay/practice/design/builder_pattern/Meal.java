/**
 * Copyright (C), 2011-2019, 微贷网.
 */
package cn.hello.jay.practice.design.builder_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个 Meal 类，带有上面定义的 Item 对象
 *
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Meal {

    private List<Item> items = new ArrayList<>();

    /**
     * 添加条目
     *
     * @param item
     */
    private void addItem(Item item) {
        items.add(item);
    }

    /**
     * 获取总价格
     *
     * @return
     */
    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    /**
     * 显示条目详细信息
     */
    public void showItems() {
        for (Item item : items) {
            System.out.println(String.format("Item:%s,Packing:%s,Price:%s", item.name(), item.packing(), item.price()));
        }
    }

    /**
     * 创建一个 MealBuilder 类，实际的 builder 类负责创建 Meal 对象
     */
    public static class MealBuilder {
        private Meal meal = null;

        public MealBuilder() {
            meal = new Meal();
        }

        public MealBuilder prepareVegMeal() {
            meal.addItem(new VegBurger());
            meal.addItem(new CokeDrink());
            return this;
        }

        public MealBuilder prepareNonVegMeal() {
            meal.addItem(new ChickenBurger());
            meal.addItem(new PepsiDrink());
            return this;
        }

        public Meal show() {
            return meal;
        }
    }
}
