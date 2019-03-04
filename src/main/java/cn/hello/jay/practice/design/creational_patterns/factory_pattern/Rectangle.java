/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.factory_pattern;

/**
 * 创建实现接口的实现类--圆角矩形
 *
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("圆角矩形");
    }

}
