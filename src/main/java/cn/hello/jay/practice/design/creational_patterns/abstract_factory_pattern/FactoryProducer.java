/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern;

/**
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 *
 * @author 周健以
 * @Date 2019年02月22日
 */
public class FactoryProducer {
    private static AbstractFactory abstractFactory = null;

    public static AbstractFactory getFactory(String factory) {
        if (factory == null) {
            throw new RuntimeException("param can't be null");
        }
        if (factory.equalsIgnoreCase(AbstractFactory.SHAPEFACTORY)) {
            abstractFactory = ShapeFactory.getInstance();
        } else if (factory.equalsIgnoreCase(AbstractFactory.COLORFACTORY)) {
            abstractFactory = ColorFactory.getInstance();
        }
        return abstractFactory;
    }

}
