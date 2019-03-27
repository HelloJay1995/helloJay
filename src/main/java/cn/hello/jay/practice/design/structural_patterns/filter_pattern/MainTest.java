/**
 *
 */
package cn.hello.jay.practice.design.structural_patterns.filter_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周健以
 * @Date 2019年03月06日
 */
public class MainTest {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria single = new CriteriaSingle();
        AndCriteria criteria = new AndCriteria(male, single);

        printPersons(criteria.meetCriteria(persons));

    }

    /**
     * 打印数据
     *
     * @param persons
     */
    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                                       + ", Gender : " + person.getGender()
                                       + ", Marital Status : " + person.getMaritalStatus()
                                       + " ]");
        }
    }
}
