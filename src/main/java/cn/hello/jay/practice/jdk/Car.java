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
}
