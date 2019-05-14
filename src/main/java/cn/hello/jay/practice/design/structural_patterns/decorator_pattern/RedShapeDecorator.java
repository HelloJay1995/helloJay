package cn.hello.jay.practice.design.structural_patterns.decorator_pattern;

/**
 * 4.创建ShapeDecorator类的实体装饰类
 *
 * @author 周健以
 * @Date 2019年03月27日
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shapeDecorator) {
        super(shapeDecorator);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(shapeDecorator);

    }

    private void setRedBorder(Shape decoratorShape) {
        System.out.println("画红色圈圈");
    }

}
