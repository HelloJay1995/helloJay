/**
 * Copyright (C), 2011-2019, 微贷网.
 */
package cn.hello.jay.practice.design.prototype_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class MainTest {
    public static void main(String[] args) {
        // 加载数据
        ShapeCache.loadCache();
        // 获取克隆实例
        Shape shape = ShapeCache.getShape("1");
        // 获取类型
        System.out.println(shape.getType());
    }
}
