/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.factory_pattern;

/**
 * 创建实现接口的实现类--圆形
 *
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("圆形");
    }

}
