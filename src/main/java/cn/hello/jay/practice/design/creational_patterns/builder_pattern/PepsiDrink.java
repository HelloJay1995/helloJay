/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.builder_pattern;

/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class PepsiDrink extends Drink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
