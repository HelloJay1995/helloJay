/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.bridge_pattern;

/**
 * 3. 使用 DrawAPI 接口创建抽象类 Shape。
 *
 * @author 周健以
 * @Date 2019年03月05日
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    /**
     * 绘画
     */
    public abstract void draw();
}
