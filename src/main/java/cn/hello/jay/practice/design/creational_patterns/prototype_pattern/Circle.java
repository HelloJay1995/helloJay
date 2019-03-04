/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.prototype_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("circle draw()");
    }
}
