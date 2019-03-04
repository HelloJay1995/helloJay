/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.factory_pattern;

/**
 * 创建一个工厂，生成基于给定信息的实体类对象
 *
 * @author 周健以
 * @Date 2019年02月22日
 */
public class ShapeFactory {
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

    public Shape getShape(String type) {
        try {
            Class<?> clazz = Class.forName(type);
            return (Shape) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

