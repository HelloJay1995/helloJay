/**
 * Copyright (C), 2011-2019, 微贷网.
 */
package cn.hello.jay.practice.design.abstract_factory_pattern;

import cn.hello.jay.practice.design.abstract_factory_pattern.color.Color;
import cn.hello.jay.practice.design.abstract_factory_pattern.square.Shape;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class ColorFactory extends AbstractFactory {

    private static ColorFactory colorFactory;

    private ColorFactory() {
    }

    public static ColorFactory getInstance() {
        if (colorFactory == null) {
            synchronized (ColorFactory.class) {
                if (colorFactory == null) {
                    colorFactory = new ColorFactory();
                }
            }
        }
        return colorFactory;
    }

    @Override
    public Color getColor(String color) {
        try {
            Class<?> clazz = Class.forName(color);
            return (Color) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
