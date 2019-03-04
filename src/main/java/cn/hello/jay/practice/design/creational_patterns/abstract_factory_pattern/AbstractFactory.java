/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern;

import cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.color.Blue;
import cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.color.Color;
import cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.color.Green;
import cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.color.Red;
import cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.square.Circle;
import cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.square.Rectangle;
import cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.square.Shape;
import cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.square.Square;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public abstract class AbstractFactory {
    /**
     * 形状工厂类(包名+类名)
     */
    public static final String SHAPEFACTORY = ShapeFactory.class.getName();
    /**
     * 颜色工厂类(包名+类名)
     */
    public static final String COLORFACTORY = ColorFactory.class.getName();

    /**
     * 圆角矩形类名称(包名+类名)
     */
    public static final String RECTANGLE = Rectangle.class.getName();
    /**
     * 矩形类名称(包名+类名)
     */
    public static final String SQUARE = Square.class.getName();
    /**
     * 圆形类名称(包名+类名)
     */
    public static final String CIRCLE = Circle.class.getName();
    /**
     * 红色类名称(包名+类名)
     */
    public static final String RED = Red.class.getName();
    /**
     * 绿色类名称(包名+类名)
     */
    public static final String GREEN = Green.class.getName();
    /**
     * 蓝色类名称(包名+类名)
     */
    public static final String BLUE = Blue.class.getName();

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
