/**
 * Copyright (C), 2011-2019, 微贷网.
 */
package cn.hello.jay.practice.design.builder_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class CokeDrink extends Drink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
