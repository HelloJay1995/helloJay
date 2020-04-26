package cn.hello.jay.practice.reflect;

/**
 * @author 周健以
 * @Date 2020年03月12日
 */
public class Teacher implements People {
    @Override
    public String work() {
        System.out.println("老师教书育人");
        return "教书";
    }
}
