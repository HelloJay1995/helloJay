/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.builder_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
