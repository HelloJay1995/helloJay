/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.square;

/**
 * 创建实现接口的实现类--矩形
 *
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("矩形");
    }

}
