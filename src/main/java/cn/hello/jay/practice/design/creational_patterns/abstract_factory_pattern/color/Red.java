/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.abstract_factory_pattern.color;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("红色");
    }
}
