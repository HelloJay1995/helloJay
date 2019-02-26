/**
 * Copyright (C), 2011-2019, 微贷网.
 */
package cn.hello.jay.practice.design.builder_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public abstract class Drink implements Item {

    public Packing packing() {
        return new Bottle();
    }
}
