/**
 * Copyright (C), 2011-2019, 微贷网.
 */
package cn.hello.jay.practice.design.factory_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class MainTest {

    public static void main(String[] args) {
        ShapeFactory.getInstance().getShape(ShapeFactory.RECTANGLE).draw();
        ShapeFactory.getInstance().getShape(ShapeFactory.SQUARE).draw();
        ShapeFactory.getInstance().getShape(ShapeFactory.CIRCLE).draw();
    }
}
