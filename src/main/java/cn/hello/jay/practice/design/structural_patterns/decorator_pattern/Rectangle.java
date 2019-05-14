package cn.hello.jay.practice.design.structural_patterns.decorator_pattern;

/**
 * 2.创建实现类
 *
 * @author 周健以
 * @Date 2019年03月27日
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("画长方形");
    }
}
