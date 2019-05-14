package cn.hello.jay.practice.design.structural_patterns.decorator_pattern;

/**
 * 3.创建了Shape接口的抽象装饰类
 *
 * @author 周健以
 * @Date 2019年03月27日
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape shapeDecorator;

    public ShapeDecorator(Shape shapeDecorator) {
        this.shapeDecorator = shapeDecorator;
    }

    public void draw() {
        shapeDecorator.draw();
    }
}
