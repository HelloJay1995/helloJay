/**
 * Copyright (C), 2011-2019, 微贷网.
 */
package cn.hello.jay.practice.design.prototype_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建一个类，从数据库获取实体类，并把它们存储在一个 Hashtable 中
 *
 * @author 周健以
 * @Date 2019年02月22日
 */
public class ShapeCache {
    private static Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getShape(String shapeId) {
        return (Shape) shapeMap.get(shapeId).clone();
    }

    /**
     * 添加数据，创建该形状
     */
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
