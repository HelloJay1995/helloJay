/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.bridge_pattern;

/**
 * 4. 创建实现了 Shape 接口的实体类。
 *
 * @author 周健以
 * @Date 2019年03月05日
 */
public class Circle extends Shape {

    private int x, y, radius;

    public Circle(DrawAPI drawAPI, int x, int y, int radius) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
