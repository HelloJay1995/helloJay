/**
 *
 */
package cn.hello.jay.practice.jdk;

/**
 * @author 周健以
 * @Date 2019年01月14日
 */
public class Tiguan extends SUV{

    private String name = "tiguan";

    public Tiguan(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
