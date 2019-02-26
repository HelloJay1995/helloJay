/**
 * Copyright (C), 2011-2019, 微贷网.
 */
package cn.hello.jay.practice.design.prototype_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("circle draw()");
    }
}
