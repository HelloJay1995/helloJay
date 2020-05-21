/**
 *
 */
package cn.hello.jay.practice.jdk;

import lombok.AllArgsConstructor;

/**
 * @author 周健以
 * @Date 2019年01月14日
 */
@AllArgsConstructor
public class Car {

    private String name = "car";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        Car a = new Car("AAA");
        Car b = new Car("BBB");
        System.out.println("a:" + a + ",name:" + a.name);
        System.out.println("b:" + b + ",name:" + b.name);
        swap(a, b);
        System.out.println("a:" + a + ",name:" + a.name);
        System.out.println("b:" + b + ",name:" + b.name);
    }

    private static void swap(Car x, Car y) {
        Car temp = x;
        x = y;
        y = temp;

        System.out.println("x:" + x + ",name:" + x.name);
        System.out.println("y:" + y + ",name:" + y.name);
    }
}
