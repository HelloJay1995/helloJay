/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.bridge_pattern;

/**
 * 2. 创建实现了 DrawAPI 接口的实体桥接实现类。
 *
 * @author 周健以
 * @Date 2019年03月05日
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                                   + radius + ", x: " + x + ", y: " + y + "]");
    }
}
