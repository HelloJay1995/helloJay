/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.prototype_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("rectangle draw()");
    }
}
