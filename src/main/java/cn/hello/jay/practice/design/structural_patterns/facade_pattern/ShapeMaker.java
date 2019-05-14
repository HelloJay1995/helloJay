package cn.hello.jay.practice.design.structural_patterns.facade_pattern;

/**
 * 3.
 *
 * @author 周健以
 * @Date 2019年03月27日
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }
}
