/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.bridge_pattern;

/**
 * @author 周健以
 * @Date 2019年03月05日
 */
public class MainTest {

    public static void main(String[] args) {
        Circle greenCircle = new Circle(new GreenCircle(), 100, 100, 20);
        Circle redCircle = new Circle(new RedCircle(), 100, 100, 20);
        greenCircle.draw();
        redCircle.draw();
    }
}
