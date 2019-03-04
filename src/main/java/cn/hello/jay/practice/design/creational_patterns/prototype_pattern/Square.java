/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.prototype_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Square extends Shape {

    public Square() {
        type = "square";
    }

    @Override
    public void draw() {
        System.out.println("square draw()");
    }
}
