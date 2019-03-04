/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.builder_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public abstract class Drink implements Item {

    public Packing packing() {
        return new Bottle();
    }
}
