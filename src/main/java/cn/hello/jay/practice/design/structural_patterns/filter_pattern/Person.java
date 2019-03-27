/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.filter_pattern;

/**
 * 1.创建一个类，在该类上应用标准
 *
 * @author 周健以
 * @Date 2019年03月05日
 */
public class Person {
    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}
