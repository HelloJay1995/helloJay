package cn.hello.jay.practice.design.structural_patterns.composite_pattern;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周健以
 * @Date 2019年03月27日
 */
@NoArgsConstructor
public class Employee {

    /**
     * 姓名
     */
    private String name;
    /**
     * 职位
     */
    private String dept;
    /**
     * 薪资
     */
    private Integer salary;
    /**
     * 下属员工
     */
    private List<Employee> subordinates = new ArrayList<>();

    public Employee(String name, String dept, Integer salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                       "name='" + name + '\'' +
                       ", dept='" + dept + '\'' +
                       ", salary=" + salary +
                       '}';
    }
}
