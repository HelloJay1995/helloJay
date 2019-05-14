package cn.hello.jay.practice.design.structural_patterns.flyweight_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.创建一个工厂，生成基于给定信息的实体类的对象
 *
 * @author 周健以
 * @Date 2019年03月27日
 */
public class ShapeFactory {

    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Shape shape = circleMap.get(color);
        if (shape == null) {
            System.out.println("我要创建circle了！");
            shape = new Circle(color);
            circleMap.put(color, shape);
        }
        return shape;
    }
}
