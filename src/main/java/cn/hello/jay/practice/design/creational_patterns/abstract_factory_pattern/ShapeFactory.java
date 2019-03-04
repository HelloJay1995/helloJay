/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern;

import cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.color.Color;
import cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.square.Shape;

/**
 * 创建一个工厂，生成基于给定信息的实体类对象
 *
 * @author 周健以
 * @Date 2019年02月22日
 */
public class ShapeFactory extends AbstractFactory{

    private static ShapeFactory shapFactory;

    private ShapeFactory() {
    }

    public static ShapeFactory getInstance() {
        if (shapFactory == null) {
            synchronized (ShapeFactory.class) {
                if (shapFactory == null) {
                    shapFactory = new ShapeFactory();
                }
            }
        }
        return shapFactory;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }

    public Shape getShape(String shape) {
        try {
            Class<?> clazz = Class.forName(shape);
            return (Shape) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

