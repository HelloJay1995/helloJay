/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.bridge_pattern;

/**
 * 1.创建桥接实现接口
 *
 * @author 周健以
 * @Date 2019年03月05日
 */
public interface DrawAPI {

    /**
     * 画圆
     *
     * @param radius 半径
     * @param x      圆心横坐标
     * @param y      圆心纵坐标
     */
    void drawCircle(int radius, int x, int y);
}
