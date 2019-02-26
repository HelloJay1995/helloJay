/**
 * Copyright (C), 2011-2019, 微贷网.
 */
package cn.hello.jay.practice.jdk;

/**
 * @author 周健以
 * @Date 2019年01月14日
 */
public class SUV extends Car {
    private String name = "suv";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
